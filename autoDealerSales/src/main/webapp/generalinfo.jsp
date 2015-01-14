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

  <%--MyCustom css--%>
  <link href="style/oldstyle.css" rel="stylesheet">

    <title>Informatii generale</title>

  <%
    ServletContext context = config.getServletContext();
    User user = (User) context.getAttribute("user");
    ArrayList<Customer> allCustomers = (ArrayList<Customer>) request.getAttribute("allCustomers");

    String sqlMessages = null;
    Integer sqlResult = (Integer) context.getAttribute("sqlResult");
    if(sqlResult != null)
    {
      if(sqlResult == 0) {
        sqlMessages="Eroare la update. Modificarile nu au fost salvate";
      }
      else {
        sqlMessages = "Modificarile au fost salvate cu succes";
      }
    }
  %>

  <script type="text/javascript">
    function popupOpen() {
      if(<%=sqlResult != null%>)
        alert("<%=sqlMessages%>");
    }
  </script>

  <%context.removeAttribute("sqlResult");%>

</head>
<body onload="popupOpen()">
  <div class="container">
    <div class="panel panel-default">
      <div class="jumbotron">
        <h1 class="panel-title">Informatii generale</h1>
      </div>

      <nav>
        <ul>
          <li><a href="#">Clienti</a>
            <ul>
              <li><a href="general">Vizualizare</a></li>
              <li><a href="addOne">Adaugare</a></li>
            </ul>
          </li>
          <li><a href="#">Masini de vanzare</a>
            <ul>
              <li><a href="cars?action=viewAll">Vizualizare</a></li>
              <li><a href="cars?action=addOne">Adaugare</a></li>
            </ul>
          </li>
          <li></li>
          <li><a href="#">Facturi</a>
            <ul>
              <li><a href="invoice?action=viewAll">Vizualizare</a></li>
            </ul>
          </li>
          <left>
          <li id="search">
            <form action="search" method="get">
              <input type="text" name="search_text" id="search_text" placeholder="Search"/>
              <input type="submit" id="search_button"></a>
            </form>
          </li></left>
        </ul>
      </nav>
    </div>
    <div class="panel panel-default">
      <h2>Welcome back, <%=user.getUsername()%> !</h2>

      <br><br><br><br>

<center>
      <table id="firstTable" style="width:80%" border="0">
        <tr><td>First Name</td><td>Last Name</td><td>Phone</td><td>Email</td><td>Actiuni</td></tr>
        <%
          for (Customer customer : allCustomers) {
        %>
        <tr><td><%=customer.getFirstName()%></td><td><%=customer.getLastName()%></td><td><%=customer.getPhone()%></td>
          <td><%=customer.getEmail()%></td>
          <td><form action="personal?id=<%=customer.getId()%>&action=persInfo" method="post"><input type="submit" value="View"></form></td>
          <%--<td><form action="editPerson?id=<%=customer.getId()%>&update=no" method="post"><input type="submit" value="Edit"></form></td>--%>

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
