<%@ page import="ro.autoDealerSales.web.domain.User" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ro.autoDealerSales.web.domain.Customer" %>
<%--
  Created by IntelliJ IDEA.
  User: Buli
  Date: 12/25/2014
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <!-- Latest compiled and minified CSS -->
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

    <title>Informatii generale</title>

  <%
    ServletContext context = config.getServletContext();
    User user = (User) context.getAttribute("user");
    ArrayList<Customer> allCustomers = (ArrayList<Customer>) request.getAttribute("allCustomers");
  %>

</head>
<body>
  <div class="container">
    <div class="panel panel-default">
      <div class="jumbotron">
        <h1 class="panel-title">Informatii generale</h1>
      </div>

    <nav class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
          <a class="navbar-brand" href="general">Clienti</a>
        </div>
      <div class="navbar-header">
        <a class="navbar-text" href="general">Masini</a>
      </div>
      <div class="navbar-header">
        <a class="navbar-text" href="rapoarteGenerale">Rapoarte detaliate</a>
      </div>
    </nav>
    </div>
    <div class="panel panel-default">
      <h2>Welcome back, <%=user.getUsername()%> !</h2>

      <br><br><br><br><br><br><br>

<center>
      <table style="width:80%" border="0">
        <tr><td>First Name</td><td>Last Name</td><td>Phone</td><td>Email</td><td>Action</td></tr>
        <%
          for (Customer customer : allCustomers) {
        %>
        <tr><td><%=customer.getFirstName()%></td><td><%=customer.getLastName()%></td><td><%=customer.getPhone()%></td>
          <td><%=customer.getEmail()%></td>
          <td><form action="personal?id=<%=customer.getId()%>&action=persInfo" method="post"><input type="submit" value="View"></form></td></tr>
        <%
          }
        %>
      </table>
</center>

      <br>

    </div>

  </div>

</body>
</html>
