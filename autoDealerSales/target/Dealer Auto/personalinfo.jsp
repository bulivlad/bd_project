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

  <%--MyCustom css--%>
  <link href="style/oldstyle.css" rel="stylesheet">

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

    <div class="panel panel-default">
    <%
      if(action.equals("persInfo")){
    %>
      <div class="label label-info">Date personale</div>
      <center>
      <table id="dataTable" style="width:60%" border="0" >
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
      </center>
      </div>
      <div align="right">
        <form>
          <ul id="buttonStyle">
            <li><button class="btn btn-large btn-primary" formmethod="post" formaction="editPerson?id=<%=cstm.getId()%>&update=no" type="submit">Edit</button></li>
            <li><button class="btn btn-large btn-primary" formmethod="post" formaction="deleteOne?id=<%=cstm.getId()%>" type="submit">Stergere</button></li>
          </ul>
        </form></div>

    <%
      }
      else{
    %>

      <div class="label label-info">Preferinte</div>
    <center>
      <table id="dataTable1" style="width:60%" border="0" align="center">
        <tr>
          <td><div class="label label-info">Preferintele clientului: <%=cstmPref.getCustomerPrefDetails()%></div></td>
        </tr>
        <tr>
          <td><div class="label label-info">Data platii: <%=cstmPay.getPaymentDate()%></div></td>
          <td><div class="label label-info">Statusul platii: <%=cstmPay.getPaymentStatus()%></div></td>
        </tr>
      </table>
    </center>
    </div>
    <div align="right">
    <form>
  <ul id="buttonStyle1">
    <li><button class="btn btn-large btn-primary" formmethod="post" formaction="editPerson?id=<%=cstm.getId()%>&update=no" type="submit">Edit</button></li>
    <li><button class="btn btn-large btn-primary" formmethod="post" formaction="deleteOne?id=<%=cstm.getId()%>" type="submit">Stergere</button></li>
  </ul>
    </form></div>
  <%
      }
    %>
</div>
</body>
</html>
