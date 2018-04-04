package business.bll;

import business.Validator;
import data.data_access.StudentDAO;
import data.models.Student;
import javax.swing.table.DefaultTableModel;

/**
 * Created by Mortimer on 3/28/2018.
 */
public class StudentBLL {

    private StudentDAO studentDAO;

    public StudentBLL(){
        this.studentDAO = new StudentDAO();
    }

    public Student findById(int id){
        return studentDAO.findById(id);
    }

    public void insertStudent(Student student){
        studentDAO.insert(student);
    }

    public void updateStudent(Student student){
        studentDAO.update(student);
    }

    public void deleteStudent(int id){
        studentDAO.delete(id);
    }

    public DefaultTableModel studentsToTable(){
        return studentDAO.studentsToTable();
    }
}
