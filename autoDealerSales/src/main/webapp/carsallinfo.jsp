<%@ page import="ro.autoDealerSales.web.domain.CarForSale" %>
<%@ page import="ro.autoDealerSales.web.domain.CarFeature" %>
<%--
  Created by IntelliJ IDEA.
  User: Buli
  Date: 1/4/2015
  Time: 1:24 PM
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
    CarForSale carsForSale = (CarForSale) request.getAttribute("carForSale");
    CarFeature carFeature = (CarFeature) request.getAttribute("carFeatures");
  %>

</head>
<body>
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
          <li><a href="rapoarte">Rapoarte detaliate</a></li>
          <li id="search">
            <form action="" method="get">
              <input type="text" name="search_text" id="search_text" placeholder="Search"/>
              <input type="submit" id="search_button"></a>
            </form>
          </li>
        </ul>
      </nav>
    </div>
    <br><br><br>
    <div class="panel panel-default">
      <center>
    <table id="dataTable" style="width:60%" border="0">
      <tr>
          <td><div class="label label-info">Marca: <%=carsForSale.getManufacturerName()%></div></td>
          <td><div class="label label-info">Model: <%=carsForSale.getModelName()%></div></td>
      </tr>
      <tr>
          <td><div class="label label-info">Categorie: <%=carsForSale.getVehicleCategory()%></div></td>
            <%
              if(carsForSale.getAskingPrice() != null){
            %>
          <td><div class="label label-info">Pret(EUR): <%=carsForSale.getAskingPrice()%></div></td>
        <%
          }
        %>
      </tr>
      <tr>
        <%
          if(carsForSale.getCurrentMileage() != null){
        %>
          <td><div class="label label-info">Kilometrii: <%=carsForSale.getCurrentMileage()%></div></td>
        <%
          }
          if(carsForSale.getDate_acquired() != null){
        %>
          <td><div class="label label-info">An fabricatie: <%=carsForSale.getDate_acquired()%></div></td>
        <%
          }
        %>
      </tr>

      <%
        if(carFeature.getDescription() != null){
      %>
        <tr>
          <td><div class="label label-info">Dotari: <%=carFeature.getDescription()%></div></td>
        </tr>
      <%
        }
      %>

    </table>
      </center>
      </div>
    <div align="right">
      <form>
        <ul id="buttonStyle">
          <li><button class="btn btn-large btn-primary" formmethod="post" formaction="cars?id=<%=carsForSale.getId()%>&action=editOne&update=no" type="submit">Edit</button></li>
          <li><button class="btn btn-large btn-primary" formmethod="post" formaction="cars?id=<%=carsForSale.getId()%>&action=deleteOne" type="submit">Stergere</button></li>
        </ul>
      </form></div>
  </div>
</body>
</html>
