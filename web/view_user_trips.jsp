<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page import="BusinessModels.User"%>
<%@page import="BusinessModels.Train"%>
<%@page import="java.util.*"%>
<%@page import="BusinessModels.Trip"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <title></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="bootstrap.min.css" />
        <script type="text/javascript" src="jquery-2.1.4.min.js"></script>
        <script type="text/javascript" src="bootstrap.min.js"></script>
           <script type="text/javascript">
               $("document").ready(function() {
            $('#userHeader').load('user_header.html');
        });
        </script> 
        
        <div id="userHeader"></div>
        <h2>User Trips</h2>
    </head>
    <body>
        <div>
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
                  <th>Actions</th>
                </tr>
            </thead>
            <tbody>
            <tr>
               <%
                  User u = (User)session.getAttribute("user");
                  
                  ArrayList<Trip> trips = new ArrayList<Trip>();
                  trips = Trip.getUserTrips(u.id.toString());
                  float totalCost = 0;
                  
                  for(int i = 0 ; i < trips.size() ; i++){
                   ArrayList<String>view = new ArrayList<String>();
                   view.add(trips.get(i).id.toString());
                   view.add(trips.get(i).position);
                   view.add(trips.get(i).destination);
                   view.add(trips.get(i).note);
                   view.add(trips.get(i).datetime);
                   view.add(trips.get(i).price.toString());
                   view.add(trips.get(i).train_id.toString());
                   
                   totalCost +=  trips.get(i).price;
                   
                   for(int j = 0; j < view.size() ; j++){
                       
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
            
               <h1>Total price = <%=totalCost%></h1>
        </div>
    </body>
</html>
