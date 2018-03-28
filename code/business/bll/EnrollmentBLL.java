package business.bll;

import data.data_access.EnrollmentDAO;
import data.models.Course;
import data.models.Enrollment;
import data.models.Student;

import javax.swing.*;

/**
 * Created by Mortimer on 3/28/2018.
 */
public class EnrollmentBLL {
    private EnrollmentDAO enrollmentDAO;

    public EnrollmentBLL(){
        this.enrollmentDAO = new EnrollmentDAO();
    }

    public Enrollment findById(int id){
        return enrollmentDAO.findById(id);
    }

    public void enroll(Course course, Student student){
        try{
            Enrollment e = new Enrollment();
            e.setStudent_id(student.getId());
            e.setCourse_id(course.getId());
            enrollmentDAO.insert(e);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public JTable enrollmentsTable(Student student){
        return enrollmentDAO.enrollmentsTable(student);
    }



}
