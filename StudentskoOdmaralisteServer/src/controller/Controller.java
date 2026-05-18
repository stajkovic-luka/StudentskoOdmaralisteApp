package controller;

import domain.DomainObject;
import domain.FakturaOdmora;
import domain.Nocenje;
import domain.Sluzbenik;
import domain.Smena;
import domain.Student;
import java.util.List;
import so.AddShiftSO;
import so.AddStudentSO;
import so.CreateStudentSO;
import so.DeleteStudentSO;
import so.FindStudentByIdSO;
import so.GetAllFacultiesSO;
import so.GetAllInvoicesSO;
import so.GetAllNocenjeSO;
import so.GetAllShiftsSO;
import so.GetAllStudentsSO;
import so.LoginSO;
import so.SearchInvoiceSO;
import so.SearchStudentsSO;
import so.UpdateStudentSO;
import so.FindInvoiceByIdSO;
import so.CreateInvoiceObjectSO;
import so.CreateInvoiceSO;


public class Controller {
    
    // SK8
    public Sluzbenik login(Sluzbenik sluzbenik) throws Exception {
        LoginSO login = new LoginSO();
        login.execute(sluzbenik);
        return login.getSluzbenik();
    }
    
    // SK21
    public List<DomainObject> getAllShifts() throws Exception {
        GetAllShiftsSO so = new GetAllShiftsSO();
        so.execute(new Smena());
        return so.getShifts();
    }
    
    // SK21
    public void addShift(Smena smena) throws Exception {
        AddShiftSO so = new AddShiftSO();
        so.execute(smena);
    }
    
    // SK4
    public List<DomainObject> getAllFaculties() throws Exception {
        GetAllFacultiesSO so = new GetAllFacultiesSO();
        so.execute(new domain.Fakultet());
        return so.getFaculties();
    }
    
    // SK4
    public void addStudent(Student student) throws Exception {
        AddStudentSO so = new AddStudentSO();
        so.execute(student);
    }
    
    // SK4, SK5, SK6, SK7
    public List<DomainObject> getAllStudents() throws Exception {
        GetAllStudentsSO so = new GetAllStudentsSO();
        so.execute(new Student());
        return so.getStudents();
    }

    // SK7
    public void deleteStudent(Student student) throws Exception {
        DeleteStudentSO so = new DeleteStudentSO();
        so.execute(student);
    }

    // SK6
    public void updateStudent(Student student) throws Exception {
        UpdateStudentSO so = new UpdateStudentSO();
        so.execute(student);
    }

    // SK5
    public List<DomainObject> searchStudents(Student student) throws Exception {
        SearchStudentsSO so = new SearchStudentsSO();
        so.execute(student);
        return so.getStudents();
    }

    // SK5, SK6, SK7
    public DomainObject findStudentById(Student student) throws Exception {
        FindStudentByIdSO so = new FindStudentByIdSO();
        so.execute(student);
        return so.getStudent();
    }

    // SK4
    public Student createStudent() throws Exception {
        CreateStudentSO so = new CreateStudentSO();
        so.execute(new Student());
        return so.getStudent();
    }

    // SK2
    public List<DomainObject> searchInvoices(FakturaOdmora faktura) throws Exception {
        SearchInvoiceSO so = new SearchInvoiceSO();
        so.execute(faktura);
        return so.getFakture();
    }

    // SK2
    public List<DomainObject> getAllInvoices() throws Exception {
        GetAllInvoicesSO so = new GetAllInvoicesSO();
        so.execute(new FakturaOdmora());
        return so.getFakture();
    }

    // SK2
    public FakturaOdmora findInvoiceById(FakturaOdmora faktura) throws Exception {
        FindInvoiceByIdSO so = new FindInvoiceByIdSO();
        so.execute(faktura);
        return so.getFaktura();
    }

    // SK1, SK2, SK3
    public List<DomainObject> getAllNocenje() throws Exception {
        GetAllNocenjeSO so = new GetAllNocenjeSO();
        so.execute(new Nocenje());
        return so.getNocenja();
    }

    // SK1
    public void createInvoice(FakturaOdmora faktura) throws Exception {
        CreateInvoiceSO so = new CreateInvoiceSO();
        so.execute(faktura);
    }

    // SK1
    public FakturaOdmora createInvoiceObject() throws Exception {
        CreateInvoiceObjectSO so = new CreateInvoiceObjectSO();
        so.execute(new FakturaOdmora());
        return so.getFaktura();
    }
}
