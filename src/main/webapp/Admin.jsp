<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
</head>
<body>
<form action="AdminConnecter" method="get">

<table>
<tr><td>name:</td><td><input type="text" name="name"></td></tr>
<tr><td>password:</td><td><input type="password" name="password"></td></tr>
<!-- <tr><td><input type="submit" value="Search" ></td></tr> -->
<tr><td><button id="viewListButton">Search</button></td></tr>
<script>
    document.getElementById("viewListButton").addEventListener("click", function() {
        window.location.href = "Loginsuccess.jsp";
    });
    </script>
</table>
</form>
</body>
</html>