package BusinessModels;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


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
    public Integer id;
    public String name;
    public String email;
    public String password;    
    
    public void update(String name,String password) {
        if (name == null || name.length() == 0) {
            name = this.name;
        }
        if (password == null || password.length() == 0) {
            password = this.password;
        }
        Connection con = new DBConnection().getConnection();
        Statement stmt;
        try {
            stmt = con.createStatement();
            String update = "update user set name='" + name + "' , password='"+
                    password+"' where id='" + this.id + "' ;";
            stmt.executeUpdate(update);
        } catch (SQLException ex) {
        }

    }
}
