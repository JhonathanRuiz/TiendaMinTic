package com.unibosque.Model;

import java.util.List;

public class ResponseClient {

		public String Respuesta;
		public String Mensaje;
		public List<Client> Listado;
		
		
		public List<Client> getListado() {
			return Listado;
		}
		public void setListado(List<Client> listado) {
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
