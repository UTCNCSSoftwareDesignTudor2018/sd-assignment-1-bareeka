package data.data_access;

import com.mysql.jdbc.Statement;
import data.connection.ConnectionFactory;
import data.models.Course;
import data.models.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Mortimer on 3/28/2018.
 */
public class CourseDAO extends TableBuilder{

        private static final String insertString = "INSERT INTO courses (name,desc)" + " VALUES (?,?)";
        private static final String findString = "SELECT * FROM courses where id = ?";
        private static final String findAllString = "SELECT * FROM courses";
        private static final String deleteString = "DELETE FROM courses WHERE id = ?";
        private static final String updateString = "UPDATE courses SET name = ?, desc = ? WHERE id = ?";

    public static Course findById(int id){

        Connection myCon = ConnectionFactory.makeConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        Course course = null;
        try {
            findStatement = myCon.prepareStatement(findString);
            findStatement.setLong(1, id);
            rs = findStatement.executeQuery();
            rs.next();
            String name = rs.getString("name");
            String desc = rs.getString("desc");
            course = new Course(id, name, desc);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ConnectionFactory.close(myCon);
        ConnectionFactory.close(findStatement);
        ConnectionFactory.close(rs);
        return course;
    }

    public ArrayList<Course> findAll(){
        Connection myCon = ConnectionFactory.makeConnection();
        ArrayList<Course> courseList = new ArrayList<Course>();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = myCon.prepareStatement(findAllString);
            rs = findStatement.executeQuery();
            while(rs.next()){
                Course c = new Course(rs.getInt("id"),rs.getString("name"),rs.getString("desc"));
                courseList.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ConnectionFactory.close(myCon);
        ConnectionFactory.close(findStatement);
        ConnectionFactory.close(rs);
        return courseList;

    }

    public DefaultTableModel coursesToTable(){

        Connection mycon = ConnectionFactory.makeConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        DefaultTableModel courseTable = null;
        try {
            stat = mycon.prepareStatement("SELECT * FROM courses");
            rs = stat.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            courseTable = buildTable(rs);
        } catch (SQLException e3) {
            e3.printStackTrace();
        }

        return courseTable;


    }


}
