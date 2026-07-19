
package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/library_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Manasaj@04";

    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to MySQL Successfully!");
            return con;
        } catch (Exception e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
            return null;
        }
    }
}
