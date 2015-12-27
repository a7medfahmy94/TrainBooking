/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModels;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fahmy
 */
public class Train {
    public String name;
    public int id;
    public int capacity;
    
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
}
