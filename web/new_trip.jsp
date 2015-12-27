<%--
    Document   : new_trip
    Created on : Dec 27, 2015, 10:57:09 PM
    Author     : fahmy
--%>

<%@page import="BusinessModels.Train"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap.min.css" />
        <script type="text/javascript" src="jquery-2.1.4.min.js"></script>
        <script type="text/javascript" src="bootstrap.min.js"></script>
        <title>Add a new trip</title>
    </head>
    <body>
        <div class="dropdown">
            <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">
              Train
              <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <% ArrayList<Train> allTrains = (ArrayList)session.getAttribute("trains"); %>
                <% for(Train t : allTrains) { %>
                      <li><%= t.name %></li>
                <% } %>
            </ul>
        </div>
    </body>
</html>
