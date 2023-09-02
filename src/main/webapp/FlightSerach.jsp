<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="java.util.List" %>
       <%@ page import="com.flightTicket.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<form action="flightConnector" method="post">
<h1>Flight Ticket Booking</h1>
<table>
<tr><td>Date Of Travel:</td><td><input type="text" name="date"></td></tr>
<tr><td>Source:</td><td><input type="text" name="source"></td></tr>
<tr><td>Destination:</td><td><input type="text" name="destination"></td></tr>
<tr><td>Number Of Persons:</td><td><input type="text" name="numberOfPersons"></td></tr> 
<!-- <tr><td><input type="submit" value="Search" ></td></tr> -->
<tr><td><button id="viewListButton">Search</button></td></tr>
<script>
    document.getElementById("viewListButton").addEventListener("click", function() {
        window.location.href = "FlightList.jsp";
    });
    </script>
</table>
</form>
</body>
</html>