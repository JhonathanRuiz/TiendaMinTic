package com.unibosque.Model;

import java.io.Serializable;


public class Client implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer cedula;
	
	private String correo;
	
	private String nombre;
	
	private String direccion;
	
	private String telefono;


	/* Getters And Setter */
	public Integer getCedula() {
		return cedula;
	}

	public void setCedula(Integer cedula) {
		this.cedula = cedula;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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
