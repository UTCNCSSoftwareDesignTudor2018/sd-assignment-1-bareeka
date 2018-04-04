package data.data_access;

import com.mysql.jdbc.Statement;
import data.connection.ConnectionFactory;
import data.models.Course;
import data.models.Enrollment;
import data.models.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Mortimer on 3/28/2018.
 */
public class EnrollmentDAO extends TableBuilder {

    private static final String insertString = "INSERT INTO enrollments (studentid,courseid, grade)" + " VALUES (?,?,?)";
    private static final String findString = "SELECT * FROM enrollments where id = ?";
    private static final String deleteString = "DELETE FROM enrollments WHERE id = ?";
    private static final String isEnrolledString = "SELECT * FROM enrollments WHERE studentid = ? AND courseid = ?";

    public static Enrollment findById(int id){

        Connection myCon = ConnectionFactory.makeConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        Enrollment enrollment = null;
        try {
            findStatement = myCon.prepareStatement(findString);
            findStatement.setLong(1, id);
            rs = findStatement.executeQuery();
            rs.next();
            int studentid = rs.getInt("studentid");
            int courseid = rs.getInt("courseid");
            int grade = rs.getInt("grade");
            enrollment = new Enrollment(id, studentid, courseid, grade);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ConnectionFactory.close(myCon);
        ConnectionFactory.close(findStatement);
        ConnectionFactory.close(rs);
        return enrollment;
    }

    public static int insert(Enrollment enrollment){
        Connection myCon = ConnectionFactory.makeConnection();
        PreparedStatement insertStatement = null;
        ResultSet rs = null;
        int inserted = 0;

        try{
            insertStatement = myCon.prepareStatement(insertString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, enrollment.getStudent_id());
            insertStatement.setInt(2, enrollment.getCourse_id());
            insertStatement.setInt(3, enrollment.getGrade());
            insertStatement.executeUpdate();
            rs = insertStatement.getGeneratedKeys();
            if(rs.next()){
                inserted = rs.getInt(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        ConnectionFactory.close(insertStatement);
        ConnectionFactory.close(myCon);
        ConnectionFactory.close(rs);
        return inserted;
    }

    public DefaultTableModel enrollmentsTable(Student student){

        Connection mycon = ConnectionFactory.makeConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        DefaultTableModel courseTable = null;
        try {
            stat = mycon.prepareStatement("SELECT * FROM enrollments WHERE studentid =?");
            stat.setLong(1, student.getId());
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

    public boolean isEnrolled(Student student, int courseid){
        Connection mycon = ConnectionFactory.makeConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        ArrayList<Enrollment> foundList = null;
        try{
            stat = mycon.prepareStatement(isEnrolledString);
            stat.setInt(1,student.getId());
            stat.setInt(2,courseid);
            rs = stat.executeQuery();
            if (!rs.next()) {
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return true;
    }


}
