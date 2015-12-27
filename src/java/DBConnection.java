
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fahmy
 */
public class DBConnection {
    private String dbUrl = "jdbc:mysql://localhost:3306/bookingSystem";
    private String user = "root";
    private String dbpassword = "";
    private Connection con = null;

    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
            con = DriverManager.getConnection(dbUrl, user, dbpassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Connection getConnection() {
        return con;
    }    
    
}
