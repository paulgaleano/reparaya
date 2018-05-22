package com.reparaya.dtos;

public class SolicitudReparacionDto {
	private String id;
	private String descripcion;
	private int state;
	private InmuebleDto inmuebleDto;
	
	public SolicitudReparacionDto(String id, String descripcion, InmuebleDto inmuebleDto) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.state=0;
		this.inmuebleDto = inmuebleDto;
	}
	
	public String getId() {
		return id;
	}
	
	public InmuebleDto getInmuebleDto() {
		return inmuebleDto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}
