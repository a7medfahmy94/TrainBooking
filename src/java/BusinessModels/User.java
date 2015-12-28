package BusinessModels;

import Servlets.signUp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;


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
    public boolean is_admin;
    
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
    
    public static User signIn(String email,String password) {
        String query = "select * from user where password = '"+ password+"' and email='"+ email+"'";
        Connection con = new DBConnection().getConnection();
        ResultSet res;
        Statement stmt;
        try {
            stmt = con.createStatement();
            res = stmt.executeQuery(query);
            if(!res.next()){
                return null;
            }else{
                User u = new User();
                u.id = res.getInt("id");
                u.email = res.getString("email");
                u.name = res.getString("name");
                u.password = res.getString("password");
                u.is_admin = res.getBoolean("is_admin");
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(signUp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void save() {
        Connection con = new DBConnection().getConnection();
        Statement stmt;
        try {
            stmt = con.createStatement();
            String insert = "insert into user (name, email, password, is_admin) VALUES('" +
                  name+"','"+ email+"','"+password+"',"+is_admin+");";
            stmt.executeUpdate(insert);
        } catch (SQLException ex) {
            Logger.getLogger(signUp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
