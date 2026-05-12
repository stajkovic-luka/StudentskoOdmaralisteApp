package transfer;

public enum Operation {

    // SK8 - Login/Logout
    LOGIN,
    LOGOUT,

    // SK1 - Kreiraj rezervaciju
    CREATE_RESERVATION,

    // SK2 - Nadji rezervaciju
    FIND_RESERVATION,

    // SK3 - Obradi rezervaciju
    PROCESS_RESERVATION,

    // SK4 - Kreiraj studenta
    CREATE_STUDENT,

    // SK5 - Obrisi studenta
    DELETE_STUDENT,

    // SK6 - Izmeni studenta
    UPDATE_STUDENT,

    // SK7 - Pretrazi studenta
    FIND_STUDENT,

    // SK21 - Ubaci smenu
    INSERT_SHIFT,
    GET_ALL_SHIFT,

    // SK4, SK6, SK7 - Pomocne operacije za studente
    GET_ALL_FACULTIES,
    GET_ALL_STUDENTS
}
