package com.unibosque.Funcionality;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.unibosque.Model.Response;
import com.unibosque.Model.User;
import com.unibosque.Service.UserServiceImpl;

/**
 * Servlet implementation class UserFuncionality
 */
@WebServlet("/UserFuncionality")
public class UserFuncionality extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserFuncionality() {
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
			 
			 actualizarUsuario(request,response);

	     } else if (request.getParameter("eliminar") != null) {
	       	 eliminarUsuario(request,response);

	     }
	     else if (request.getParameter("crear") != null) {
	       	 crearUsuario(request,response);

	     }
	     else if (request.getParameter("consultar") != null) {
	       	 consultarUsuario(request,response);
	       	 
	     }
}
	
	public void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Response res = new Response();
		try {
		String cedula = request.getParameter("cedula");

		if(cedula != null) {
			
			UserServiceImpl service = new UserServiceImpl();
			res = service.deleteUser(cedula);
			request.setAttribute("Response", res);
			request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
		}
		}  catch(Exception excepcion) {
			res.Respuesta = "97";
			res.Mensaje = "Error de procedimiento";
			res.Listado = null;
			request.setAttribute("ResponseDel", res);
			request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
		}
		
		
	}
	public void crearUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Response res = new Response();
		User user = new User();
		try {
		user.setCedula(Integer.parseInt(request.getParameter("cedula")));
		user.setNombre(request.getParameter("nombre"));
		user.setCorreo(request.getParameter("correo"));
		user.setUsuario(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		UserServiceImpl service = new UserServiceImpl();
		res = service.createUser(user);
		request.setAttribute("Response", res);
		request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
			
		}  catch(Exception excepcion) {
			res.Respuesta = "97";
			res.Mensaje = "Error de procedimiento";
			res.Listado = null;
			request.setAttribute("Response", res);
			request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
		}

	
	}
	
	public void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Response res = new Response();
		User user = new User();
		try {
			user.setCedula(Integer.parseInt(request.getParameter("cedula")));
		user.setNombre(request.getParameter("nombre"));
		user.setCorreo(request.getParameter("correo"));
		user.setUsuario(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		UserServiceImpl service = new UserServiceImpl();
		res = service.updateUser(user);
		request.setAttribute("Response", res);
		request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
			
		}  catch(Exception excepcion) {
			res.Respuesta = "97";
			res.Mensaje = "Error de procedimiento";
			res.Listado = null;
			request.setAttribute("Response", res);
			request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
		}

	
	}
	
	public void consultarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
		String cedula = request.getParameter("cedulacons");

		if(cedula != null) {
			
			UserServiceImpl service = new UserServiceImpl();
			Response res = new Response();
			res = service.getUser(cedula);
			request.setAttribute("Response", res);
			request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
		}
		}  catch(Exception excepcion) {
			System.out.print(excepcion.getMessage());
		}
		
	}
}
