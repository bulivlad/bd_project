<%@ page import="ro.autoDealerSales.web.domain.CarForSale" %>
<%@ page import="ro.autoDealerSales.web.domain.CarFeature" %>
<%--
  Created by IntelliJ IDEA.
  User: Buli
  Date: 1/5/2015
  Time: 11:09 PM
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

  <title>Adaugare masina</title>

  <%
    CarForSale carsForSale = (CarForSale) request.getAttribute("carForSale");
    CarFeature carFeature = (CarFeature) request.getAttribute("carFeatures");
  %>

</head>
<body>
<div class="container">
  <div class="panel panel-default">
    <div class="jumbotron">
      <h1 class="panel-title">Adaugare masina</h1>
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
        <li><a href="#">Facturi</a>
          <ul>
            <li><a href="invoice?action=viewAll">Vizualizare</a></li>
          </ul>
        </li>
        <li><a href="logout">Iesire</a></li>
        <left>
          <li id="search">
            <form action="search" method="get">
              <input type="text" name="search_text" id="search_text" placeholder="Search"/>
              <input type="submit" id="search_button"></a>
            </form>
          </li>
        </left>
      </ul>
    </nav>
  </div>
  <br><br><br>
  <form>
  <div class="panel panel-default">
    <table id="dataTable" style="width:60%" border="0" align="center">
      <tr>
        <td><div class="label label-info">Marca*: </div><input type="text" name="marca" required="required"></td>
        <td><div class="label label-info">Model*: </div><input type="text" name="model" required="required"></td>
      </tr>
      <tr>
        <td><div class="label label-info">Categorie*: </div><input type="text" name="categorie" required="required"></td>
        <td><div class="label label-info">Pret(EUR): </div><input type="text" name="pret"></td>
      </tr>
      <tr>
        <td><div class="label label-info">Kilometrii: </div><input type="text" name="km"></td>
        <td><div class="label label-info">An fabricatie: </div><input type="date" name="an"></td>
      </tr>
      <tr>
        <td><div class="label label-info">Dotari: </div><input type="text" name="dotari"></td>
      </tr>

    </table>
  </div>
  <div align="right">

      <ul id="buttonStyle">
        <li><button class="btn btn-large btn-primary" formmethod="post" formaction="cars?action=addOne" type="submit">Adauga</button></li>
      </ul>
    </div></form>
</div>

</body>
</html>
