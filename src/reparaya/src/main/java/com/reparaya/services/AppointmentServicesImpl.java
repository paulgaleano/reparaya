package com.reparaya.services;

import java.util.List;

import com.reparaya.adapters.AppointmentODataAdapterImpl;
import com.reparaya.adapters.InmuebleODataAdapterImpl;
import com.reparaya.adapters.SolicitudRepacionODataAdapterImpl;
import com.reparaya.adapters.SolicitudReparacionAdapter;
import com.reparaya.dtos.SolicitudReparacionDto;

public class AppointmentServicesImpl implements AppointmentServices {
	private static AppointmentServicesImpl appointmentServicesImpl;
	private SolicitudReparacionAdapter solicitudReparacionAdapter;
	private List<SolicitudReparacionDto> solicitudesRepacion;
	
	private AppointmentServicesImpl() {
		this.solicitudReparacionAdapter=SolicitudRepacionODataAdapterImpl.getInstance();
	}
	
	public static AppointmentServicesImpl getInstance() {
		if(AppointmentServicesImpl.appointmentServicesImpl==null) {
			AppointmentServicesImpl.appointmentServicesImpl=new AppointmentServicesImpl();
		}
		return AppointmentServicesImpl.appointmentServicesImpl;
	}
	
	public void assignVisitas() {
		this.solicitudesRepacion=this.solicitudReparacionAdapter.getSolicitudesNoAsignadas();
		System.out.println("Inicie AppointmentManagementAgentBehaviour");
		for(SolicitudReparacionDto solicitudReparacionDto : this.solicitudReparacionAdapter.getSolicitudesNoAsignadas()) {
			
			InmuebleODataAdapterImpl.getInstance().completeInmueble(solicitudReparacionDto.getInmuebleDto());
			System.out.println(solicitudReparacionDto.getState());
			AppointmentODataAdapterImpl.getInstance().createSolicitudReparacion(solicitudReparacionDto);
			System.out.println(solicitudReparacionDto.getId());
			System.out.println(solicitudReparacionDto.getDescripcion());
			System.out.println(solicitudReparacionDto.getInmuebleDto().getCodigo_ciudad());
			/*System.out.println(solicitudReparacionDto.getAgenciaDto().getNombreSede());
			System.out.println(solicitudReparacionDto.getArrendatarioDto().getNombre());*/
			System.out.println(solicitudReparacionDto.getState());
		}
		
	}

}
