package transfer;

public enum Operation {

    // SK8 - Login/Logout
    LOGIN,
    LOGOUT,

    // SK1 - Kreiraj fakturu odmora (placeholder INSERT → dobijanje ID)
    CREATE_INVOICE,
    // SK1 - Zapamti fakturu (UPDATE placeholder + INSERT stavki)
    SAVE_INVOICE,
    // SK1 - Odustani od kreiranja (DELETE placeholder)
    DELETE_INVOICE,

    // SK2 - Pretraži fakturu odmora
    FIND_INVOICE,
    FIND_INVOICE_BY_ID,

    // SK3 - Promeni fakturu odmora
    UPDATE_INVOICE,

    // SK4 - Kreiraj student (placeholder INSERT → dobijanje ID)
    CREATE_STUDENT,

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
    GET_ALL_STUDENTS,

    // SK1, SK2, SK3
    GET_ALL_NOCENJE,
    GET_ALL_INVOICES
}
