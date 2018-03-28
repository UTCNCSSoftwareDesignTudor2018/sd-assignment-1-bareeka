package data.connection;
import java.sql.*;

/**
 * Created by Mortimer on 3/27/2018.
 */
public class ConnectionFactory {

    private static final String DB = "jdbc:mysql://localhost:3306/studentmanagement";
    private static final String USER = "root";
    private static ConnectionFactory singleI = new ConnectionFactory();


    private ConnectionFactory(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection makeConnection(){
        Connection myCon = null;
        try{
                myCon = DriverManager.getConnection(DB,USER,"");
        }catch(Exception e){
            e.printStackTrace();
        }
        return myCon;
    }

    public static void close(Connection con){
        try{
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public  static void close(ResultSet rs){
        try{
            rs.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void close(Statement statement){
        try{
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
