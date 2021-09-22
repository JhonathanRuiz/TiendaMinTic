<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="assets/css/style.css">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <!-- CSS only -->
  
</head>
<body class="clase1">
    <div class="d-flex justify-content-center align-items-center flex-column">
    <h1>Bienvenidos a la Tienda Genérica</h1>
    <form action="AuthLogin" method="Post">
        <label for="usuario">Usuarios
            <input type="text" id="usuario" name="usuario"  class="form-control">
        </label><br>
        <label for="pass">Contraseña
            <input type="password" id="pass" name="pass"  class="form-control">
        </label><br>
        <div class="d-flex justify-content-center align-items-center " style="margin: 20px 0;">
            <input type="submit" value="Aceptar" class="btn btn-outline-success">
            <button class="btn btn-outline-danger">Cancelar</button>
        </div>
        </form>
        <% if(request.getAttribute("usuario") != null){
        	String usuario  = (String)request.getAttribute("usuario");
        	
         %>
        <%=usuario%>
        <%} %>
    </div>
</body>
</html>