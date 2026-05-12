package controller;

import domain.DomainObject;
import domain.Sluzbenik;
import domain.Smena;
import domain.Student;
import java.util.List;
import so.AddShiftSO;
import so.AddStudentSO;
import so.DeleteStudentSO;
import so.GetAllFacultiesSO;
import so.GetAllShiftsSO;
import so.GetAllStudentsSO;
import so.LoginSO;
import so.SearchStudentsSO;
import so.UpdateStudentSO;


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
}
