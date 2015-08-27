<%@ page import="ro.autoDealerSales.web.domain.HybridInvoice" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Buli
  Date: 1/14/2015
  Time: 2:01 AM
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

  <title>Facturi</title>

  <%
    ServletContext context = config.getServletContext();

    ArrayList<HybridInvoice> hybridInvoiceArrayLists = (ArrayList<HybridInvoice>) context.getAttribute("hybridInvoiceArrayList");
    Integer numberOfInvoicesUnpaid = (Integer) request.getAttribute("numberOfInvoicesUnpaid");

  %>

</head>
<body>
<div class="container">
  <div class="panel panel-default">
    <div class="jumbotron">
      <h1 class="panel-title">Informatii generale despre facturi</h1>
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
  <div class="panel panel-default">
    <br><br><br>

    <center>
      <table id="firstTable" style="width:70%" border="0">
        <tr><td>Nume</td><td>Prenume</td><td>Marca</td><td>Model</td><td>Pret(EUR)</td><td>Status factura</td></tr>
        <%
          for (HybridInvoice invoice : hybridInvoiceArrayLists) {
        %>
        <tr><td><%=invoice.getCustomer().getLastName()%></td><td><%=invoice.getCustomer().getFirstName()%></td><td><%=invoice.getCarForSale().getManufacturerName()%></td><td><%=invoice.getCarForSale().getModelName()%></td><td><%=invoice.getCarSold().getAgreedPrice()%></td><td><%=invoice.getCustomerPayments().getPaymentStatus()%></td>
          <td><form action="personal?id=<%=invoice.getCustomer().getId()%>&action=persInfo" method="post"><input type="submit" value="View"></form></td>
          <%--<td><form action="cars?id=<%=carForSale.getId()%>&action=editOne&update=no" method="post"><input type="submit" value="Edit"></form></td>--%>
            <%
            }
          %>
      </table>
    </center>

    <br><br><br>
  </div>

</body>
</html>
