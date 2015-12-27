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
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fahmy
 */
public class Trip {
    public Integer id;
    public String position;
    public String destination;
    public String note;
    public Float price;
    public Time time;
    
    
    static public ArrayList<Trip> getAllTrips() {
        Connection con = new DBConnection().getConnection();
        String q = "select * from train;";
        ResultSet res;
        try {
            Statement stmt = con.createStatement();
            res = stmt.executeQuery(q);
            ArrayList<Trip> ret = new ArrayList<Trip>();
            while(res.next()) {
                Trip t = new Trip();
                t.id = res.getInt("id");
                t.position = res.getString("position");
                t.destination = res.getString("destination");
                t.note = res.getString("note");
                t.price = res.getFloat("price");
                t.time = res.getTime("time");
                ret.add(t);
            }
            return ret;
        } catch (SQLException ex) {
            Logger.getLogger(Train.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<Trip>();

    }
}
