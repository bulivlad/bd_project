<%@ page import="ro.autoDealerSales.web.domain.*" %>
<%--
  Created by IntelliJ IDEA.
  User: Buli
  Date: 1/2/2015
  Time: 10:45 AM
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

    #dataTable td{
      padding: 20px;
      font-size: x-large;
    }

    #dataTable div{
      background-color: #b3b3b3;
    }

    #dataTable input{
      width: 250px;
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

  </style>

  <%
    Customer cstm = (Customer) request.getAttribute("customer");
    Address address = (Address) request.getAttribute("address");
    CustomerPreference cstmPref = (CustomerPreference) request.getAttribute("customerPreference");
    CustomerPayments cstmPay = (CustomerPayments) request.getAttribute("customerPayment");
    CarSold carSold = (CarSold) request.getAttribute("carSold");
    CarForSale carFS = (CarForSale) request.getAttribute("carForSale");
  %>

    <title>Edit <%=cstm.getFirstName()%> <%=cstm.getLastName()%></title>
</head>
<body>
  <div class="container">
    <div class="panel panel-default">
      <div class="jumbotron">
        <h1 class="panel-title">Modificare client</h1>
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
          <li><a href="rapoarte">Rapoarte detaliate</a></li>
        </ul>
      </nav>
    </div>

    <form>
    <div class="panel panel-default">
      <table id="dataTable" style="width:60%" border="0" align="center">
        <tr>
          <td><div class="label label-info">Prenume*: </div><input name="firstName" type="text" required="required" value="<%=cstm.getFirstName()%>"></td>
          <td><div class="label label-info">Nume*: </div><input name="lastName" type="text" required="required" value="<%=cstm.getLastName()%>"></td>
        </tr>
        <tr>
          <td><div class="label label-info">Email: </div><input name="email" type="text" value="<%=cstm.getEmail()%>"></td>
          <td><div class="label label-info">Numar de telefon*: </div><input name="phone" type="text" required="required" value="<%=cstm.getPhone()%>"></td>
        </tr>
        <%
          if(cstm.getOther() != null){
        %>
        <tr>
          <td><div class="label label-info">Alte detalii: </div><input name="customerOther" type="text" value="<%=cstm.getOther()%>"></td>
        </tr>
        <%
          }
          else{
        %>
        <tr>
          <td><div class="label label-info">Alte detalii: </div><input name="customerOther" type="text" value=""></td>
        </tr>
        <%
          }
        %>
        <tr>
          <td><div class="label label-info">Adresa*: </div><input name="address" type="text" required="required" value="<%=address.getAddress()%>"></td>
          <td><div class="label label-info">Cod postal*: </div><input name="postalCode" type="text" required="required" value="<%=address.getPostalCode()%>"></td>
        </tr>
        <tr>
          <td><div class="label label-info">Oras*: </div><input name="town" type="text" required="required" value="<%=address.getTown()%>"></td>
          <td><div class="label label-info">Tara*: </div><input name="country" type="text" required="required" value="<%=address.getCountry()%>"></td>
        </tr>
        <%
          if(address.getOther() != null){
        %>
        <tr>
          <td><div class="label label-info">Alte detalii: </div><input name="addressOther" type="text" value="<%=address.getOther()%>"></td>
        </tr>
        <%
          }
          else{
        %>
        <tr>
          <td><div class="label label-info">Alte detalii: </div><input name="addressOther" type="text" value=""></td>
        </tr>
        <%
          }
        %>
        <tr>
          <td><div class="label label-info">Preferintele clientului: </div><input name="preferences" type="text" value="<%=cstmPref.getCustomerPrefDetails()%>"></td>
        </tr>
        <tr>
          <td><div class="label label-info">Data platii*: </div><input name="payDate" type="date" required="required" value="<%=cstmPay.getPaymentDate()%>"></td>
          <td><div class="label label-info">Statusul platii*: </div><input name="payStatus" type="text" required="required" value="<%=cstmPay.getPaymentStatus()%>"></td>
        </tr>
        <tr>
          <td><div class="label label-info">Id masina: </div><input name="carFSId" type="text" readonly value="<%=carFS.getId()%>"></td>
        </tr>
        <tr>
          <td><div class="label label-info">Producator: </div><input name="producator" type="text" readonly value="<%=carFS.getManufacturerName()%>"></td>
          <td><div class="label label-info">Model: </div><input name="modelName" type="text" readonly value="<%=carFS.getModelName()%>"></td>
        </tr>
        <tr>
          <td><div class="label label-info">Pret(EUR)*: </div><input name="agreedPrice" type="text" required="required" value="<%=carSold.getAgreedPrice()%>"></td>
          <td><div class="label label-info">Data vanzarii*: </div><input name="saleDate" type="date" dataformatas="dd/MM/yyyy" required="required" value="<%=carSold.getDateSold()%>"></td>
        </tr>
        <tr>
          <td><div class="label label-info">Alte detalii: </div><input name="otherSold" type="text" value="<%=carSold.getOtherDetails() != null ? carSold.getOtherDetails() : ""%>"></td>
        </tr>
      </table>
    </div>



          <ul id="buttonStyle">
            <li><button class="btn btn-large btn-primary" formmethod="post" formaction="editPerson?id=<%=cstm.getId()%>&update=yes" type="submit">Salveaza</button></li>
            <li><button class="btn btn-large btn-primary" formmethod="get" formaction="general" type="reset">Renunta</button></li>
          </ul>
        </form>

</div>
</body>
</html>
