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
        <% ArrayList<Train> allTrains = Train.getAllTrains(); %>
        <script>
            function validate(form) {
                if (form.tripPosition.value.length == 0) {
                    alert("field position is required");
                    return false;
                }
                if (form.tripDestination.value.length == 0) {
                    alert("field destination is required");
                    return false;
                }
                return true;
            }
        </script>
        <script type="text/javascript">
        $("document").ready(function() {
            $('#adminHeader').load('admin_header.html');
        });
        </script>  

    </head>
    <body>
        <div id="adminHeader"></div> 
        <form action="addTrip" onsubmit="return validate(this);" class="col-md-6 form">           
            <select name="tripTrainId" class="form-control">
                <% for(Train t : allTrains) { %>
                    <option value="<%= t.id %>"><%= t.name %></option>
                <% } %>
            </select>
            Position: <input type="text" name="tripPosition" class="form-control"/>
            Destination: <input type="text" name="tripDestination" class="form-control"/>
            <div class="form-group">
                <label for="comment">Note:</label>
                <textarea name="tripNote" class="form-control" rows="5" id="comment"></textarea>
            </div>
            Price: <input type="number" name="tripPrice" class="form-control"/>
            Date: <input type="date" name="tripDate" class="form-control"/>
            Time: <input type="time" name="tripTime" class="form-control"/>
            <input type="submit" value="Add trip"/>
        </form>
    </body>
</html>
