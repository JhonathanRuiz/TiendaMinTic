package com.unibosque.Model;

import java.util.List;

public class ResponseProvider {

		public String Respuesta;
		public String Mensaje;
		public List<Provider> Listado;
		
		
		public List<Provider> getListado() {
			return Listado;
		}
		public void setListado(List<Provider> listado) {
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
