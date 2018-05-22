package com.reparaya.dtos;

public class ArrendadorDto {
	private int id;
	private String nombre;
	private String celular;
	
	public ArrendadorDto(int id, String nombre, String celular) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.celular = celular;
	}
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getCelular() {
		return celular;
	}
}
