package business.bll;

import data.data_access.CourseDAO;
import data.models.Course;
import data.models.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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

    public DefaultTableModel courseToTable(){
        return courseDAO.coursesToTable();
    }

}
