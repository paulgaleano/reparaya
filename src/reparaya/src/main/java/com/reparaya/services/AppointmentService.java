package com.reparaya.services;

import java.util.List;

import com.reparaya.adapters.AppointmentODataAdapter;
import com.reparaya.adapters.RequestODataAdapter;
import com.reparaya.dtos.AppointmentDto;
import com.reparaya.dtos.RequestDto;

import net.sf.json.JSONObject;

public class AppointmentService {
	private static AppointmentService appointmentServicesImpl;
	private RequestODataAdapter requestODataAdapterImpl;
	private List<RequestDto> requests;
	
	private final static String YG_STATUS="YG";
	private final static String YM_STATUS="YM";
	
	private final static String APPOINTMENT_QUOTATION_TYPE="211";
	private final static String APPOINTMENT_FIX_TYPE="201";
	
	private final static String QUOTATIN_EMPLOYEE_ID="E9875";
	private final static String FIX_EMPLOYEE_ID="E9876";
	
	
	private AppointmentService() {
		this.requestODataAdapterImpl=RequestODataAdapter.getInstance();
	}
	
	public static AppointmentService getInstance() {
		if(AppointmentService.appointmentServicesImpl==null) {
			AppointmentService.appointmentServicesImpl=new AppointmentService();
		}
		return AppointmentService.appointmentServicesImpl;
	}
	
	public void createVisitas() {
		this.requests=this.requestODataAdapterImpl.getRequests();
		AppointmentDto appointmentDto=null;
		for(RequestDto requestDto : this.requests) {
			appointmentDto=this.buildAppointmentDto(requestDto);
			/*System.out.println("EMPLEADO:"+appointmentDto.getIDEmpleadoAsignado());
			System.out.println("SOLICITUD:"+appointmentDto.getIDSolicitud());
			System.out.println("TIPO VISITA:"+appointmentDto.getTipoVisita());*/
			AppointmentODataAdapter.getInstance().createAppointment(appointmentDto);
		}
	}

	private AppointmentDto buildAppointmentDto(RequestDto requestDto) {
		/*System.out.println("ID:"+requestDto.getId());
		System.out.println("STATUS:"+requestDto.getStatus());*/
		String IDEmpleadoAsignado="";
		String TipoVisita="";
		if(requestDto.getStatus().equals(AppointmentService.YG_STATUS)) {
			IDEmpleadoAsignado=AppointmentService.QUOTATIN_EMPLOYEE_ID;
			TipoVisita=AppointmentService.APPOINTMENT_QUOTATION_TYPE;
		}else if(requestDto.getStatus().equals(AppointmentService.YM_STATUS)) {
			IDEmpleadoAsignado=AppointmentService.FIX_EMPLOYEE_ID;
			TipoVisita=AppointmentService.APPOINTMENT_FIX_TYPE;
		}
		
		/*System.out.println("ID EMPLEADO:"+requestDto.getId());
		System.out.println("TIPO VISITA:"+requestDto.getId());*/
		
		return new AppointmentDto(IDEmpleadoAsignado,requestDto.getId(),TipoVisita);
	}	
}