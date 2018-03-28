package data.data_access;

import data.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by Mortimer on 3/28/2018.
 */
public class GeneralDAO {

    private static final String deleteString = "DELETE FROM students WHERE id = ?";

    public static void delete(int id){
        Connection myCon = ConnectionFactory.makeConnection();
        PreparedStatement deleteStatement = null;
        int affectedRows = 0;
        try{
            deleteStatement = myCon.prepareStatement(deleteString);
            deleteStatement.setInt(1,id);
            deleteStatement.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }

        ConnectionFactory.close(deleteStatement);
        ConnectionFactory.close(myCon);
    }
}
