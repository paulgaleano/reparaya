package com.reparaya.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reparaya.dtos.EstadoSolicitudDto;

import net.sf.json.JSONObject;

public class EstadoSolicitudOdataAdapter {
	private static EstadoSolicitudOdataAdapter estadoSolicitudOdataAdapterImpl;
	private final static String SERVICE_URL = "https://my305237.crm.ondemand.com/sap/c4c/odata/cust/v1/cambiarestadosolicitud/CambiarEstadoSolicitudRootCollection";

	private EstadoSolicitudOdataAdapter() {
	}

	public static EstadoSolicitudOdataAdapter getInstance() {
		if (EstadoSolicitudOdataAdapter.estadoSolicitudOdataAdapterImpl == null) {
			EstadoSolicitudOdataAdapter.estadoSolicitudOdataAdapterImpl = new EstadoSolicitudOdataAdapter();
		}
		return EstadoSolicitudOdataAdapter.estadoSolicitudOdataAdapterImpl;
	}

	public JSONObject actualizarEstadoSolicitud(EstadoSolicitudDto estadoSolicitud) {
		ObjectMapper objectMapper = new ObjectMapper();
		String jSonRequest = null;
		try {
			jSonRequest = objectMapper.writeValueAsString(estadoSolicitud);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		JSONObject jSonResponse = null;
		try {
			jSonResponse = OdataHttpRequest.getInstance().post(EstadoSolicitudOdataAdapter.SERVICE_URL,
					jSonRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jSonResponse;
	}

}
