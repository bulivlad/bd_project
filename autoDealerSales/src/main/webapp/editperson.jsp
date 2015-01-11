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

  <%--MyCustom css--%>
  <link href="style/oldstyle.css" rel="stylesheet">
  <link href="style/navbar.css" rel="stylesheet">

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
          <li id="search">
            <form action="" method="get">
              <input type="text" name="search_text" id="search_text" placeholder="Search"/>
              <input type="submit" id="search_button"></a>
            </form>
          </li>
        </ul>
      </nav>
    </div>

    <form>
    <div class="panel panel-default">
      <center>
      <table id="dataTable" style="width:60%" border="0">
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
      </center>
    </div>



          <ul id="buttonStyle">
            <li><button class="btn btn-large btn-primary" formmethod="post" formaction="editPerson?id=<%=cstm.getId()%>&update=yes" type="submit">Salveaza</button></li>
            <li><button class="btn btn-large btn-primary" formmethod="get" formaction="general" type="reset">Renunta</button></li>
          </ul>
        </form>

</div>
</body>
</html>
