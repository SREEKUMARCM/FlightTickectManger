<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Flight Search Results</title>
</head>
<body>
    <h1>Flight Search Results</h1>
    <table>
        <tr>
            <th>Flight ID   </th>
            <th>Flight Name   </th>
            <th>Source   </th>
            <th>Destination  </th>
            <th>Number of Persons  </th>
            <th>Price   </th>
            <th>Date of Travel   </th>
        </tr>
        <c:forEach items="${flightResults}" var="flight">
            <tr>
                <td>${flight.flightId}</td>
                <td>${flight.flightName}</td>
                <td>${flight.source}</td>
                <td>${flight.destination}</td>
                <td>${flight.numberOfSeats}</td>
                <td>${flight.price}</td>
               <td>${flight.date}</td> 
                <td><button onclick="bookNow(${flight.flightId})">Book Now</button></td>
            </tr>
        </c:forEach>
         
    </table>
    
    <script>
        function bookNow(flightId) {
            var targetURL = "BookingPage.jsp?flightId=" + flightId;
            window.location.href = targetURL;
        }
    </script>
</body>
</html>
