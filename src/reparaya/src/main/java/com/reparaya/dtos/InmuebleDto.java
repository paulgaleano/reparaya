package com.reparaya.dtos;

public class InmuebleDto {
	private int id;
	private String codigo_pais;
	private String pais;
	private String codigo_departamento;
	private String departamento;
	private String codigo_ciudad;
	private String ciudad;
	private String direccion;
	private ArrendatarioDto arrendatarioDto;
	private AgenciaDto agenciaDto;
	
	public InmuebleDto(int id, String codigo_pais, String codigo_departamento, String codigo_ciudad, String direccion, ArrendatarioDto arrendatarioDto,
			AgenciaDto agenciaDto) {
		this.id = id;
		this.codigo_pais = codigo_pais;
		this.codigo_departamento = codigo_departamento;
		this.codigo_ciudad = codigo_ciudad;
		this.direccion = direccion;
		this.arrendatarioDto = arrendatarioDto;
		this.agenciaDto = agenciaDto;
	}
	
	public int getId() {
		return id;
	}
	
	public String getCodigo_pais() {
		return codigo_pais;
	}
	
	public String getPais() {
		return pais;
	}
	
	public String getCodigo_departamento() {
		return codigo_departamento;
	}
	
	public String getDepartamento() {
		return departamento;
	}
	
	public String getCodigo_ciudad() {
		return codigo_ciudad;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public ArrendatarioDto getArrendatarioDto() {
		return arrendatarioDto;
	}
	
	public AgenciaDto getAgenciaDto() {
		return agenciaDto;
	}

	public void setCodigo_pais(String codigo_pais) {
		this.codigo_pais = codigo_pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public void setCodigo_departamento(String codigo_departamento) {
		this.codigo_departamento = codigo_departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public void setCodigo_ciudad(String codigo_ciudad) {
		this.codigo_ciudad = codigo_ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setArrendatarioDto(ArrendatarioDto arrendatarioDto) {
		this.arrendatarioDto = arrendatarioDto;
	}

	public void setAgenciaDto(AgenciaDto agenciaDto) {
		this.agenciaDto = agenciaDto;
	}
}
