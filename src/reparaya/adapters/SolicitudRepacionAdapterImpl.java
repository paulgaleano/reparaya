package reparaya.adapters;

import java.util.ArrayList;
import java.util.List;

import reparaya.dtos.AgenciaDto;
import reparaya.dtos.ArrendatarioDto;
import reparaya.dtos.InmuebleDto;
import reparaya.dtos.SolicitudReparacionDto;

public class SolicitudRepacionAdapterImpl implements SolicitudReparacionAdapter {

	private static SolicitudRepacionAdapterImpl solicitudRepacionAdapterImpl;
	
	private SolicitudRepacionAdapterImpl(){
		
	}
	
	public static SolicitudRepacionAdapterImpl getInstance(){
		if(SolicitudRepacionAdapterImpl.solicitudRepacionAdapterImpl==null){
			SolicitudRepacionAdapterImpl.solicitudRepacionAdapterImpl=new SolicitudRepacionAdapterImpl();
		}
		return SolicitudRepacionAdapterImpl.solicitudRepacionAdapterImpl;
	}
	
	@Override
	public List<SolicitudReparacionDto> getSolicitudesNoAsignadas() {
		List<SolicitudReparacionDto> solicitudes=new ArrayList<SolicitudReparacionDto>(10);
		for(int i=0;i<10;i++){
			InmuebleDto inmuebleDto=new InmuebleDto(i, "cp"+i, "cd"+i, "cc"+i, "direccion"+i);
			ArrendatarioDto arrendatarioDto=new ArrendatarioDto(i+10, "nombre"+i, "celular"+i);
			AgenciaDto agenciaDto=new AgenciaDto(i+20, "nombreSede"+i, "direccion"+i, "telefono"+i);
			SolicitudReparacionDto solicitudReparacionDto=new SolicitudReparacionDto(i+30, inmuebleDto, arrendatarioDto,
					agenciaDto, "descripcion"+i);
			solicitudes.add(solicitudReparacionDto);
		}
		return solicitudes;
	}

}
