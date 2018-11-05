package repository.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
   private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   private static final String DATA_BASE_URL = "jdbc:mysql://localhost/developers";
   private static final String USER = "root";
   private static final String PASSWORD = "root";
   private static Connection connection;

   static public Connection getConnection()  {
       try {
           Class.forName(JDBC_DRIVER);
       } catch (ClassNotFoundException e) {
           System.out.println("Failed to register driver.");
       }
       try {
           connection = DriverManager.getConnection(DATA_BASE_URL,USER,PASSWORD);
       } catch (SQLException e) {
           System.out.println("Failed to get connection.");
       }
        return connection;
    }
    static public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("error closing connection");
        }
    }
}
