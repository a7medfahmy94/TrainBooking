<%-- 
    Document   : view_trains
    Created on : Dec 29, 2015, 12:42:14 AM
    Author     : amr
--%>

<%@page import="BusinessModels.Train"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BusinessModels.Trip"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trains</title>
        <h1>Trains</h1>
        <link rel="stylesheet" href="bootstrap.min.css" />

    </head>
    <body>
     <table class="table"> 
            <thead>
                <tr>
                  <th>Id</th>
                  <th>Name</th>
                  <th>Capacity</th>
                  <th>Actions</th>
                </tr>
            </thead>
            <tbody>
            <tr>
            <%
                ArrayList<Train> trains = new ArrayList<Train>();
                trains = Train.getAllTrains();
                
                for(int i = 0 ; i < trains.size() ; i++){
                   ArrayList<String>view = new ArrayList<String>();
                   view.add(trains.get(i).id.toString());
                   view.add(trains.get(i).name);
                   view.add(trains.get(i).capacity.toString());
            %>
             <%
                   for(int j = 0 ; j < view.size() ; j++){
                       
             %>
             <td>
                 <%
                  out.println(view.get(j));
                   }
                 %>
             </td>
             </tr>
            <%}%>
            </tbody>
     
        </table>
                
      </body>
</html>
