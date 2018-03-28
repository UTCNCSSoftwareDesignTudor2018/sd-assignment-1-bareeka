package data.data_access;

import data.connection.ConnectionFactory;
import data.models.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Mortimer on 3/28/2018.
 */
public class LoginDAO{
    private static final String insertString = "INSERT INTO logins (username,password,role)" + " VALUES (?,?,?)";
    private static final String findString = "SELECT * FROM logins where id = ?";
    private static final String findUsernameString = "SELECT * FROM logins where username = ?";
    private static final String deleteString = "DELETE FROM logins WHERE id = ?";
    private static final String updateString = "UPDATE logins SET username = ?, password = ? WHERE id = ?";

    public static Login findById(int id){

        Connection myCon = ConnectionFactory.makeConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        Login login = null;
        try {
            findStatement = myCon.prepareStatement(findString);
            findStatement.setLong(1, id);
            rs = findStatement.executeQuery();
            rs.next();
            String username = rs.getString("username");
            String password = rs.getString("password");
            int role = rs.getInt("role");
            login = new Login(id, username, password, role);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ConnectionFactory.close(myCon);
        ConnectionFactory.close(findStatement);
        ConnectionFactory.close(rs);
        return login;
    }

    public static Login findByUsername(String username){

        Connection myCon = ConnectionFactory.makeConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        Login login = null;
        try {
            findStatement = myCon.prepareStatement(findUsernameString);
            findStatement.setString(1, username);
            rs = findStatement.executeQuery();
            rs.next();
            int id = rs.getInt("id");
            String password = rs.getString("password");
            int role = rs.getInt("role");
            login = new Login(id, username, password, role);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ConnectionFactory.close(myCon);
        ConnectionFactory.close(findStatement);
        ConnectionFactory.close(rs);
        return login;
    }

    public static void update(Login login){
        Connection myCon = ConnectionFactory.makeConnection();
        PreparedStatement updateStatement = null;
        try{
            updateStatement = myCon.prepareStatement(updateString);
            updateStatement.setString(1, login.getUsername());
            updateStatement.setString(2, login.getPassword());
            updateStatement.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }

        ConnectionFactory.close(updateStatement);
        ConnectionFactory.close(myCon);
    }
}
