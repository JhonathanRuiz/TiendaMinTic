<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <% 
  		  HttpSession misession= (HttpSession) request.getSession();
    	String cedula = (String) misession.getAttribute("session");
    	if(cedula == null || cedula == ""){
			response.sendRedirect("index.jsp");
    	}
    %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
   <%@ page import = "com.unibosque.Service.UserServiceImpl,com.unibosque.Model.ResponseClient,com.unibosque.Model.Client" %>
<!doctype html>
<html lang="es">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Language" content="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Analytics Dashboard - This is an example dashboard created using build-in elements and components.</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
    <meta name="description" content="This is an example dashboard created using build-in elements and components.">
    <meta name="msapplication-tap-highlight" content="no">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<link href="assets/css/mainui.css" rel="stylesheet"></head>
<body>
    <div class="app-container app-theme-white body-tabs-shadow fixed-sidebar fixed-header">
        <div class="app-header header-shadow">
            <div class="app-header__logo">
                <div class="logo-src">TIENDA</div>
                <div class="header__pane ml-auto">
                    <div>
                        <button type="button" class="hamburger close-sidebar-btn hamburger--elastic" data-class="closed-sidebar">
                            <span class="hamburger-box">
                                <span class="hamburger-inner"></span>
                            </span>
                        </button>
                    </div>
                </div>
            </div>
            <div class="app-header__mobile-menu">
                <div>
                    <button type="button" class="hamburger hamburger--elastic mobile-toggle-nav">
                        <span class="hamburger-box">
                            <span class="hamburger-inner"></span>
                        </span>
                    </button>
                </div>
            </div>
            <div class="app-header__menu">
                <span>
                    <button type="button" class="btn-icon btn-icon-only btn btn-primary btn-sm mobile-toggle-header-nav">
                        <span class="btn-icon-wrapper">
                            <i class="fa fa-ellipsis-v fa-w-6"></i>
                        </span>
                    </button>
                </span>
            </div>    <div class="app-header__content">
              
                <div class="app-header-right">
                    <div class="header-btn-lg pr-0">
                        <div class="widget-content p-0">
                            <div class="widget-content-wrapper">
                                <div class="widget-content-left">
                                    <div class="btn-group">
                                        <a data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="p-0 btn">
                                         
                                            <i class="fa fa-angle-down ml-2 opacity-8"></i>
                                        </a>
                                        <div tabindex="-1" role="menu" aria-hidden="true" class="dropdown-menu dropdown-menu-right">
    
                                            <button type="button" tabindex="0" class="dropdown-item">Logout</button>
                                        </div>
                                    </div>
                                </div>
                                <div class="widget-content-left  ml-3 header-user-info">
                                    <div class="widget-heading">
                                        Alina Mclourd
                                    </div>
                                    <div class="widget-subheading">
                                        VP People Manager
                                    </div>
                                </div>
                                
                            </div>
                        </div>
                    </div>        </div>
            </div>
        </div>          <div class="app-main">
                <div class="app-sidebar sidebar-shadow">
                    <div class="app-header__logo">
                        <div class="logo-src"></div>
                        <div class="header__pane ml-auto">
                            <div>
                                <button type="button" class="hamburger close-sidebar-btn hamburger--elastic" data-class="closed-sidebar">
                                    <span class="hamburger-box">
                                        <span class="hamburger-inner"></span>
                                    </span>
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="app-header__mobile-menu">
                        <div>
                            <button type="button" class="hamburger hamburger--elastic mobile-toggle-nav">
                                <span class="hamburger-box">
                                    <span class="hamburger-inner"></span>
                                </span>
                            </button>
                        </div>
                    </div>
                    <div class="app-header__menu">
                        <span>
                            <button type="button" class="btn-icon btn-icon-only btn btn-primary btn-sm mobile-toggle-header-nav">
                                <span class="btn-icon-wrapper">
                                    <i class="fa fa-ellipsis-v fa-w-6"></i>
                                </span>
                            </button>
                        </span>
                    </div>    <div class="scrollbar-sidebar">
                        <div class="app-sidebar__inner">
                            <ul class="vertical-nav-menu">
                                <li class="app-sidebar__heading">Dashboards</li>
                                <li>
                                    <a href="Panel.jsp">
                                        <i class="metismenu-icon fa fa-angle-down"></i>
                                        Inicio
                                    </a>
                                </li>
                                 <li>
                                    <a href="Usuarios.jsp" >
                                        <i class="metismenu-icon fa fa-angle-down"></i>
                              				Usuarios
                                    </a>
                                </li>
                                   <li>
                                    <a href="Clientes.jsp"  >
                                        <i class="metismenu-icon fa fa-angle-down"></i>
                              				Clientes
                                    </a>
                                </li>
                                
                                    <li>
                                    <a href="Proveedores.jsp">
                                        <i class="metismenu-icon fa fa-angle-down"></i>
                              				Proveedores
                                    </a>
                                </li>
                                 <li>
                                    <a href="Productos.jsp" >
                                        <i class="metismenu-icon fa fa-angle-down"></i>
                              				Productos
                                    </a>
                                </li>
                                
                                   <li>
                                    <a href="Ventas.jsp">
                                        <i class="metismenu-icon fa fa-angle-down"></i>
                              				Ventas
                                    </a>
                                </li>
                                
                                    <li>
                                    <a href="Reportes.jsp" class="mm-active" >
                                        <i class="metismenu-icon fa fa-angle-down"></i>
                              				Reportes
                                    </a>
                                </li>
                                
                               
                            </ul>
                        </div>
                    </div>
                </div>    <div class="app-main__outer">
                    <div class="app-main__inner">
               
                        
                  <div class="col-md-12 order-md-1">
          <h4 class="mb-3">Listado de Clientes</h4>
          <form action="ClientFuncionality" method="POST">
              <div class="col-md-6  mb-3 p-0 d-flex">
                
                     		
                </div>
          
          </form>
          <form class="needs-validation" action="ClientFuncionality" method="POST" id="form">
      
            <div class="row">
            
         <sql:setDataSource
        var="myDS"
        driver="org.sqlite.JDBC"
        url="jdbc:sqlite:C:/sqlite/tienda.db"
    />
 
<sql:query var="listClientes"   dataSource="${myDS}">
        SELECT * FROM clientes; 
    </sql:query>
     
    <div align="center">
        <table border="1" cellpadding="5">
            <tr>
                <th>Cédula</th>
                <th>Nombre</th>
                <th>Correo Electronico </th>
                <th>Dirección </th>
                <th>Telefono </th>
            </tr>
            <c:forEach var="clientes" items="${listClientes.rows}">
                <tr>
                    <td><c:out value="${clientes.cedula}" /></td>
                    <td><c:out value="${clientes.nombre}" /></td>
                    <td><c:out value="${clientes.correo}" /></td>
                    <td><c:out value="${clientes.direccion}" /></td>
                    <td><c:out value="${clientes.telefono}" /></td>
             
                </tr>
            </c:forEach>
        </table>
    </div>


            
             
             
            
            </div>
            
          </form>
        </div>

           </div>
                     </div>
                <script src="http://maps.google.com/maps/api/js?sensor=true"></script>
        </div>
    </div>
    <script>
	<% if(request.getAttribute("ResponseClient") != null){
    	
		ResponseClient respuesta  = (ResponseClient)request.getAttribute("ResponseClient");
				
     %>
     alert('<%out.print(respuesta.Mensaje);%>');
	
    <%} %>

    </script>
<script type="text/javascript" src="./assets/scripts/main.js"></script></body>
</html>
    