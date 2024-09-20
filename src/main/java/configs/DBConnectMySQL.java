package configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectMySQL {
    private static String USERNAME = "root";
    private static String PASSWORD = "root";
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/ltwebct3";

    public static Connection getDatabaseConnection() throws SQLException, Exception {
        try {
            Class.forName(DRIVER);  // Load the JDBC driver class
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);  // Establish the connection to the database
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();  // Print the error stack trace if an SQLException occurs
        }
        return null;  // Return null if connection failed
    }

    public static void main(String[] args) {
        try {
            new DBConnectMySQL();
            System.out.println(DBConnectMySQL.getDatabaseConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
