package student_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentDBConnection {
    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/school_db";
    private static final String username = "root";
    private static final String password = "2704";

    public static Connection getConnection() throws SQLException {
    	return DriverManager.getConnection(jdbcUrl, username, password); 	
    }
}
//public static Connection getConnection() throws SQLException, ClassNotFoundException {
//return DriverManager.getConnection(jdbcUrl, username, password);
//}