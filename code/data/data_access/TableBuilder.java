package data.data_access;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class TableBuilder {

    public TableBuilder(){

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
