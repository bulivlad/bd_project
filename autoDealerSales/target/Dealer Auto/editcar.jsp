<%@ page import="ro.autoDealerSales.web.domain.CarForSale" %>
<%@ page import="java.util.ArrayList" %>
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

  <%--pop-up starts--%>

  <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>


  <style>
    body {
      padding-top: 40px;
      padding-bottom: 40px;
      background-color: #f5f5f5;
    }

    #buttonStyle ul {
      list-style-type: none;
      margin: 0;
      padding: 0;
    }

    #buttonStyle li {
      display: inline;
      padding: 20px;
    }

    nav ul ul {
      display: none;
    }

    nav ul li:hover > ul {
      display: block;
    }
    nav ul {
      background: #efefef;
      background: linear-gradient(top, #efefef 0%, #bbbbbb 100%);
      background: -moz-linear-gradient(top, #efefef 0%, #bbbbbb 100%);
      background: -webkit-linear-gradient(top, #efefef 0%,#bbbbbb 100%);
      box-shadow: 0px 0px 9px rgba(0,0,0,0.15);
      padding: 0 20px;
      border-radius: 10px;
      list-style: none;
      position: relative;
      display: inline-table;
    }
    nav ul:after {
      content: ""; clear: both; display: block;
    }
    nav ul li {
      float: left;
    }
    nav ul li:hover {
      background: #4b545f;
      background: linear-gradient(top, #4f5964 0%, #5f6975 40%);
      background: -moz-linear-gradient(top, #4f5964 0%, #5f6975 40%);
      background: -webkit-linear-gradient(top, #4f5964 0%,#5f6975 40%);
    }
    nav ul li:hover a {
      color: #fff;
    }

    nav ul li a {
      display: block; padding: 25px 40px;
      color: #757575; text-decoration: none;
    }
    nav ul ul {
      background: #5f6975; border-radius: 0px; padding: 0;
      position: absolute; top: 100%;
    }
    nav ul ul li {
      float: none;
      border-top: 1px solid #6b727c;
      border-bottom: 1px solid #575f6a;
      position: relative;
    }
    nav ul ul li a {
      padding: 15px 40px;
      color: #fff;
    }
    nav ul ul li a:hover {
      background: #4b545f;
    }

    #dataTable td{
      padding: 40px;
      font-size: x-large;
    }

    #dataTable div{
      background-color: #b3b3b3;
    }

  </style>

  <title>Informatii generale</title>

  <%
    ServletContext context = config.getServletContext();
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
      </ul>
    </nav>
  </div>
  <br><br><br>
  <form>
  <div class="panel panel-default">
    <table id="dataTable" style="width:90%" border="0" align="center">
      <tr>
        <td><div class="label label-info">Marca: </div><input type="text" name="ManufacturerName" value="<%=carsForSale.getManufacturerName()%>"></td>
        <td><div class="label label-info">Model: </div> <input type="text" name="ModelName" value="<%=carsForSale.getModelName()%>"></td>
      </tr>
      <tr>
        <td><div class="label label-info">Categorie: </div> <input type="text" name="VehicleCategory" value="<%=carsForSale.getVehicleCategory()%>"></td>
        <%
          if(carsForSale.getAskingPrice() != null){
        %>
        <td><div class="label label-info">Pret(EUR): </div> <input type="text" name="AskingPrice" value="<%=carsForSale.getAskingPrice()%>"></td>
        <%
          }
          else{
        %>
        <td><div class="label label-info">Pret(EUR): </div> <input type="text" name="AskingPrice" value=""></td>
        <%
          }
        %>
      </tr>
      <tr>
        <%
          if(carsForSale.getCurrentMileage() != null){
        %>
        <td><div class="label label-info">Kilometrii: </div> <input type="text" name="CurrentMileage" value="<%=carsForSale.getCurrentMileage()%>"></td>
        <%
          }
          else{
        %>
        <td><div class="label label-info">Kilometrii: </div> <input type="text" name="CurrentMileage" value=""></td>
        <%
          }
          if(carsForSale.getDate_acquired() != null){
        %>
        <td><div class="label label-info">An fabricatie: </div> <input type="text" name="date_acquired" value="<%=carsForSale.getDate_acquired()%>"></td>
        <%
          }
          else{
        %>
        <td><div class="label label-info">An fabricatie: </div> <input type="text" name="date_acquired" value=""></td>
        <%
          }
        %>
      </tr>

      <%
        if(carFeature.getDescription() != null){
      %>
      <tr>
        <td><div class="label label-info">Dotari: </div> <input type="text" name="description" value="<%=carFeature.getDescription()%>"></td>
      </tr>
      <%
        }
        else{
      %>
      <tr>
        <td><div class="label label-info">Dotari: </div> <input type="text" name="description" value=""></td>
      </tr>
      <%
        }
      %>

    </table>
  </div>
  <ul id="buttonStyle">
    <li><button class="btn btn-large btn-primary" formmethod="post"  formaction="cars?id=<%=carsForSale.getId()%>&action=editOne&update=yes" type="submit">Salveaza</button></li>
    <li><a class="btn btn-large btn-primary" href="cars?action=viewAll">Renunta</a></li>
  </ul>
  </form>
</div>

</body>
</html>
