package businessModels;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hala
 */
public class Train {
    public String name;
    public Integer id;
    public Integer capacity;
    
    static public ArrayList<Train> getAllTrains() {
        Connection con = new DBConnection().getConnection();
        String q = "select * from train;";
        ResultSet res;
        try {
            Statement stmt = con.createStatement();
            res = stmt.executeQuery(q);
            ArrayList<Train> ret = new ArrayList<Train>();
            while(res.next()) {
                Train t = new Train();
                t.id = res.getInt("id");
                t.name = res.getString("name");
                t.capacity = res.getInt("capacity");
                ret.add(t);
            }
            return ret;
        } catch (SQLException ex) {
            Logger.getLogger(Train.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<Train>();
    }
    public void save(){
        Connection con = new DBConnection().getConnection();
        Statement stmt;
        try {
            stmt = con.createStatement();
            String insert = "insert into train (name,capacity) VALUES('" +
                  this.name+"','"+this.capacity+"');";
            stmt.executeUpdate(insert);

        } catch (SQLException ex) {
        }
    }
    public static void update(Integer id,String name,Integer capacity){
        Connection con = new DBConnection().getConnection();
        Statement stmt;
        String update = "update train set ";
        boolean iName=false , iCap=false;
        if(name != null && name.length() > 0){
            update += "name='"+name+"' ";
            iName=true;
        }
        if (capacity != null) {
            if(iName) update += ", ";
            update += "capacity=" + capacity;
            iCap = true;
        }
        if(!iName && !iCap) return;//no update
        
        update += " where id=" + id;
        System.out.println(update);
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(update);
            con.close();
        } catch (SQLException ex) {
        }
    }
}
