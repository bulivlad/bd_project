<%@ page import="ro.autoDealerSales.web.domain.Customer" %>
<%@ page import="ro.autoDealerSales.web.domain.Address" %>
<%@ page import="ro.autoDealerSales.web.domain.CustomerPreference" %>
<%@ page import="ro.autoDealerSales.web.domain.CustomerPayments" %>
<%--
  Created by IntelliJ IDEA.
  User: Buli
  Date: 12/31/2014
  Time: 4:09 PM
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
      padding: 40px;
      font-size: x-large;
    }

    #dataTable div{
      background-color: #b3b3b3;
    }

    #dataTable1 td{
      padding: 40px;
      font-size: x-large;
    }

    #dataTable1 div{
      background-color: #b3b3b3;
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

    nav ul ul ul {
      position: absolute; left: 100%; top:0;
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

    #buttonStyle1 ul {
      list-style-type: none;
      overflow: hidden;
      margin: 0;
      padding: 0;
    }

    #buttonStyle1 li {
      display: inline;
      padding: 20px;
    }


  </style>

  <%
    Customer cstm = (Customer) request.getAttribute("customer");
    Address address = (Address) request.getAttribute("address");
    CustomerPreference cstmPref = (CustomerPreference) request.getAttribute("customerPreference");
    CustomerPayments cstmPay = (CustomerPayments) request.getAttribute("customerPayment");
  %>

  <%
//    Get info about action from url
    String action = null;
    action = request.getParameter("action");
  %>

  <title><%=cstm.getFirstName()%> <%=cstm.getLastName()%></title>
</head>
<body>
  <div class="container">
    <div class="panel panel-default">
      <div class="jumbotron">
        <h1 class="panel-title">Informatii detaliate</h1>
      </div>

      <nav>
        <ul>
          <li><a href="#">Clienti</a>
            <ul>
              <li><a href="general">Vizualizare</a>
                <ul>
                  <li><a class="navbar-text" href="personal?id=<%=cstm.getId().toString()%>&action=persInfo">Date personale</a></li>
                  <li><a class="navbar-text" href="personal?id=<%=cstm.getId().toString()%>&action=carInfo">Preferinte</a></li>
                </ul>
              </li>
              <li><a href="addOne">Adaugare</a></li>
            </ul>
          </li>
          <li><a href="#">Masini de vanzare</a>
            <ul>
              <li><a href="cars?action=viewAll">Vizualizare</a></li>
              <li><a href="cars?action=addOne">Adaugare</a></li>
            </ul>
          </li>
          <li><a href="rapoarte">Rapoarte</a></li>
        </ul>
      </nav>
    </div>

    <div class="panel panel-default">
    <%
      if(action.equals("persInfo")){
    %>
      <div class="label label-info">Date personale</div>
      <table id="dataTable" style="width:60%" border="0" align="center">
        <tr>
          <td><div class="label label-info">Prenume: <%=cstm.getFirstName()%></div></td>
          <td><div class="label label-info">Nume: <%=cstm.getLastName()%></div></td>
        </tr>
        <tr>
          <td><div class="label label-info">Email: <%=cstm.getEmail()%></div></td>
          <td><div class="label label-info">Numar de telefon: <%=cstm.getPhone()%></div></td>
        </tr>
  <%
    if(cstm.getOther() != null){
  %>
        <tr>
          <td><div class="label label-info">Alte detalii: <%=cstm.getOther()%></div></td>
        </tr>
  <%
    }
  %>
        <tr>
          <td><div class="label label-info">Adresa: <%=address.getAddress()%></div></td>
          <td><div class="label label-info">Cod postal: <%=address.getPostalCode()%></div></td>
        </tr>
        <tr>
          <td><div class="label label-info">Oras: <%=address.getTown()%></div></td>
          <td><div class="label label-info">Tara: <%=address.getCountry()%></div></td>
        </tr>
  <%
    if(address.getOther() != null){
  %>
        <tr>
          <td><div class="label label-info">Alte detalii: <%=address.getOther()%></div></td>
        </tr>
  <%
    }
  %>
      </table>
      </div>
      <div align="right">
        <form>
          <ul id="buttonStyle">
            <li><button class="btn btn-large btn-primary" formmethod="post" formaction="deleteOne?id=<%=cstm.getId()%>" type="submit">Stergere</button></li>
          </ul>
        </form></div>

    <%
      }
      else{
    %>

      <div class="label label-info">Preferinte</div>
      <table id="dataTable1" style="width:60%" border="0" align="center">
        <tr>
          <td><div class="label label-info">Preferintele clientului: <%=cstmPref.getCustomerPrefDetails()%></div></td>
        </tr>
        <tr>
          <td><div class="label label-info">Data platii: <%=cstmPay.getPaymentDate()%></div></td>
          <td><div class="label label-info">Statusul platii: <%=cstmPay.getPaymentStatus()%></div></td>
        </tr>
      </table>
    </div>
    <div align="right">
    <form>
  <ul id="buttonStyle1">
    <li><button class="btn btn-large btn-primary" formmethod="post" formaction="deleteOne?id=<%=cstm.getId()%>" type="submit">Stergere</button></li>
  </ul>
    </form></div>
  <%
      }
    %>
</div>
</body>
</html>
