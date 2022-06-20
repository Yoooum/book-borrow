package net.yoooum.bms.database;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Yoooum
 */
public class Select {
    public static void main(String[] args) {

    }

    public ResultSet cardBook() {
        Select sql = new Select();
        try {
            return sql.select("SELECT * FROM book_info");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public ResultSet select(String sql) {
        try {
            Connect connect = new Connect();
            Statement stmt = connect.connect();
            ResultSet resultSet = stmt.executeQuery(sql);
            return resultSet;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
