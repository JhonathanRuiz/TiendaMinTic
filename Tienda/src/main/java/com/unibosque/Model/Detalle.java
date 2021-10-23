package com.unibosque.Model;

import java.io.Serializable;


public class Detalle implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer codigo;

	private String cantidad;
	
	private String codigo_producto;
	
	private String codigo_venta;
	
	private String valor_total;
	
	private String valor_venta;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(String codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public String getCodigo_venta() {
		return codigo_venta;
	}

	public void setCodigo_venta(String codigo_venta) {
		this.codigo_venta = codigo_venta;
	}

	public String getValor_total() {
		return valor_total;
	}

	public void setValor_total(String valor_total) {
		this.valor_total = valor_total;
	}

	public String getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(String valor_venta) {
		this.valor_venta = valor_venta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
