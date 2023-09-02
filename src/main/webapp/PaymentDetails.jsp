<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>payment details</title>
 <script>
        function showMessage() {
            alert("ticket is confirmed!");
        }
    </script>
</head>
<body>
<%
Integer flightIdObject = (Integer) request.getAttribute("flightId");
int flightId = (flightIdObject != null) ? flightIdObject.intValue() : 0; 
Integer flightIdObject1 = (Integer) request.getAttribute("totalAmount");
int totalAmount=(flightIdObject1 != null) ? flightIdObject1.intValue() : 0;;
%>
<form action="PaymentDetailsConnecter" method="get">
<h1>Personal Registration</h1>
<table>
<tr><td>Number Of Persons:</td><td><input type="text" name="numberOfPersons"></td></tr> 
<tr><td><input type="hidden" name="flightId" value="<%= flightId %>"></td></tr>

<c:forEach var="flightDetail" items="${result}">
    <!-- Access attributes of each FlightDetails object -->
    Flight ID: ${flightDetail.flightId}<br>
    Flight Name: ${flightDetail.flightName}<br>
    Source: ${flightDetail.source}<br>
    Destination: ${flightDetail.destination}<br>
    <!-- Add more attributes as needed -->
</c:forEach>
<h3>Total amount to be paid is :</h3><h2><%= totalAmount %></h2>
<tr><td><input type="submit" value="Next" onclick="showMessage()"></td></tr>
</table>
</form>

</body>
</html>