<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <% 
  		  HttpSession misession= (HttpSession) request.getSession();
    	String cedula = (String) misession.getAttribute("session");
    	if(cedula == null || cedula == ""){
			response.sendRedirect("index.jsp");
    	}
    %>
   <%@ page import = "com.unibosque.Service.VentasServiceImpl,com.unibosque.Model.ResponseVentas,com.unibosque.Model.Venta,com.unibosque.Model.ResponseProduct,com.unibosque.Model.Response" %>
<!doctype html>
<html lang="es">

<head>
<style>

        .delete-btn {
            position: relative;
        }

        .delete {
            display: block;
            color: #000;
            text-decoration: none;
            position: absolute;
            background: #EEEEEE;
            font-weight: bold;
            padding: 0px 3px;
            border: 1px solid;
            top: -6px;
            left: -6px;
            font-family: Verdana;
            font-size: 12px;
        }
</style>
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
                                    <a href="Proveedores.jsp"  >
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
                                    <a href="Ventas.jsp" class="mm-active">
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
                    <form action="VentaFuncionality" method="post">
                     <div class="container">
                  
                        <div class="consulta d-flex">

                                <label class="d-flex" for="">Cedula: <input type="text" class="form-control ml-2" name="cedulacons" id="cedulacons"  value="<% if(request.getAttribute("Response") != null){
			        	
                                		Response respuesta  = (Response)request.getAttribute("Response");
				        	if(respuesta.getListado() != null){
				        		out.print(respuesta.getListado().get(0).getCedula());
	        				}
			   		}
			     	%>"><input
                                        type="submit" class="btn btn-primary ml-2" name="consultar"  ID="consultar" value="Consultar"></label>
                         


                            <div class="d-flex ml-2">
                                <label for="">Cliente: </label>
                                <input type="text" class="form-control" readonly value="<% if(request.getAttribute("Response") != null){
			        	
                		Response respuesta  = (Response)request.getAttribute("Response");
				        	if(respuesta.getListado() != null){
				        		out.print(respuesta.getListado().get(0).getNombre());
	        				}
			   		}
			     	%>">
                            </div>
                            <div class="d-flex">
                                <label for="">Consecutivo:</label>
                                <input type="text" class="form-control" readonly name="cedula_cliente" value="<% if(request.getAttribute("Response") != null){
			        	
                                		Response respuesta  = (Response)request.getAttribute("Response");
				        	if(respuesta.getListado() != null){
				        		out.print(respuesta.getListado().get(0).getCedula());
	        				}
			   		}
			     	%>">

                            </div>
                        </div>

                        <div class="productos d-flex">
                         
                         <div class="row">
            <div class="col-md-12">
                <div class="table-responsive">
                    <table class="table table-bordered">
                        <thead>
                            <tr class="item-row">
                                <th>Id</th>
                                <th>Nombre</th>
                                <th>Precio</th>
                                <th>Cantidad</th>
                                <th>Total</th>
                            </tr>
                        </thead>
                        <tbody>
                     
                
                      <tr class="item-row">
                         
                            <td><div class="input-group mb-3">
                        
							  <input type="text" class="form-control" placeholder="Id" name="codigo1" id="codigo1" aria-label="Recipient's username" aria-describedby="basic-addon2" value="<% if(request.getAttribute("ResponseProduct") != null){
			        	
                                                        		ResponseProduct respuesta  = (ResponseProduct)request.getAttribute("ResponseProduct");
										        	if(respuesta.getListado() != null){
										        		out.print(respuesta.getListado().get(0).getCodigo());
							        				}
									   		}
									     	%>">
							  <div class="input-group-append">
							    <input  class="btn btn-outline-secondary" type="submit" name="consultaprod1"  value="Consultar">
							  </div>
						
							</div>
							</td>
							
                                                        <td><input class="form-control item" placeholder="Nombre" type="text" name="nombre1" required readonly value="<% if(request.getAttribute("ResponseProduct") != null){
			        	
                                                        		ResponseProduct respuesta  = (ResponseProduct)request.getAttribute("ResponseProduct");
										        	if(respuesta.getListado() != null){
										        		out.print(respuesta.getListado().get(0).getNombre());
							        				}
									   		}
									     	%>"></td>
                            <td><input class="form-control price" placeholder="Precio" type="text" readonly value="<% if(request.getAttribute("ResponseProduct") != null){
			        	
                                                        		ResponseProduct respuesta  = (ResponseProduct)request.getAttribute("ResponseProduct");
										        	if(respuesta.getListado() != null){
										        		out.print(respuesta.getListado().get(0).getPrecio_venta());
							        				}
									   		}
									     	%>"></td>
                            <td><input class="form-control qty" placeholder="Cantidad" name="cantidad1" type="text" value="<% if(request.getAttribute("ResponseProduct") != null){out.print("1"); }%>"></td>
                            <td><input class="form-control total" name="total1" type="text" value="0" readonly></td>
                        
                        </tr>
                        
                      <tr class="item-row">
                
                               <td><div class="input-group mb-3">
                        
							  <input type="text" class="form-control" placeholder="Id" name="codigo2" id="codigo2" aria-label="Recipient's username" aria-describedby="basic-addon2" value="<% if(request.getAttribute("ResponseProduct") != null){
			        	
                                                        		ResponseProduct respuesta  = (ResponseProduct)request.getAttribute("ResponseProduct");
										        	if(respuesta.getListado().size()>=2){
										        		out.print(respuesta.getListado().get(1).getCodigo());
							        				}
									   		}
									     	%>">
							  <div class="input-group-append">
							    <input  class="btn btn-outline-secondary" type="submit" name="consultaprod2"  value="Consultar">
							  </div>
						
							</div>
							</td>
							
                                                        <td><input class="form-control item" placeholder="Nombre" type="text" name="nombre2" required readonly value="<% if(request.getAttribute("ResponseProduct") != null){
			        	
                                                        		ResponseProduct respuesta  = (ResponseProduct)request.getAttribute("ResponseProduct");
										        	if(respuesta.getListado().size()>=2){
										        		out.print(respuesta.getListado().get(1).getNombre());
							        				}
									   		}
									     	%>"></td>
                            <td><input class="form-control price" placeholder="Precio" type="text" readonly value="<% if(request.getAttribute("ResponseProduct") != null){
			        	
                                                        		ResponseProduct respuesta  = (ResponseProduct)request.getAttribute("ResponseProduct");
										        	if(respuesta.getListado().size()>=2){
										        		out.print(respuesta.getListado().get(1).getPrecio_venta());
							        				}
									   		}
									     	%>"></td>
                            <td><input class="form-control qty" placeholder="Cantidad" name="cantidad2" type="text" value="<% if(request.getAttribute("ResponseProduct") != null){out.print("1"); }%>"></td>
                            <td><input class="form-control total" name="total2" type="text" value="0" readonly></td>
                        
                        
                        <tr>
                        
                           <tr class="item-row">
                                <td><div class="input-group mb-3">
                        
							  <input type="text" class="form-control" placeholder="Id" name="codigo3" id="codigo3" aria-label="Recipient's username" aria-describedby="basic-addon2" value="<% if(request.getAttribute("ResponseProduct") != null){
			        	
                                                        		ResponseProduct respuesta  = (ResponseProduct)request.getAttribute("ResponseProduct");
										        	if(respuesta.getListado().size() >= 3){
										        		out.print(respuesta.getListado().get(2).getCodigo());
							        				}
									   		}
									     	%>">
							  <div class="input-group-append">
							    <input  class="btn btn-outline-secondary" type="submit" name="consultaprod3"  value="Consultar">
							  </div>
						
							</div>
							</td>
							
                                                        <td><input class="form-control item" placeholder="Nombre" type="text" name="nombre3" required readonly value="<% if(request.getAttribute("ResponseProduct") != null){
			        	
                                                        		ResponseProduct respuesta  = (ResponseProduct)request.getAttribute("ResponseProduct");
										        	if((respuesta.getListado().size() >= 3)){
										        		out.print(respuesta.getListado().get(2).getNombre());
							        				}
									   		}
									     	%>"></td>
                            <td><input class="form-control price" placeholder="Precio" type="text" readonly value="<% if(request.getAttribute("ResponseProduct") != null){
			        	
                                                        		ResponseProduct respuesta  = (ResponseProduct)request.getAttribute("ResponseProduct");
										        	if(respuesta.getListado().size()>=3){
										        		out.print(respuesta.getListado().get(2).getPrecio_venta());
							        				}
									   		}
									     	%>"></td>
                            <td><input class="form-control qty" placeholder="Cantidad" name="cantidad3" type="text" value="<% if(request.getAttribute("ResponseProduct") != null){out.print("1"); }%>"></td>
                            <td><input class="form-control total" name="total3" type="text" value="0" readonly></td>
                        
                        
                        <tr>
                            <td></td>
                            <td></td>
                            <td class="text-right"><strong>Sub Total</strong></td>
                            <td><input type="text" name="subtotal" id="subtotal" value="0" readonly class="form-control"></td>
                        </tr>
                       
                        <tr>
                            <td></td>
                            <td></td>
                            <td class="text-right"><strong>Grand Total</strong></td>
                            <td><input type="text" name="totalda" id="grandTotal"  readonly class="form-control"></td>
                        </tr>
                        </tbody>
                    </table>
                    <input type="submit" name="confirmar" value="Confirmar" class="btn btn-primary">
                </div>
            </div>
        </div>
                        </div>


                    </div>
                    </form>
                </div>
                        </div>
        
           </div>
                     </div>
                <script src="http://maps.google.com/maps/api/js?sensor=true"></script>
 
    <script>
	<% if(request.getAttribute("Response") != null){
    	
		Response respuesta  = (Response)request.getAttribute("Response");
    
 	
     %>
     alert('<%out.print(respuesta.Mensaje);%>');
    <%} %>
    
	<% if(request.getAttribute("ResponseProduct") != null){
    	
		ResponseProduct respuesta  = (ResponseProduct)request.getAttribute("ResponseProduct");
    
 	
     %>
     alert('<%out.print(respuesta.Mensaje);%>');
    <%} %>

    </script>
<script type="text/javascript" src="./assets/scripts/main.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script type="text/javascript" src="./assets/js/jquery.invoice.js"></script>

    <script>
        jQuery(document).ready(function(){
            jQuery().invoice({
                addRow : "#addRow",
                delete : ".delete",
                parentClass : ".item-row",

                price : ".price",
                qty : ".qty",
                total : ".total",
                totalQty: "#totalQty",

                subtotal : "#subtotal",
                discount: "#discount",
                shipping : "#shipping",
                grandTotal : "#grandTotal"
            });
        });
    </script>
</body>

</html>
    