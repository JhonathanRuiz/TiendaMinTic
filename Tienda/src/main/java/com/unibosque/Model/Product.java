package com.unibosque.Model;

public class Product {
	
	 
	private Integer codigo;
	
	private String nit_proveedor;
	
	private String nombre;
	
	private int precio_compra;
	
	private int ivacompra;
	
	private int precio_venta;
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNit_proveedor() {
		return nit_proveedor;
	}

	public void setNit_proveedor(String nit_proveedor) {
		this.nit_proveedor = nit_proveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(int precio_compra) {
		this.precio_compra = precio_compra;
	}

	public int getIvacompra() {
		return ivacompra;
	}

	public void setIvacompra(int ivacompra) {
		this.ivacompra = ivacompra;
	}

	public int getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(int precio_venta) {
		this.precio_venta = precio_venta;
	}



	

}
