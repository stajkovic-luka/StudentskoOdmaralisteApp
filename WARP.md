# WARP.md

This file provides guidance to WARP (warp.dev) when working with code in this repository.

## Repository Overview

This is a Java SE client/server desktop application for managing vacation reservations at a student resort. Data is persisted in a MySQL database defined by `Database i connector/studentsko_odmaraliste.sql`. The system works with entities such as `Sluzbenik`, `Student`, `Fakultet`, `Smena`, `Nocenje`, `FakturaOdmora`, `StavkaFakture`, and their relations.

The main use cases include creating, searching, updating, and deleting students and invoices (`FakturaOdmora`), and logging in `Sluzbenik` users.

The project is organized as three NetBeans/Ant-based Java modules:

- `StudentskoOdmaralisteCommon` – shared domain model and network transfer classes
- `StudentskoOdmaralisteServer` – backend server, DB access, and server-side GUI
- `StudentskoOdmaralisteClient` – client-side GUI and communication layer

## Architecture and Module Responsibilities

### Common module (`StudentskoOdmaralisteCommon`)

**Domain and persistence abstraction**

- `domain.DomainObject` defines how domain entities map to SQL operations:
  - `tableName()`, `selectColumns()`
  - `selectWhereClause()` and `bindSelectParams(PreparedStatement)`
  - `mapOne(ResultSet)` / `mapMany(ResultSet)`
- Concrete domain classes (`Student`, `Fakultet`, `Sluzbenik`, `Nocenje`, `FakturaOdmora`, `StavkaFakture`, `Smena`, `SluzbenikSmena`) typically implement `DomainObject` and encapsulate both data and SQL-mapping logic.

**Network transfer layer**

- `transfer.Operation` enum lists all supported operations (e.g. `LOGIN`, `CREATE_STUDENT`, `FIND_STUDENT`, `CREATE_RESERVATION`, `INSERT_SHIFT`, etc.).
- `transfer.Request` wraps an `Operation` and an arbitrary `argument` object (often a `DomainObject` or DTO).
- `transfer.Response` wraps a `serverResponse` payload plus an optional `Exception` if the server-side operation failed.
- `transfer.Sender` / `transfer.Receiver` handle sending/receiving serialized objects over a `Socket` using object streams.

Any new cross-cutting use case typically involves:

1. Adding a new `Operation` to `transfer.Operation`.
2. Ensuring both client and server understand the payload types (usually via shared domain classes in this module).

### Server module (`StudentskoOdmaralisteServer`)

**Startup and GUI**

- `main.StartServer` is the entry point and constructs the main server GUI (`form.ServerskaForma`), which manages server lifecycle and displays currently logged-in `Sluzbenik` users.

**Networking and threading model**

- `threads.ServerThread` owns a `ServerSocket` listening on port `9000` and an in-memory list of `ClientThread` instances.
  - Accepts client connections in a loop, creates a `ClientThread` per connection, and keeps track of logged-in users to refresh `ServerskaForma`.
  - `stopServer()` closes the `ServerSocket` and asks each `ClientThread` to terminate and close its client socket.
- `threads.ClientThread` handles a single client connection:
  - Wraps its socket with `Sender`/`Receiver` from the common module.
  - Reads `Request` objects in a loop, dispatches them by `Operation`, and populates a `Response`.
  - Currently, only `Operation.LOGIN` is implemented; adding more use cases means extending the `switch` in this class and delegating to new system operations.
  - Keeps track of the `Sluzbenik` associated with the session so the server UI can show logged-in users.

**Application controller and system operations (SO)**

- `controller.Controller` exposes high-level methods such as `login(Sluzbenik)`. Methods typically:
  - Instantiate a corresponding `so.*` class (e.g. `LoginSO`).
  - Call its `execute(object)` method.
  - Extract and return domain results.
- `so.AbstractSO` centralizes transactional DB logic around a `DBBroker`:
  - Constructor obtains a pooled `Connection` from `DBConnection` and wraps it in a `DBBroker`.
  - `execute(Object)` calls `validate(object)`, then `executeOperation(object)` inside a `try/catch`, committing or rolling back and always returning the connection to the pool.
  - Subclasses implement `validate` (type/semantic checks) and `executeOperation` (actual DB work via `DBBroker`).
- `so.LoginSO` is the canonical example of a system operation:
  - Validates that the argument is a `Sluzbenik`.
  - Uses `DBBroker.getSingleInstance(DomainObject)` to look up a matching `Sluzbenik` in the DB via the `DomainObject` mapping API.
  - Stores the resulting `Sluzbenik` and exposes it via `getSluzbenik()`.

To add new use cases, the pattern is:

1. Add an `Operation` value.
2. Implement an `AbstractSO` subclass in `so/` for the DB transaction.
3. Expose a method on `controller.Controller` that instantiates and calls the new SO.
4. Extend `ClientThread`'s `switch` to call the new controller method and populate the `Response`.

**Database access and configuration**

- `repository.DBConnection` implements a simple connection pool:
  - On initialization it reads `StudentskoOdmaralisteServer/config/db.properties` and opens up to 20 JDBC connections.
  - Connections are configured with `autoCommit=false` and returned to a `LinkedList`-based pool.
  - `fetchConnection()` and `returnToPool(Connection)` manage connection reuse.
- `repository.DBBroker` wraps a single `Connection` and executes `DomainObject`-driven queries (for now, focused on single-instance selects).
- DB configuration is externalized in `StudentskoOdmaralisteServer/config/db.properties` with keys:
  - `database.url`
  - `database.user`
  - `database.password`
- The schema and seed data live in `Database i connector/studentsko_odmaraliste.sql`. Run this script against a local MySQL/MariaDB instance before starting the server.

### Client module (`StudentskoOdmaralisteClient`)

**Startup and GUI**

- `main.StartClient` is the client entry point, showing the login form `form.LogInForma`.
- Other forms in `form/` implement the client-side UI for managing students, invoices, shifts, etc. They usually call the client `controller.Controller` for backend operations.

**Client controller and communication**

- `controller.Controller` encapsulates the TCP connection to the server:
  - In its constructor opens a `Socket("localhost", 9000)` and wraps it with `Sender` and `Receiver`.
  - Exposes methods (e.g. `login(String username, String password)`) that:
    - Construct appropriate domain objects (`Sluzbenik`) and wrap them in a `Request` with a given `Operation`.
    - Use `Sender`/`Receiver` to send the `Request` and wait for a `Response`.
    - Return the deserialized domain object from `Response.getServerResponse()` or surface exceptions.

Adding a new client-visible feature typically involves:

1. Adding UI logic (or a new form) that constructs the correct domain object(s).
2. Adding a method to the client `Controller` that sends a `Request` using a new or existing `Operation`.
3. Ensuring the server understands that `Operation` and payload shape.

## Database Setup

1. Ensure you have MySQL or MariaDB running locally.
2. Run `Database i connector/studentsko_odmaraliste.sql` to create the `studentsko_odmaraliste` database, tables, and seed data.
3. Configure DB connection settings in `StudentskoOdmaralisteServer/config/db.properties` using the keys:
   - `database.url` (e.g. `jdbc:mysql://localhost:3306/studentsko_odmaraliste`)
   - `database.user`
   - `database.password`
4. The server uses a connection pool initialized on first access to `DBConnection.getInstance()`; if connection settings are invalid, startup will fail when DB access is first attempted.

## Build, Run, and Test

This project uses Ant build scripts generated by NetBeans. All three modules assume JDK 17 (see `javac.source`/`javac.target` in each `nbproject/project.properties`). You will need:

- JDK 17 or compatible JDK installed and on your `PATH`.
- Apache Ant 1.8+ available as `ant`.
- A running MySQL/MariaDB instance with the schema from `Database i connector/studentsko_odmaraliste.sql`.

### Common patterns

Each module has a top-level `build.xml` that imports `nbproject/build-impl.xml`. The important Ant targets are:

- `clean` – remove `build/` and `dist/` outputs.
- `jar` – compile and build the main JAR.
- `run` – compile and run the module's `main.class`.
- `test` – compile and run all unit tests under `test/` (if any exist).
- `test-single` – run specific test classes when the `test.includes` property is set.

Refer to the module-specific commands below, replacing `<MODULE>` with the module directory name.

### Build order

1. Build the common library first:

   ```bash
   ant -f StudentskoOdmaralisteCommon/build.xml clean jar
   ```

   This produces `StudentskoOdmaralisteCommon/dist/StudentskoOdmaralisteCommon.jar`, which the client and server reference on their classpaths.

2. Then build the server and client:

   ```bash
   ant -f StudentskoOdmaralisteServer/build.xml clean jar
   ant -f StudentskoOdmaralisteClient/build.xml clean jar
   ```

### Running the server

With the DB configured and `StudentskoOdmaralisteCommon` built:

- Run via Ant (uses `main.StartServer` from `nbproject/project.properties`):

  ```bash
  ant -f StudentskoOdmaralisteServer/build.xml run
  ```

  This will show the server GUI (`ServerskaForma`) and start listening on TCP port `9000` via `threads.ServerThread`.

- Alternatively, after building, you can run the generated JAR directly if the classpath is correctly set for the common JAR and MySQL connector. The Ant-based `run` target is the simplest option because it wires the classpath for you.

### Running the client

Start the server first, then in a separate process:

```bash
ant -f StudentskoOdmaralisteClient/build.xml run
```

This launches `main.StartClient`, which displays the login form. The client connects to `localhost:9000`, so both client and server should run on the same machine by default.

### Running tests

The Ant scripts include standard NetBeans JUnit integration, even if the `test/` directories are currently empty.

- Run all tests for a module:

  ```bash
  # Example for the server module
  ant -f StudentskoOdmaralisteServer/build.xml test
  ```

- Run a single test class for a module (e.g. `SomeServiceTest`):

  ```bash
  ant -f StudentskoOdmaralisteServer/build.xml -Dtest.includes=**/SomeServiceTest.java test-single
  ```

  The pattern passed to `test.includes` should match the `.java` file under the module's `test/` source tree (package directories included as needed).

You can use the same pattern for `StudentskoOdmaralisteClient` and `StudentskoOdmaralisteCommon` as those modules share the same NetBeans/Ant structure.

### Linting / static analysis

There is no dedicated lint or static-analysis tool wired into the Ant build scripts. Any static analysis should be run via your IDE or custom tooling you add explicitly (e.g. additional Ant targets or external commands).

## Notes for Extending the System

- When introducing a new DB-backed concept, prefer creating a new `DomainObject` implementation in `StudentskoOdmaralisteCommon/src/domain/` and a corresponding table in the MySQL schema. Use `DBBroker` and `AbstractSO` subclasses on the server to perform transactional operations.
- New business operations should follow the existing `Operation` → `Request`/`Response` → server `Controller` → `so.AbstractSO` pattern, and be mirrored on the client side by adding controller methods and wiring them to forms.
- Changes to ports, hostnames, or DB credentials should be made in configuration points used by the code (for example, the client connects to `localhost:9000` in `StudentskoOdmaralisteClient/src/controller/Controller.java`, and the server reads DB settings from `StudentskoOdmaralisteServer/config/db.properties`).
