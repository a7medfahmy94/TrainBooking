/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModels;

import java.sql.Connection;
import java.sql.Date;
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
    public Integer train_id;
    public String position;
    public String destination;
    public String note;
    public Integer price;
    public String datetime;
    
    public void save() {
        Connection con = new DBConnection().getConnection();
        String q = "insert into trip (position,destination,note,datetime,price,train_id) " +
                " values('"+position+"','"+destination+"','"+note+"','"+datetime+"',"+price+"," +
                train_id+");";
        
        System.out.println("*****************");
        System.out.println(q);
        System.out.println("*****************");
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(q);
        } catch (SQLException ex) {
            Logger.getLogger(Train.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void book(String userId, String tripId){
         Connection con = new DBConnection().getConnection();
        Statement stmt;
        try {
            stmt = con.createStatement();
            String insert = "insert into booked (trip_id,user_id) VALUES('" +
                  userId+"','"+ tripId+"');";
            stmt.executeUpdate(insert);

        } catch (SQLException ex) {
        }
    }
    
    static public ArrayList<Trip> getAllTrips() {
        Connection con = new DBConnection().getConnection();
        String q = "select * from trip;";
        ResultSet res;
        try {
            Statement stmt = con.createStatement();
            res = stmt.executeQuery(q);
            ArrayList<Trip> ret = new ArrayList<Trip>();
            while(res.next()) {
                Trip t = new Trip();
                t.id = res.getInt("id");
                t.train_id = res.getInt("train_id");
                t.position = res.getString("position");
                t.destination = res.getString("destination");
                t.note = res.getString("note");
                t.price = res.getInt("price");
                t.datetime = res.getDate("datetime").toString();
                ret.add(t);
            }
            return ret;
        } catch (SQLException ex) {
            Logger.getLogger(Train.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<Trip>();
    }
    
    static public ArrayList<Trip> getUserTrips(String userId) {
        Connection con = new DBConnection().getConnection();
        String q = "select * from trip left join booked on trip.id=booked.trip_id where " + userId + "=booked.user_id;" ;

        ResultSet res;
        try {
            Statement stmt = con.createStatement();
            res = stmt.executeQuery(q);
            ArrayList<Trip> ret = new ArrayList<Trip>();
            while(res.next()) {
                Trip t = new Trip();
                t.id = res.getInt("id");
                t.train_id = res.getInt("train_id");
                t.position = res.getString("position");
                t.destination = res.getString("destination");
                t.note = res.getString("note");
                t.price = res.getInt("price");
                t.datetime = res.getDate("datetime").toString();
                ret.add(t);
            }
            return ret;
        } catch (SQLException ex) {
            Logger.getLogger(Train.class.getName()).log(Level.SEVERE, null, ex);
        }

      return new ArrayList<Trip>();
    }
}
