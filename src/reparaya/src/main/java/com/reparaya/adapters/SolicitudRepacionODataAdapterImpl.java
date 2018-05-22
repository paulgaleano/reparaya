package com.reparaya.adapters;

import java.util.List;
import java.util.ArrayList;
import com.reparaya.dtos.InmuebleDto;
import com.reparaya.dtos.SolicitudReparacionDto;
import net.sf.json.JSONObject;

public class SolicitudRepacionODataAdapterImpl implements SolicitudReparacionAdapter {

	private final static String SERVICE_URL = "https://my305237.crm.ondemand.com/sap/c4c/odata/v1/c4codata/ServiceRequestCollection?%24filter=ServiceRequestUserLifeCycleStatusCode+eq+%27YG%27+or+ServiceRequestUserLifeCycleStatusCode+eq+%27YM%27";

	private final static String JSON_FIRST_NODE = "d";
	private final static String JSON_SECOND_NODE = "results";
	private final static String JSON_SOLICITUD_ID = "id";

	private static SolicitudRepacionODataAdapterImpl solicitudRepacionAdapterImpl;

	private SolicitudRepacionODataAdapterImpl() {
	}

	public static SolicitudRepacionODataAdapterImpl getInstance() {
		if (SolicitudRepacionODataAdapterImpl.solicitudRepacionAdapterImpl == null) {
			SolicitudRepacionODataAdapterImpl.solicitudRepacionAdapterImpl = new SolicitudRepacionODataAdapterImpl();
		}
		return SolicitudRepacionODataAdapterImpl.solicitudRepacionAdapterImpl;
	}

	public List<SolicitudReparacionDto> getSolicitudes() {
		try {
			JSONObject jSonResponse = OdataHttpRequest.getInstance().get(this.SERVICE_URL);
			if(jSonResponse!=null) {
				for (Object o : ((JSONObject) jSonResponse.get(SolicitudRepacionODataAdapterImpl.JSON_FIRST_NODE)).getJSONArray(SolicitudRepacionODataAdapterImpl.JSON_SECOND_NODE)) {
					if (o instanceof JSONObject) {
						System.out.println(((JSONObject) o).get(SolicitudRepacionODataAdapterImpl.JSON_SOLICITUD_ID).toString());					
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ArrayList<SolicitudReparacionDto>();
	}

	private SolicitudReparacionDto buildSolicitudReparacionDto(/* OEntity oEntity */) {
		/*
		 * String idSolicitud=oEntity.getProperty(SolicitudRepacionODataAdapterImpl.
		 * OBJECT_ID_PROPERTY).getValue().toString(); String
		 * descripcionSolicitud=((ArrayList<OProperty>)(oEntity.getProperty(
		 * SolicitudRepacionODataAdapterImpl.NAME_PROPERTY).getValue())).get(1).getValue
		 * ().toString(); return new SolicitudReparacionDto(idSolicitud,
		 * descripcionSolicitud, this.buildInmuebleDto(10));
		 */
		return new SolicitudReparacionDto("", "", null);
	}

	private InmuebleDto buildInmuebleDto(int id) {
		return new InmuebleDto(id, "", "", "", "", null, null);
	}
}