package com.unibosque.Funcionality;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.unibosque.Model.ResponseProvider;
import com.unibosque.Model.Provider;
import com.unibosque.Service.ProviderServiceImpl;

/**
 * Servlet implementation class ProviderFuncionality
 */
@WebServlet("/ProviderFuncionality")
public class ProviderFuncionality extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProviderFuncionality() {
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
		 if (request.getParameter("editar") != null) {
			 
			 actualizarProveedor(request,response);

	     } else if (request.getParameter("eliminar") != null) {
	       	 eliminarProveedor(request,response);

	     }
	     else if (request.getParameter("crear") != null) {
	       	 crearProveedor(request,response);

	     }
	     else if (request.getParameter("consultar") != null) {
	       	 consultarProveedor(request,response);
	       	 
	     }
}
	
	public void eliminarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ResponseProvider res = new ResponseProvider();
		try {
		String cedula = request.getParameter("cedulacons");

		if(cedula != null) {
			
			ProviderServiceImpl service = new ProviderServiceImpl();
			res = service.deleteProvider(cedula);
			request.setAttribute("ResponseProvider", res);
			request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
		}
		}  catch(Exception excepcion) {
			res.Respuesta = "97";
			res.Mensaje = "Error de procedimiento";
			res.Listado = null;
			request.setAttribute("ResponseProvider", res);
			request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
		}
		
		
	}
	public void crearProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResponseProvider res = new ResponseProvider();
		Provider client = new Provider();
		try {
		client.setNit(Integer.parseInt(request.getParameter("nit")));
		client.setNombre(request.getParameter("nombre"));
		client.setCiudad(request.getParameter("ciudad"));
		client.setDireccion(request.getParameter("direccion"));
		client.setTelefono(request.getParameter("tel"));
		ProviderServiceImpl service = new ProviderServiceImpl();
		res = service.createProvider(client);
		request.setAttribute("ResponseProvider", res);
		request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
			
		}  catch(Exception excepcion) {
			res.Respuesta = "97";
			res.Mensaje = "Error de procedimiento";
			res.Listado = null;
			request.setAttribute("ResponseProvider", res);
			request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
		}

	
	}
	
	public void actualizarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResponseProvider res = new ResponseProvider();
		Provider client = new Provider();
		try {
		client.setNit(Integer.parseInt(request.getParameter("nit")));
		client.setNombre(request.getParameter("nombre"));
		client.setCiudad(request.getParameter("ciudad"));
		client.setDireccion(request.getParameter("direccion"));
		client.setTelefono(request.getParameter("tel"));
		ProviderServiceImpl service = new ProviderServiceImpl();
		res = service.updateProvider(client);
		request.setAttribute("ResponseProvider", res);
		request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
			
		}  catch(Exception excepcion) {
			res.Respuesta = "97";
			res.Mensaje = "Error de procedimiento";
			res.Listado = null;
			request.setAttribute("ResponseProvider", res);
			request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
		}

	
	}
	
	public void consultarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
		String cedula = request.getParameter("cedulacons");

		if(cedula != null) {
			
			ProviderServiceImpl service = new ProviderServiceImpl();
			ResponseProvider res = new ResponseProvider();
			res = service.getProvider(cedula);
			request.setAttribute("ResponseProvider", res);
			request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
		}
		}  catch(Exception excepcion) {
			System.out.print(excepcion.getMessage());
		}
		
	}
}
