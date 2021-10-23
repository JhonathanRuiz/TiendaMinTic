<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <% 
  		  HttpSession misession= (HttpSession) request.getSession();
    	String cedula = (String) misession.getAttribute("session");
    	if(cedula == null || cedula == ""){
			response.sendRedirect("index.jsp");
    	}
    %>
   <%@ page import = "com.unibosque.Service.UserServiceImpl,com.unibosque.Model.ResponseT,com.unibosque.Model.User" %>
<!doctype html>
<html lang="es">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Language" content="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Productos</title>
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
                                    <a href="Clientes.jsp" >
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
                                    <a href="Productos.jsp"  class="mm-active">
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
                                    <a href="Reportes.jsp" >
                                        <i class="metismenu-icon fa fa-angle-down"></i>
                              				Reportes
                                    </a>
                                </li>
                                
                               
                            </ul>
                        </div>
                    </div>
                </div>    <div class="app-main__outer">
                    <div class="app-main__inner">
               
                        
					    <form method="post" action="fileuploadservlet"  enctype="multipart/form-data">
								    <input type="file" name="file" class="form-control" accept=".csv" />
								    <input type="submit" value="Cargar" class="btn btn-primary" />
					  </form>

  
           </div>
                     </div>
                <script src="http://maps.google.com/maps/api/js?sensor=true"></script>
        </div>
    </div>
    <script>
	<% if(request.getAttribute("ResponseT") != null){
    	
    	ResponseT respuesta  = (ResponseT)request.getAttribute("ResponseT");
    
 	
     %>
     alert('<%out.print(respuesta.Mensaje);%>');
    <%} %>

    </script>
<script type="text/javascript" src="./assets/scripts/main.js"></script></body>
</html>
    