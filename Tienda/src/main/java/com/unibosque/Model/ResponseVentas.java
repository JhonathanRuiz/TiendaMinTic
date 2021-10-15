 package com.unibosque.Model;

import java.util.List;

public class ResponseVentas {

		public String Respuesta;
		public String Mensaje;
		public List<Venta> Listado;
		
		
		public List<Venta> getListado() {
			return Listado;
		}
		public void setListado(List<Venta> listado) {
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
