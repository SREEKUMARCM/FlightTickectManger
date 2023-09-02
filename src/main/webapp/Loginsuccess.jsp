<%-- Import JSTL Core library at the top of your JSP --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ page import="java.util.List" %>
   <%@ page import="com.flightTicket.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Flight Details</title>
</head>
<% 
Flightdao fDao=new Flightdao();

List<FlightDetails> FlightList = fDao.searchFlight();
List<PersonalDetails> personalList = fDao.searchPersonal();
 %>
<body>
<center><tr><td><button id="passwordChange">Do you have to change the password  ?</button></td></tr></center>
<script>
    document.getElementById("passwordChange").addEventListener("click", function() {
        window.location.href = "passwordChange.jsp";
    });
    </script>
<form action="LoginConnecter" method="post"></form>
<table>    
		    <tr>
            <th>Destination    </th>
            <th>Source    </th>
            <th>FlightNmae   </th>
        </tr>
        <%for(FlightDetails flight: FlightList){%>
            <tr> 
                  
                <td><%=flight.getDestination() %></td>
                 <td><%=flight.getSource() %></td>
                <td><%=flight.getFlightName() %></td>
                <br>
            </tr>
        <%} %>   
        <tr>
        <th>Name</th>
        <th>Age</th>
        <th>Gender</th>
        </tr>
           <%for(PersonalDetails personal: personalList){%>
            <tr> 
                  
                <td><%=personal.getPersionId() %></td>
                 <td><%=personal.getPersonName() %></td>
                <td><%=personal.getAge() %></td>
                  <td><%=personal.getGender() %></td>
                <br>
            </tr>
        <%} %>   
        </table>    
</form>
</body>
</html>

