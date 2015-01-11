<%@ page import="java.util.ArrayList" %>
<%@ page import="ro.autoDealerSales.web.domain.CarForSale" %>
<%--
  Created by IntelliJ IDEA.
  User: Buli
  Date: 1/11/2015
  Time: 8:30 PM
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
  <link href="style/navbar.css" rel="stylesheet">

  <title>Informatii generale</title>

  <%
    ArrayList<CarForSale> carsForSale = (ArrayList<CarForSale>) request.getAttribute("carsForSale");
    ServletContext context = config.getServletContext();
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
        <li><a href="#">Rapoarte detaliate</a>
          <ul>
            <li><a href="cars?action=viewAll">Raport 1</a></li>
            <li><a href="cars?action=viewAll">Raport 2</a></li>
            <li><a href="cars?action=viewAll">Raport 3</a></li>
          </ul>
        </li>
        <li id="search">
          <form action="" method="get">
            <input type="text" name="search_text" id="search_text" placeholder="Search"/>
            <input type="submit" name="search_button" id="search_button"></a>
          </form>
        </li>
      </ul>
    </nav>
  </div>
  <div class="panel panel-default">
    <br><br><br>

    <center>
      <table id="firstTable" style="width:70%" border="0">
        <tr><td>Marca</td><td>Model</td><td>Pret(EUR)</td><td>Actiuni</td></tr>
        <%
          for (CarForSale carForSale : carsForSale) {
        %>
        <tr><td><%=carForSale.getManufacturerName()%></td><td><%=carForSale.getModelName()%></td><td><%=carForSale.getAskingPrice()%></td>
          <td><form action="cars?id=<%=carForSale.getId()%>&action=viewOne" method="post"><input type="submit" value="View"></form></td>
          <%--<td><form action="cars?id=<%=carForSale.getId()%>&action=editOne&update=no" method="post"><input type="submit" value="Edit"></form></td>--%>
            <%
            }
          %>
      </table>
    </center>
    <br>
  </div>

</body>
</html>
