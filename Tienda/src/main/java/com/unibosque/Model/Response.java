package com.unibosque.Model;

import java.util.List;

public class Response {
	
	public String Respuesta;
	public String Mensaje;
	public List<User> Listado;
	
	
	public List<User> getListado() {
		return Listado;
	}
	public void setListado(List<User> listado) {
		Listado = listado;
	}

	
	public String getRespuesta() {
		return Respuesta;
	}
	public void setRespuesta(String respuesta) {
		Respuesta = respuesta;
	}
	public String getMensaje() {
		return Mensaje;
	}
	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}
	
	
}
