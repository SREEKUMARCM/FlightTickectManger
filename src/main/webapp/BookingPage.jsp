<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String flightIdString=request.getParameter("flightId");
%>
<form action="BookingPageConnecter" method="post">
<h1>Personal Registration</h1>
<table>
<tr><td>Personal ID:</td><td><input type="text" name="pId"></td></tr>
<tr><td>Name:</td><td><input type="text" name="pName"></td></tr>
<tr><td>Age:</td><td><input type="text" name="age"></td></tr>
<tr><td>Gender:</td><td><input type="text" name="gender"></td></tr>
<tr><td><input type="hidden" name="flightId" value="<%= flightIdString %>"></td></tr>
<tr><td><input type="submit" value="Next"></td></tr>

</table>
</form>
</body>

</html>