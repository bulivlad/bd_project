<%@ page import="java.util.ArrayList" %>
<%@ page import="ro.autoDealerSales.web.domain.CarForSale" %>
<%--
  Created by IntelliJ IDEA.
  User: Buli
  Date: 1/4/2015
  Time: 2:43 AM
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

      </style>

      <title>Informatii generale</title>

      <%
        ArrayList<CarForSale> carsForSale = (ArrayList<CarForSale>) request.getAttribute("carsForSale");
        ServletContext context = config.getServletContext();
        String sqlMessages = null;
        Integer sqlResult = (Integer) context.getAttribute("sqlResult");
        if(sqlResult != null)
        {
          if(sqlResult == 0) {
            sqlMessages="Eroare la update. Modificarile nu au fost salvate";
          }
          else {
            sqlMessages = "Modificarile au fost salvate cu succes";
          }
        }
      %>

      <script type="text/javascript">
        function popupOpen() {
          if(<%=sqlResult != null%>)
            alert("<%=sqlMessages%>");
        }
      </script>

      <%context.removeAttribute("sqlResult");%>

      </head>
      <body onload="popupOpen()">
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
        <div class="panel panel-default">
      <br><br><br>

      <center>
        <table style="width:70%" border="0">
          <tr><td>Marca</td><td>Model</td><td>Pret(EUR)</td><td>Actiuni</td></tr>
          <%
            for (CarForSale carForSale : carsForSale) {
          %>
          <tr><td><%=carForSale.getManufacturerName()%></td><td><%=carForSale.getModelName()%></td><td><%=carForSale.getAskingPrice()%></td>
            <td><form action="cars?id=<%=carForSale.getId()%>&action=viewOne" method="post"><input type="submit" value="View"></form></td>
            <td><form action="cars?id=<%=carForSale.getId()%>&action=editOne&update=no" method="post"><input type="submit" value="Edit"></form></td>
          <%
            }
          %>
        </table>
      </center>
      <br>
</div>

</body>
</html>
