package com.reparaya.dtos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AppointmentDto {
	private String IDEmpleadoAsignado;
	private String IDSolicitud;
	private String TipoVisita;
	
	public AppointmentDto(String iDEmpleadoAsignado, String iDSolicitud, String tipoVisita) {
		this.IDEmpleadoAsignado = iDEmpleadoAsignado;
		this.IDSolicitud = iDSolicitud;
		this.TipoVisita = tipoVisita;
	}
	
	public String getIDEmpleadoAsignado() {
		return IDEmpleadoAsignado;
	}
	
	public void setIDEmpleadoAsignado(String iDEmpleadoAsignado) {
		IDEmpleadoAsignado = iDEmpleadoAsignado;
	}
	
	public String getIDSolicitud() {
		return IDSolicitud;
	}
	
	public void setIDSolicitud(String iDSolicitud) {
		IDSolicitud = iDSolicitud;
	}
	
	public String getTipoVisita() {
		return TipoVisita;
	}
	
	public void setTipoVisita(String tipoVisita) {
		TipoVisita = tipoVisita;
	}
	
	public String toJson() {
		return "{\"IDEmpleadoAsignado\":\""+this.getIDEmpleadoAsignado()+"\",\"IDSolicitud\":\""+this.getIDSolicitud()+"\",\"TipoVisita\":\""+this.getTipoVisita()+"\"}";
	}
}