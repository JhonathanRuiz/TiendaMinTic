package com.unibosque.Model;

import java.util.List;

public class ResponseProduct {

		public String Respuesta;
		public String Mensaje;
		public List<Product> Listado;
		
		
		public List<Product> getListado() {
			return Listado;
		}
		public void setListado(List<Product> listado) {
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
