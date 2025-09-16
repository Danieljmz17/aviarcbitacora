
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class conexion {
    
    
     private static final String URL = "jdbc:mysql://localhost:3306/aviarc";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "eduardo";

    private Connection con = null;
    
    
    PreparedStatement ps;
    ResultSet rs;

    public Connection getConection() {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
    
    
}
