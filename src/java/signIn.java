/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BusinessModels.DBConnection;
import BusinessModels.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fahmy
 */
@WebServlet(urlPatterns = {"/signIn"})
public class signIn extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        User newUser = new User();
        newUser.email = request.getParameter("Email");
        newUser.password = request.getParameter("Password");
        Connection con = new DBConnection().getConnection();
        ResultSet res;
        Statement stmt;
        try {
            stmt = con.createStatement();
            String query = "select * from user where password = '"+ newUser.password+"' and email='"+ newUser.email+"'";
            res = stmt.executeQuery(query);
            System.out.println(query);
            if(!res.next()){
                response.sendRedirect("sign_in.html");
            }else{
                HttpSession session = request.getSession(true);
                if (!session.isNew()) {
                    session.invalidate();
                    session = request.getSession(true);
                 }
                newUser.name = res.getString("name");
                newUser.id = res.getInt("id");
                session.setAttribute("user", newUser);
                response.sendRedirect("homepage.html");
            }
            

        } catch (SQLException ex) {
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