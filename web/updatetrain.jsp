<%-- 
    Document   : updatetrain
    Created on : Dec 28, 2015, 10:27:21 AM
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
        <title>JSP Page</title>
        <script type="text/javascript">
        $("document").ready(function() {
            $('#adminHeader').load('admin_header.html');
        });
        </script>  

    </head>
    <body>
        <div id="adminHeader"></div> 

        <% ArrayList<Train> allTrains = Train.getAllTrains(); %>
        
        <form action="updateTrain" class="col-md-6">
            <div class="form-group">
                <select class="form-control" name="id"> 
                    <% for(Train t : allTrains) { %>
                        <option value="<%= t.id %>"><%= t.name %></option>
                    <% } %>
                </select>
            </div>
            new name: <input id="trainName" type="text" name="newName">
            <br>
            new capacity: <input id="trainCap" type="number" name="newCapacity">
            <br>
            <input type="submit" value="update">
        </form>

    </body>
</html>
