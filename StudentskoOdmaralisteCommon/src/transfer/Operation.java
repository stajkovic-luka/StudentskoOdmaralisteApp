package transfer;

public enum Operation {

    // SK8 - Login/Logout
    LOGIN,
    LOGOUT,

    // SK1 - Kreiraj fakturu odmora
    CREATE_INVOICE,

    // SK2 - Pretraži fakturu odmora
    FIND_INVOICE,

    // SK3 - Promeni fakturu odmora
    UPDATE_INVOICE,

    // SK4 - Kreiraj student
    CREATE_STUDENT,
    CREATE_STUDENT_OBJECT,

    // SK5 - Pretraži student
    FIND_STUDENT,
    FIND_STUDENT_BY_ID,

    // SK6 - Promeni student
    UPDATE_STUDENT,

    // SK7 - Obriši student
    DELETE_STUDENT,

    // SK21 - Ubaci smenu
    INSERT_SHIFT,
    GET_ALL_SHIFT,

    // SK4, SK5, SK6, SK7
    GET_ALL_FACULTIES,
    GET_ALL_STUDENTS
}
