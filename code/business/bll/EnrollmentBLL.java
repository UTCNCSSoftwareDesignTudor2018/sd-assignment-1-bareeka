package business.bll;

import data.data_access.EnrollmentDAO;
import data.models.Course;
import data.models.Enrollment;
import data.models.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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

    public boolean enroll(Course course, Student student){
        try{
            Enrollment e = new Enrollment();
            e.setStudent_id(student.getId());
            e.setCourse_id(course.getId());

            if(!isEnrolled(student,course.getId()))
            enrollmentDAO.insert(e);
            return true;

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public boolean isEnrolled(Student student, int courseid){
       return enrollmentDAO.isEnrolled(student, courseid);
    }

    public DefaultTableModel enrollmentsTable(Student student){
        return enrollmentDAO.enrollmentsTable(student);
    }



}
