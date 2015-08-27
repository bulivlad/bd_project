<%@ page import="ro.autoDealerSales.web.dao.user.UserDao" %>
<%@ page import="ro.autoDealerSales.web.dao.user.UserDaoImpl" %>
<%@ page import="ro.autoDealerSales.web.domain.user.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Buli
  Date: 12/31/2014
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Dealer Auto</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- Le styles -->
  <link href="/dealer/bootstrap/css/bootstrap.css" rel="stylesheet">
  <link href="/dealer/style/login.css" rel="stylesheet">
  <style type="text/css">
    body {
      padding-top: 40px;
      padding-bottom: 40px;
      background-color: #f5f5f5;
    }



  </style>
  <link href="/dealer/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
  <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
  <!--[if lt IE 9]>
  <script src="../assets/js/html5shiv.js"></script>
  <![endif]-->

  <!-- Fav and touch icons -->
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
  <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  <link rel="shortcut icon" href="../assets/ico/favicon.png">

  <%
    ServletContext context = config.getServletContext();
    UserDao userDaoImpl = new UserDaoImpl();
    if(userDaoImpl.isUserAuthenticated()){
      User authenticatedUser = userDaoImpl.getAuthenticatedUser();
      if(authenticatedUser != null){
        context.setAttribute("user", authenticatedUser);
          context.setAttribute("relativePathToView","/WEB-INF/views");
        response.sendRedirect("general");
      }
    }
  %>
</head>

<body>

<div class="container">

  <form class="form-signin" action="login" method="POST">
    <h2 class="form-signin-heading">Please sign in</h2>
    <input type="text" class="input-block-level" name="usernameForm" placeholder="User">
    <input type="password" class="input-block-level" name="passwordForm" placeholder="Password">
    <button class="btn btn-large btn-primary" type="submit">Sign in</button>
  </form>

</div> <!-- /container -->



</body>
</html>