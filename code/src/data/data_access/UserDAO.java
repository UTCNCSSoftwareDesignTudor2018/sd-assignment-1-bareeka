package data.data_access;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

import data.connection.ConnectionFactory;
import data.models.User;

/**
 * Created by Mortimer on 3/27/2018.
 */
public class UserDAO extends GeneralDAO {

    private static final String insertString = "INSERT INTO users (name, card_no,address,cnp,loginid)" + " VALUES (?,?,?,?,?)";
    private static final String findString = "SELECT * FROM users where id = ?";
    private static final String deleteString = "DELETE FROM users WHERE id = ?";
    private static final String updateString = "UPDATE users SET name = ?, card_no = ?, address = ?, cnp = ? WHERE id = ?";



    public static User findById(int id){

        Connection myCon = ConnectionFactory.makeConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        User user = null;
        try {
            findStatement = myCon.prepareStatement(findString);
            findStatement.setLong(1, id);
            rs = findStatement.executeQuery();
            rs.next();
            int loginid = rs.getInt("loginid");
            String card_no = rs.getString("card_no");
            String name = rs.getString("name");
            String cnp = rs.getString("cnp");
            String address = rs.getString("address");
            user = new User(id, loginid, card_no, name, address, cnp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ConnectionFactory.close(myCon);
        ConnectionFactory.close(findStatement);
        ConnectionFactory.close(rs);
        return user;
    }


    public static void update(User user){
        Connection myCon = ConnectionFactory.makeConnection();
        PreparedStatement updateStatement = null;
        try{
            updateStatement = myCon.prepareStatement(updateString);
            updateStatement.setString(1, user.getName());
            updateStatement.setString(2, user.getCard_no());
            updateStatement.setString(3, user.getAddress());
            updateStatement.setString(4, user.getCnp());
            updateStatement.setInt(5, user.getId());
            updateStatement.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }

        ConnectionFactory.close(updateStatement);
        ConnectionFactory.close(myCon);
    }

    public static int insert(User user){
        Connection myCon = ConnectionFactory.makeConnection();
        PreparedStatement insertStatement = null;
        ResultSet rs = null;
        int inserted = 0;

        try{
            insertStatement = myCon.prepareStatement(insertString, com.mysql.jdbc.Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, user.getName());
            insertStatement.setString(2, user.getCard_no());
            insertStatement.setString(3, user.getAddress());
            insertStatement.setString(4, user.getCnp());
            insertStatement.setInt(5, user.getLogin_id());
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
