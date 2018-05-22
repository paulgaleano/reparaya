package com.reparaya.adapters;

import java.util.ArrayList;
import java.util.List;

/*import org.odata4j.consumer.ODataConsumer;
import org.odata4j.consumer.ODataConsumers;
import org.odata4j.consumer.behaviors.OClientBehaviors;
import org.odata4j.core.OEntity;
import org.odata4j.core.OProperty;*/

import com.reparaya.dtos.AgenciaDto;
import com.reparaya.dtos.ArrendatarioDto;
import com.reparaya.dtos.InmuebleDto;
import com.reparaya.dtos.SolicitudReparacionDto;

public class SolicitudRepacionODataAdapterImpl implements SolicitudReparacionAdapter {

	private final static String FIST_FILTER="?$filter=ServiceRequestUserLifeCycleStatusCode eq 'YG' or ServiceRequestUserLifeCycleStatusCode eq 'YM'";
	private final static String SERVICE_URL = "https://my305237.crm.ondemand.com/sap/c4c/odata/v1/c4codata/ServiceRequestCollection";
	
	private final static String OBJECT_ID_PROPERTY="ObjectID";
	private final static String NAME_PROPERTY="Name";
	
	private static SolicitudRepacionODataAdapterImpl solicitudRepacionAdapterImpl;
	
	private SolicitudRepacionODataAdapterImpl(){	
	}
	
	public static SolicitudRepacionODataAdapterImpl getInstance(){
		if(SolicitudRepacionODataAdapterImpl.solicitudRepacionAdapterImpl==null){
			SolicitudRepacionODataAdapterImpl.solicitudRepacionAdapterImpl=new SolicitudRepacionODataAdapterImpl();
		}
		return SolicitudRepacionODataAdapterImpl.solicitudRepacionAdapterImpl;
	}
	
	public List<SolicitudReparacionDto> getSolicitudesNoAsignadas() {
		try {
			String response=OdataHttpRequest.getInstance().get("https://my305237.crm.ondemand.com/sap/c4c/odata/v1/c4codata/ServiceRequestCollection?%24filter=ServiceRequestUserLifeCycleStatusCode+eq+%27YG%27+or+ServiceRequestUserLifeCycleStatusCode+eq+%27YM%27");
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		/*List<SolicitudReparacionDto> solicitudes=new ArrayList<SolicitudReparacionDto>();
		for (OEntity oEntity : this.oDataConsumer.getEntities(SolicitudRepacionODataAdapterImpl.ENTITY).filter(SolicitudRepacionODataAdapterImpl.FIST_FILTER).execute()) {	
				solicitudes.add(this.buildSolicitudReparacionDto(oEntity));
			}
		return solicitudes;*/
		return new ArrayList<SolicitudReparacionDto>();
	}
	
	private SolicitudReparacionDto buildSolicitudReparacionDto(/*OEntity oEntity*/) {
		/*String idSolicitud=oEntity.getProperty(SolicitudRepacionODataAdapterImpl.OBJECT_ID_PROPERTY).getValue().toString();
		String descripcionSolicitud=((ArrayList<OProperty>)(oEntity.getProperty(SolicitudRepacionODataAdapterImpl.NAME_PROPERTY).getValue())).get(1).getValue().toString();
		return new SolicitudReparacionDto(idSolicitud, descripcionSolicitud, this.buildInmuebleDto(10));*/
		return new SolicitudReparacionDto("", "", null);
	}
	
	private InmuebleDto buildInmuebleDto(int id) {
		return new InmuebleDto(id, "", "", "", "", null, null);
	}
}