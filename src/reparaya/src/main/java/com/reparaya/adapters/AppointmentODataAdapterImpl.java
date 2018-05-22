package com.reparaya.adapters;

import java.util.Map;
import com.reparaya.dtos.SolicitudReparacionDto;

import net.sf.json.JSONObject;


public class AppointmentODataAdapterImpl implements AppointmentAdapter {
	private final static String SERVICE_URL = "https://my305237.crm.ondemand.com/sap/c4c/odata/cust/v1/creacionvisita/CreacionVisitaRootCollection";
	
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
		String payLoad="{\"IDEmpleadoAsignado\":\"E9875\",\"IDSolicitud\":\"1206203246 \",\"TipoVisita\":\"221\"}";
		try {
			JSONObject jsonObject=OdataHttpRequest.getInstance().post(AppointmentODataAdapterImpl.SERVICE_URL, payLoad);
			System.out.println(jsonObject.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		//solicitudReparacionDto.setState(1);
	}
}
