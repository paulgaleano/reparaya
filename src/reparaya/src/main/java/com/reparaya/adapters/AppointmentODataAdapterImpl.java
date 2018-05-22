package com.reparaya.adapters;

import java.util.Map;
import com.reparaya.dtos.SolicitudReparacionDto;


public class AppointmentODataAdapterImpl implements AppointmentAdapter {
	
	private final static String ENTITY="";
	private final static String PASSWORD="ReparaYa";
	private final static String USERNAME="REPYAADMIN";
	private final static String FIST_FILTER="ProcessingTypeCode eq 'ZSRI'";
	private final static String SERVICE_URL = "https://my305237.crm.ondemand.com/sap/c4c/odata/cust/v1/creacionvisita/";
	
	private Map<String, String> headers;
	private static AppointmentODataAdapterImpl appointmentODataAdapterImpl;
		
	private AppointmentODataAdapterImpl() {	
	}
	
	public static AppointmentODataAdapterImpl getInstance() {
		if(AppointmentODataAdapterImpl.appointmentODataAdapterImpl==null){
			AppointmentODataAdapterImpl.appointmentODataAdapterImpl=new AppointmentODataAdapterImpl();
		}
		return AppointmentODataAdapterImpl.appointmentODataAdapterImpl;
	}
	
	public void createSolicitudReparacion(SolicitudReparacionDto solicitudReparacionDto) {
		solicitudReparacionDto.setState(1);
	}
}
