<%@ page import="ro.autoDealerSales.web.domain.*" %>
<%--
  Created by IntelliJ IDEA.
  User: Buli
  Date: 1/2/2015
  Time: 10:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

    <%--MyCustom css--%>
    <link href="style/oldstyle.css" rel="stylesheet">
    <link href="style/navbar.css" rel="stylesheet">

  <title>Adaugare client</title>
</head>
<body>
<div class="container">
  <div class="panel panel-default">
    <div class="jumbotron">
      <h1 class="panel-title">Adaugare client</h1>
    </div>

    <nav>
      <ul>
        <li><a href="#">Clienti</a>
          <ul>
            <li><a href="general">Vizualizare</a></li>
            <li><a href="addaOne">Adaugare</a></li>
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

  <form>
    <div class="panel panel-default">
      <table id="dataTable" style="width:60%" border="0" align="center">
        <tr>
          <td><div class="label label-info">Prenume*: </div><input name="firstName" type="text" required="required"></td>
          <td><div class="label label-info">Nume*: </div><input name="lastName" type="text" required="required"></td>
        </tr>
        <tr>
          <td><div class="label label-info">Email: </div><input name="email" type="text"></td>
          <td><div class="label label-info">Numar de telefon*: </div><input name="phone" type="text" required="required""></td>
        </tr>
        <tr>
          <td><div class="label label-info">Alte detalii: </div><input name="customerOther" type="text"></td>
        </tr>
        <tr>
          <td><div class="label label-info">Adresa*: </div><input name="address" type="text" required="required"></td>
          <td><div class="label label-info">Cod postal*: </div><input name="postalCode" type="text" required="required"></td>
        </tr>
        <tr>
          <td><div class="label label-info">Oras*: </div><input name="town" type="text" required="required"></td>
          <td><div class="label label-info">Tara*: </div><input name="country" type="text" required="required"></td>
        </tr>
        <tr>
          <td><div class="label label-info">Alte detalii: </div><input name="addressOther" type="text"></td>
        </tr>
        <tr>
          <td><div class="label label-info">Preferintele clientului: </div><input name="preferences" type="text"></td>
          <td>
            <div class="label label-info">Id facilitati*: </div>
            <input name="carFeatureId" type="text" required="required"></select>
          </td>
        </tr>
        <tr>
          <td><div class="label label-info">Data platii*: </div><input name="payDate" type="date" required="required"></td>
          <td><div class="label label-info">Statusul platii*: </div><input name="payStatus" type="text" required="required"></td>
        </tr>
        <tr>
          <td>
            <div class="label label-info">Id masina*: </div>
            <input name="carFSId" type="text" required="required"></select>
          </td>
        </tr>
        <tr>
          <td><div class="label label-info">Pret(EUR)*: </div><input name="agreedPrice" type="text" required="required"></td>
          <td><div class="label label-info">Data vanzarii*: </div><input name="saleDate" type="date" required="required"></td>
        </tr>
        <tr>
          <td><div class="label label-info">Alte detalii: </div><input name="otherSold" type="text"></td>
        </tr>
      </table>
    </div>



    <ul id="buttonStyle">
      <li><button class="btn btn-large btn-primary" formmethod="post" formaction="addOne" type="submit">Salveaza</button></li>
    </ul>
  </form>

</body>
</html>
