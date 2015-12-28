<%-- 
    Document   : view_trips
    Created on : Dec 28, 2015, 8:51:50 PM
    Author     : amr
--%>

<%@page import="BusinessModels.Train"%>
<%@page import="java.util.*"%>
<%@page import="BusinessModels.Trip"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap.min.css" />
        
    <h1>Trips</h1>
    </head>
    <body>
        <table class="table"> 
            <thead>
                <tr>
                  <th>Id</th>
                  <th>From</th>
                  <th>Destination</th>
                  <th>note</th>
                  <th>date</th>
                  <th>price</th>
                  <th>Train Num</th>
                </tr>
            </thead>
                          <tr>

            <tbody>
               <%
                  ArrayList<Trip> trips = new ArrayList<Trip>();
                  trips = Trip.getAllTrips();
                   
                  for(int i = 0 ; i < trips.size() ; i++){
                   ArrayList<String>view = new ArrayList<String>();
                   view.add(trips.get(i).id.toString());
                   view.add(trips.get(i).position);
                   view.add(trips.get(i).destination);
                   view.add(trips.get(i).note);
                   view.add(trips.get(i).datetime);
                   view.add(trips.get(i).price.toString());
                   view.add(trips.get(i).train_id.toString());
                   
                   for(int j = 0; j < view.size() ; j++){
                       
              %>
              <td>
              <%
                  out.println(view.get(j));
                   }
              %>
              </td>
              </tr>
              <%        }%>
            </tbody>
        </table>

    </body>
</html>
