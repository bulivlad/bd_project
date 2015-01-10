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

  <style>
    body {
      padding-top: 40px;
      padding-bottom: 40px;
      background-color: #f5f5f5;
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

    #buttonStyle ul {
      list-style-type: none;
      overflow: hidden;
      margin: 0;
      padding: 0;
    }

    #buttonStyle li {
      display: inline;
      padding: 20px;
    }

  </style>

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
