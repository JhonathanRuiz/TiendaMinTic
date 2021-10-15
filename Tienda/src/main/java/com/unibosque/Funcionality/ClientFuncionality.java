package com.unibosque.Funcionality;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.unibosque.Model.ResponseClient;
import com.unibosque.Model.Client;
import com.unibosque.Service.ClientServiceImpl;

/**
 * Servlet implementation class ClientFuncionality
 */
@WebServlet("/ClientFuncionality")
public class ClientFuncionality extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientFuncionality() {
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
			 
			 actualizarCliente(request,response);

	     } else if (request.getParameter("eliminar") != null) {
	       	 eliminarCliente(request,response);

	     }
	     else if (request.getParameter("crear") != null) {
	       	 crearCliente(request,response);

	     }
	     else if (request.getParameter("consultar") != null) {
	       	 consultarCliente(request,response);
	       	 
	     }
}
	
	public void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ResponseClient res = new ResponseClient();
		try {
		String cedula = request.getParameter("cedulacons");

		if(cedula != null) {
			
			ClientServiceImpl service = new ClientServiceImpl();
			res = service.deleteClient(cedula);
			request.setAttribute("ResponseClient", res);
			request.getRequestDispatcher("Clientes.jsp").forward(request, response);
		}
		}  catch(Exception excepcion) {
			res.Respuesta = "97";
			res.Mensaje = "Error de procedimiento";
			res.Listado = null;
			request.setAttribute("ResponseDel", res);
			request.getRequestDispatcher("Clientes.jsp").forward(request, response);
		}
		
		
	}
	public void crearCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResponseClient res = new ResponseClient();
		Client client = new Client();
		try {
		client.setCedula(Integer.parseInt(request.getParameter("cedula")));
		client.setNombre(request.getParameter("nombre"));
		client.setCorreo(request.getParameter("correo"));
		client.setDireccion(request.getParameter("direccion"));
		client.setTelefono(request.getParameter("tel"));
		ClientServiceImpl service = new ClientServiceImpl();
		res = service.createClient(client);
		request.setAttribute("ResponseClient", res);
		request.getRequestDispatcher("Clientes.jsp").forward(request, response);
			
		}  catch(Exception excepcion) {
			res.Respuesta = "97";
			res.Mensaje = "Error de procedimiento";
			res.Listado = null;
			request.setAttribute("ResponseClient", res);
			request.getRequestDispatcher("Clientes.jsp").forward(request, response);
		}

	
	}
	
	public void actualizarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResponseClient res = new ResponseClient();
		Client client = new Client();
		try {
		client.setCedula(Integer.parseInt(request.getParameter("cedula")));
		client.setNombre(request.getParameter("nombre"));
		client.setCorreo(request.getParameter("correo"));
		client.setDireccion(request.getParameter("direccion"));
		client.setTelefono(request.getParameter("tel"));
		ClientServiceImpl service = new ClientServiceImpl();
		res = service.updateClient(client);
		request.setAttribute("Response", res);
		request.getRequestDispatcher("Clientes.jsp").forward(request, response);
			
		}  catch(Exception excepcion) {
			res.Respuesta = "97";
			res.Mensaje = "Error de procedimiento";
			res.Listado = null;
			request.setAttribute("ResponseClient", res);
			request.getRequestDispatcher("Clientes.jsp").forward(request, response);
		}

	
	}
	
	public void consultarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
		String cedula = request.getParameter("cedulacons");

		if(cedula != null) {
			
			ClientServiceImpl service = new ClientServiceImpl();
			ResponseClient res = new ResponseClient();
			res = service.getClient(cedula);
			request.setAttribute("ResponseClient", res);
			request.getRequestDispatcher("Clientes.jsp").forward(request, response);
		}
		}  catch(Exception excepcion) {
			System.out.print(excepcion.getMessage());
		}
		
	}
}
