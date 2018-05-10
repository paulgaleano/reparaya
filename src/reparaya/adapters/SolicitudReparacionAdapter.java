package reparaya.adapters;

import java.util.List;

import reparaya.dtos.SolicitudReparacionDto;

public interface SolicitudReparacionAdapter {
	public List<SolicitudReparacionDto> getSolicitudesNoAsignadas();
}
