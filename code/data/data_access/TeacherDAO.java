package data.data_access;

import com.mysql.jdbc.Statement;
import data.connection.ConnectionFactory;
import data.models.Teacher;
import data.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Mortimer on 3/28/2018.
 */
public class TeacherDAO {

    private static final String insertString = "INSERT INTO teachers (userid)" + " VALUES (?)";
    private static final String findString = "SELECT * FROM teachers where userid = ?";
    private static final String deleteString = "DELETE FROM teachers WHERE id = ?";

    public static Teacher findById(int id){

        Connection myCon = ConnectionFactory.makeConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        Teacher teacher = null;
        try {
            findStatement = myCon.prepareStatement(findString);
            findStatement.setLong(1, id);
            rs = findStatement.executeQuery();
            rs.next();
            int user_id = rs.getInt("userid");
            teacher = new Teacher(id, user_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ConnectionFactory.close(myCon);
        ConnectionFactory.close(findStatement);
        ConnectionFactory.close(rs);
        return teacher;
    }

    public static Teacher findByUser(User user){

        Connection myCon = ConnectionFactory.makeConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        Teacher teacher = null;
        try {
                findStatement = myCon.prepareStatement(findString);
                findStatement.setLong(1, user.getId());
                rs = findStatement.executeQuery();
                rs.next();
                int user_id = rs.getInt("userid");
                teacher = new Teacher(user.getId(), user_id);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        ConnectionFactory.close(myCon);
        ConnectionFactory.close(findStatement);
        ConnectionFactory.close(rs);
        return teacher;
    }

    public static int insert(Teacher teacher){
        Connection myCon = ConnectionFactory.makeConnection();
        PreparedStatement insertStatement = null;
        ResultSet rs = null;
        int inserted = 0;

        try{
            insertStatement = myCon.prepareStatement(insertString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, teacher.getUser_id());
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





}
