package business.bll;

import data.data_access.CourseDAO;
import data.models.Course;
import data.models.Student;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Mortimer on 3/28/2018.
 */
public class CourseBLL {
    private CourseDAO courseDAO;

    public CourseBLL(){
        this.courseDAO = new CourseDAO();
    }

    public Course findById(int id){
        return courseDAO.findById(id);
    }

    public ArrayList<Course> findAll(){
        return courseDAO.findAll();
    }

    public JTable courseToTable(){
        return courseDAO.coursesToTable();
    }

}
