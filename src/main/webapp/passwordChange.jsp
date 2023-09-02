<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <script>
        <% String result = (String)request.getAttribute("result"); %>
        <% if (result != null) { %>
            alert("<%= result %>");
        <% } %>
        </script>
<form action="PasswordConnecter" method="post">
<h1>Personal Registration</h1>
<table>
<tr><td>Name:</td><td><input type="text" name="name"></td></tr>
<tr><td>password:</td><td><input type="password" name="password"></td></tr>
<tr><td>Re-enter password:</td><td><input type="text" name="rePassword"></td></tr>
<tr><td>new password:</td><td><input type="password" name="newPassword"></td></tr>
<tr><td><input type="submit" value="Next"></td></tr>


</table>
</form>
</body>
</html>