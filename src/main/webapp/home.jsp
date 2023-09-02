<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<center><h3>....Flight Ticket Booking.....</h3></center>

<br>
<br>
<center><tr><td><button id="viewListButton1">Admin</button></td></tr></center>
<script>
    document.getElementById("viewListButton1").addEventListener("click", function() {
        window.location.href = "Admin.jsp";
    });
    </script>
<br>
<br>
<center><tr><td><button id="viewListButton">User</button></td></tr></center>
<script>
    document.getElementById("viewListButton").addEventListener("click", function() {
        window.location.href = "FlightSerach.jsp";
    });
    </script>
</body>
</html>