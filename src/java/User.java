
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
public class User {
    
    public String name;
    public String email;
    public String password;    
    public Integer id;
    
    public void update(String name,String password) {
        System.out.println("*****************");
        System.out.println(this.name + " " + this.password);
        if (name == null || name.length() == 0) {
            System.out.println("name is empty");
            name = this.name;
        }
        if (password == null || password.length() == 0) {
            System.out.println("password is empty");
            password = this.password;
        }
        Connection con = new DBConnection().getConnection();
        Statement stmt;
        try {
            stmt = con.createStatement();
            String update = "update user set name='" + name + "' , password='"+
                    password+"' where id='" + this.id + "' ;";
            System.out.println("**********************");
            System.out.println(update);
            System.out.println("**********************");
            stmt.executeUpdate(update);
        } catch (SQLException ex) {
            Logger.getLogger(signUp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
