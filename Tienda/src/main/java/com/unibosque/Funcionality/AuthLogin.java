package com.unibosque.Funcionality;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.unibosque.Service.LoginServiceImpl;

import com.unibosque.Model.Response;
import com.unibosque.Model.User;

@WebServlet("/AuthLogin")
public class AuthLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthLogin() {
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
		Response res = new Response();
		try {
		User user= new User();
		HttpSession misession= request.getSession(true);
		user.setPassword(request.getParameter("pass"));
		user.setUsuario(request.getParameter("usuario"));
		if(user.getUsuario() != null) {
			
			LoginServiceImpl log = new LoginServiceImpl();
			res = log.authCliente(user);
			if (res.getRespuesta() == "00") {
				request.setAttribute("Response", res);
				String passsend = res.getListado().get(0).getPassword();
				String pass = convertirSHA256(user.getPassword());
				if(passsend.equals(pass) ) {
					
					response.sendRedirect("Panel.jsp");
					misession.setAttribute("session", res.getListado().get(0).getCedula().toString());
				}else {
					res.Respuesta = "96";
					res.Mensaje = "Contraseña incorrecta";
					res.Listado = null;
					request.setAttribute("Response", res);
					request.getRequestDispatcher("index.jsp").forward(request, response);
					
				}
			}
			else {
				res.Respuesta = "99";
				res.Mensaje = "No existe en la BD";
				res.Listado = null;
				request.setAttribute("Response", res);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
		}else {
			res.Respuesta = "98";
			res.Mensaje = "Cedula Nula";
			res.Listado = null;
			request.setAttribute("Response", res);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
		}  catch(Exception excepcion) {
			res.Respuesta = "97";
			res.Mensaje = "Error de procedimiento";
			res.Listado = null;
			request.setAttribute("Response", res);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
	}
	private String convertirSHA256(String password) {
		// TODO Auto-generated method stub
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} 
		catch (NoSuchAlgorithmException e) {		
			e.printStackTrace();
			return null;
		}
		    
		byte[] hash = md.digest(password.getBytes());
		StringBuffer sb = new StringBuffer();
		    
		for(byte b : hash) {        
			sb.append(String.format("%02x", b));
		}
		    
		return sb.toString();
	}
}
