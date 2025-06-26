# Studentsko odmaralište – Vacation Reservation System

## Project Description

This is a Java-based software system for managing vacation reservations at a student resort. The system enables efficient handling of reservations, users, and reference data, with clearly defined roles and functionalities according to the project documentation.

## Key Entities

- **Sluzbenik** 
- **Student**
- **Fakultet** 
- **Smena** 
- **SluzbenikSmena**
- **Nocenje** 
- **FakturaOdmora** 
- **StavkaFakture** 

## Use Cases

- UC1: Create FakturaOdmora 
- UC2: Search FakturaOdmora
- UC3: Update FakturaOdmora
- UC4: Create Student
- UC5: Search Student
- UC6: Update Student
- UC7: Delete Student
- UC8: Login Sluzbenik 
- UC21: Create Fakultet

## Technology Stack

- Java SE
- JDBC
- MySQL

## How to Run

1. Clone the repository
git clone https://github.com/stajkovic-luka/StudentskoOdmaralisteApp.git
2. Set up the database using the provided SQL script (`studentsko_odmaraliste.sql`).
3. Configure the database connection in the configuration file or directly in the code.
4. Build and run the application

## Project Structure

The project is divided into three main parts: **Client**, **Common**, and **Server**, each with its own package structure and responsibilities.

### Client Side Packages

- `controller/` – Contains controller classes managing client-side logic and interactions.
- `forma/` – Contains all GUI forms used on the client side.
- `image/` – Contains logo and other image resources for the client.
- `main/` – Contains the main class responsible for launching the client application.
- `table/` – Contains table models used for displaying data in client-side tables.

### Common Packages

- `domain/` – Contains entity classes and the `DomainObject` interface which abstracts database operations.
- `transfer/` – Contains classes responsible for data transfer via streams and sockets between client and server.

### Server Side Packages

- `controller/` – Contains server-side controller classes managing server logic.
- `form/` – Contains server-side forms.
- `image/` – Contains logo and image resources for the server.
- `so/` – Contains system operations implementing use cases (e.g., `LoginSO`) and the abstract base class `AbstractSO`.
- `table/` – Contains table models used on the server side.
- `threads/` – Contains server thread classes managing client connections and regulating client operations in this multithreaded application. Includes client handler threads for individual client sessions.

## Author

Luka Stajković  
Faculty of Organizational Sciences (FON), University of Belgrade  
