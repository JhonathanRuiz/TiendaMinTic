package com.unibosque.Funcionality;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.unibosque.Model.Detalle;
import com.unibosque.Model.Response;
import com.unibosque.Model.ResponseProduct;
import com.unibosque.Model.ResponseT;
import com.unibosque.Model.Venta;
import com.unibosque.Service.ProductServiceImpl;
import com.unibosque.Service.UserServiceImpl;
import com.unibosque.Service.VentasServiceImpl;

/**
 * Servlet implementation class UserFuncionality
 */
@WebServlet("/VentaFuncionality")
public class VentaFuncionality extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VentaFuncionality() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 if (request.getParameter("consultar") != null ||request.getParameter("cedulacons") != null ) {
			 if(request.getParameter("confirmar") == null) {
			  	 consultarUsuario(request,response);
			 }
	     
	       	 
	     }
		 if (request.getParameter("consultaprod1") != null || request.getParameter("consultaprod2") != null || request.getParameter("consultaprod3") != null) {
			 ProductServiceImpl prod = new ProductServiceImpl();
			 ResponseProduct res = prod.getProduct(request.getParameter("codigo1"));
			 if (request.getParameter("codigo2") !=  "" && request.getParameter("codigo2") !=null) {
				 res.Listado.add(prod.getProduct(request.getParameter("codigo2")).getListado().get(0));
		     }
			 if (request.getParameter("codigo3") != "" && request.getParameter("codigo3") != null) {
				 res.Listado.add(prod.getProduct(request.getParameter("codigo3")).getListado().get(0));
		     }
			 request.setAttribute("ResponseProduct", res);
	     }
	     
	     if (request.getParameter("confirmar") != null) {
	    	 crearVenta(request,response);
	       	 
	     }
			request.getRequestDispatcher("Ventas.jsp").forward(request, response);
}
	

	public void consultarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			UserServiceImpl service = new UserServiceImpl();
			Response res = new Response();
			String cedula = request.getParameter("cedulacons");

		if(cedula != null) {
			res = service.getUser(cedula);
			request.setAttribute("Response", res);
	
		}
		}  catch(Exception excepcion) {
			System.out.print(excepcion.getMessage());
		}
		
	}
	
	public void crearVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			 HttpSession misession= (HttpSession) request.getSession();
			VentasServiceImpl service = new VentasServiceImpl();
			ResponseT res = new ResponseT();
			Venta venta = new Venta();
			List<Detalle> productos = new ArrayList<Detalle>();
			Float total = Float.parseFloat(request.getParameter("totalda"));
			Float iva = (19*100/total);
			venta.setCedula_cliente(request.getParameter("cedula_cliente"));
			venta.setCedula_usuario(misession.getAttribute("session").toString());
			venta.setIvaventa(iva.toString());
			venta.setTotal_venta(total.toString());
			venta.setValor_venta(total.toString());

			
			if(request.getParameter("nombre1") != null && request.getParameter("nombre1") != "") {	
				Detalle detalle = new Detalle();
				detalle.setCodigo_producto(request.getParameter("codigo1"));
				detalle.setCantidad(request.getParameter("cantidad1"));
				detalle.setValor_total(request.getParameter("total1"));
				productos.add(detalle);
				
			}
			if (request.getParameter("nombre2") != null && request.getParameter("nombre2") != "" ) {
				Detalle detalle = new Detalle();
				detalle.setCodigo_producto(request.getParameter("codigo2"));
				detalle.setCantidad(request.getParameter("cantidad2"));
				detalle.setValor_total(request.getParameter("total2"));
				productos.add(detalle);
				
			}
			if (request.getParameter("nombre3") != null && request.getParameter("nombre3") != "") {
				Detalle detalle = new Detalle();
				detalle.setCodigo_producto(request.getParameter("codigo3"));
				detalle.setCantidad(request.getParameter("cantidad3"));
				detalle.setValor_total(request.getParameter("total3"));
				productos.add(detalle);
				
			}
			service.createVenta(venta, productos);
			
			
	
		
	}catch(Exception e) {
		String er = e.getMessage();
		System.out.print(er);
	}
	}
}
