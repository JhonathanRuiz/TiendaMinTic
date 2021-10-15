package com.unibosque.Model;

import java.io.Serializable;


public class Provider implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer nit;
	
	private String ciudad;
	
	private String nombre;
	
	private String direccion;
	
	private String telefono;


	/* Getters And Setter */
	public Integer getNit() {
		return nit;
	}

	public void setNit(Integer nit) {
		this.nit = nit;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
}
