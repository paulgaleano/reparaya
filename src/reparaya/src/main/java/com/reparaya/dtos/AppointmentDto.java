package com.reparaya.dtos;

public class AppointmentDto {

	private String IDEmpleadoAsignado;
	private String IDSolicitud;
	private String TipoVisita;
	
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
}