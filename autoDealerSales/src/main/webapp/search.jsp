<%@ page import="java.util.ArrayList" %>
<%@ page import="ro.autoDealerSales.web.domain.CarForSale" %>
<%@ page import="ro.autoDealerSales.web.domain.Customer" %>
<%@ page import="ro.autoDealerSales.web.domain.Address" %>
<%@ page import="ro.autoDealerSales.web.domain.HybridPerson" %>
<%--
  Created by IntelliJ IDEA.
  User: Buli
  Date: 1/11/2015
  Time: 8:30 PM
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

  <title>Cautare</title>

  <%
    ArrayList<HybridPerson> hybridPersonArrayLists = (ArrayList<HybridPerson>) request.getAttribute("hybridPersonArrayList");
    ArrayList<CarForSale> carForSaleArrayList = (ArrayList<CarForSale>) request.getAttribute("carForSaleArrayList");

//    ServletContext context = config.getServletContext();
//    String sqlMessages = null;
//    Integer sqlResult = (Integer) context.getAttribute("sqlResult");
////    if(sqlResult != null)
//    {
//      if(sqlResult == 0) {
//        sqlMessages="Eroare la update. Modificarile nu au fost salvate";
//      }
//      else {
//        sqlMessages = "Modificarile au fost salvate cu succes";
//      }
//    }
  %>

  <%--<script type="text/javascript">--%>
    <%--function popupOpen() {--%>
      <%--if(<%=sqlResult != null%>)--%>
        <%--alert("<%=sqlMessages%>");--%>
    <%--}--%>
  <%--</script>--%>

  <%--<%context.removeAttribute("sqlResult");%>--%>

</head>
<body>
<div class="container">
  <div class="panel panel-default">
    <div class="jumbotron">
      <h1 class="panel-title">Cautare</h1>
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
        <tr><td>Nume</td><td>Prenume</td><td>Adresa</td></tr>
        <%
          for (HybridPerson person : hybridPersonArrayLists) {
        %>
        <tr><td><%=person.getCustomer().getLastName()%></td><td><%=person.getCustomer().getFirstName()%></td><td><%=person.getAddress().getAddress()%></td>
          <td><form action="personal?id=<%=person.getCustomer().getId()%>&action=persInfo" method="post"><input type="submit" value="View"></form></td>
          <%--<td><form action="cars?id=<%=carForSale.getId()%>&action=editOne&update=no" method="post"><input type="submit" value="Edit"></form></td>--%>
            <%
            }
          %>
      </table>


    <br><br>


      <table id="firstTable1" style="width:70%" border="0">
        <tr><td>Marca</td><td>Model</td><td>Pret(EUR)</td></tr>
        <%
          for (int i = 0; i<carForSaleArrayList.size(); i++) {
        %>
        <tr><td><%=carForSaleArrayList.get(i).getManufacturerName()%></td><td><%=carForSaleArrayList.get(i).getModelName()%></td><td><%=carForSaleArrayList.get(i).getAskingPrice()%></td>
          <td><form action="cars?id=<%=carForSaleArrayList.get(i).getId()%>&action=viewOne" method="post"><input type="submit" value="View"></form></td>
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
