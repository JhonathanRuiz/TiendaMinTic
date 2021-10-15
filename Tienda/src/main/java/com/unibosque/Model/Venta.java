package com.unibosque.Model;

public class Venta {
	 
		private static final long serialVersionUID = 1L;

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public Integer getCodigo() {
			return codigo;
		}

		public void setCodigo(Integer codigo) {
			this.codigo = codigo;
		}

		public String getCedulacliente() {
			return cedulacliente;
		}

		public void setCedulacliente(String cedulacliente) {
			this.cedulacliente = cedulacliente;
		}

		public String getCedulausuario() {
			return cedulausuario;
		}

		public void setCedulausuario(String cedulausuario) {
			this.cedulausuario = cedulausuario;
		}

		public String getIvaventa() {
			return ivaventa;
		}

		public void setIvaventa(String ivaventa) {
			this.ivaventa = ivaventa;
		}

		public String getTotalventa() {
			return totalventa;
		}

		public void setTotalventa(String totalventa) {
			this.totalventa = totalventa;
		}

		public String getValorventa() {
			return valorventa;
		}

		public void setValorventa(String valorventa) {
			this.valorventa = valorventa;
		}

		private Integer codigo;
		
		private String cedulacliente;
		
		public String getNombrecliente() {
			return nombrecliente;
		}

		public void setNombrecliente(String nombrecliente) {
			this.nombrecliente = nombrecliente;
		}

		private String nombrecliente;
		
		private String cedulausuario;
		
		private String ivaventa;
		
		private String totalventa;
		
		private String valorventa;


		
}
