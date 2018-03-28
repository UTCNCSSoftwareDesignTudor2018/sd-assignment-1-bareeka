package data.data_access;

import com.mysql.jdbc.Statement;
import data.connection.ConnectionFactory;
import data.models.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

/**
 * Created by Mortimer on 3/27/2018.
 */
public class StudentDAO extends GeneralDAO {

    private static final String insertString = "INSERT INTO students (name, userid, group)" + " VALUES (?,?,?)";
    private static final String findString = "SELECT * FROM students where id = ?";
    private static final String deleteString = "DELETE FROM students WHERE id = ?";
    private static final String updateString = "UPDATE students SET name = ?, group = ?, userid = ? WHERE id = ?";



    public static Student findById(int id){

        Connection myCon = ConnectionFactory.makeConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        Student student = null;
        try {
            findStatement = myCon.prepareStatement(findString);
            findStatement.setLong(1, id);
            rs = findStatement.executeQuery();
            rs.next();
            int user_id = rs.getInt("userid");
            int group = rs.getInt("group");
            String name = rs.getString("name");
            student = new Student(id, name, group, user_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ConnectionFactory.close(myCon);
        ConnectionFactory.close(findStatement);
        ConnectionFactory.close(rs);
        return student;
    }

    public static int insert(Student student){
        Connection myCon = ConnectionFactory.makeConnection();
        PreparedStatement insertStatement = null;
        ResultSet rs = null;
        int inserted = 0;

        try{
            insertStatement = myCon.prepareStatement(insertString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, student.getName());
            insertStatement.setInt(3, student.getUser_id());
            insertStatement.setInt(2, student.getGroup());
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



    public static void update(Student student){
        Connection myCon = ConnectionFactory.makeConnection();
        PreparedStatement updateStatement = null;
        try{
            updateStatement = myCon.prepareStatement(updateString);
            updateStatement.setString(1, student.getName());
            updateStatement.setInt(2, student.getGroup());
            updateStatement.setInt(3, student.getUser_id());
            updateStatement.setInt(4, student.getId());
            updateStatement.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }

        ConnectionFactory.close(updateStatement);
        ConnectionFactory.close(myCon);
    }

    public JTable studentsToTable(){

        Connection mycon = ConnectionFactory.makeConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        JTable studentsTable = null;
        try {
            stat = mycon.prepareStatement("SELECT * FROM students");
            rs = stat.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            studentsTable = new JTable(buildTable(rs));
        } catch (SQLException e3) {
            e3.printStackTrace();
        }

        return studentsTable;


    }



    public static DefaultTableModel buildTable(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        Vector<String> colNames = new Vector<String>();
        int colCount = md.getColumnCount();
        for (int col = 1; col <= colCount; col++) {
            colNames.add(md.getColumnName(col));
        }

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int colIndex = 1; colIndex <= colCount; colIndex++) {
                vector.add(rs.getObject(colIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, colNames);
    }
}
