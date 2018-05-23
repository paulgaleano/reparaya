package com.reparaya.adapters;

import com.reparaya.dtos.AppointmentDto;
import com.reparaya.dtos.RequestDto;

import net.sf.json.JSONObject;


public class AppointmentODataAdapter {
	private final static String SERVICE_URL = "https://my305237.crm.ondemand.com/sap/c4c/odata/cust/v1/creacionvisita/CreacionVisitaRootCollection";
	
	private static AppointmentODataAdapter appointmentODataAdapterImpl;
		
	private AppointmentODataAdapter() {	
	}
	
	public static AppointmentODataAdapter getInstance() {
		if(AppointmentODataAdapter.appointmentODataAdapterImpl==null){
			AppointmentODataAdapter.appointmentODataAdapterImpl=new AppointmentODataAdapter();
		}
		return AppointmentODataAdapter.appointmentODataAdapterImpl;
	}
	
	public void createAppointment(AppointmentDto appointmentDto) {
		//String payLoad="{\"IDEmpleadoAsignado\":\"E9875\",\"IDSolicitud\":\"1206203246 \",\"TipoVisita\":\"221\"}";
		try {
			String payload=appointmentDto.toJson();
			//System.out.println("AppointmentDto To Json"+payload);
			JSONObject jsonObject=OdataHttpRequest.getInstance().post(AppointmentODataAdapter.SERVICE_URL, payload);
			//System.out.println(jsonObject.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
