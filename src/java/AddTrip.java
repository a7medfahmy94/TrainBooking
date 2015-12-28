/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author amr
 */
@WebServlet(urlPatterns = {"/addTrip"})
public class AddTrip extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Trip newTrip = new Trip();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        newTrip.destination = request.getParameter("destionation");
        newTrip.position = request.getParameter("position");
        newTrip.note = request.getParameter("note");
        newTrip.price = Float.parseFloat(request.getParameter("Price"));

        try {
            newTrip.date = sdf.parse(request.getParameter("date"));
        } catch (ParseException ex) {
            Logger.getLogger(AddTrip.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
        Connection con = new DBConnection().getConnection();
        Statement stmt;

        try{
            stmt = con.createStatement();
            String insert = "insert into trip (position, destination, note, date, time, price) VALUES('" +
            newTrip.destination + "," + newTrip.position + "','" + newTrip.note + "','" + newTrip.date + 
            "','" + newTrip.time + "','" + newTrip.price + "','" + 
            "';";
            stmt.executeUpdate(insert);

        }catch (SQLException ex) {
           Logger.getLogger(signUp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
