package com.reparaya.dtos;

public class AgenciaDto {
	private int id;
	private String nombreSede;
	private String direccion;
	private String telefono;
	
	public AgenciaDto(int id, String nombreSede, String direccion, String telefono) {
		super();
		this.id = id;
		this.nombreSede = nombreSede;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	public int getId() {
		return id;
	}
	public String getNombreSede() {
		return nombreSede;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getTelefono() {
		return telefono;
	}
}
