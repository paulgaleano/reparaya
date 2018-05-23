package com.reparaya.adapters;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reparaya.dtos.ValorCotizacionDto;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class CotizacionOdataAdapter {
	private static CotizacionOdataAdapter cotizacionOdataAdapterImpl;
	private final static String SERVICE_URL_ASIGNAR_COTIZACION = "https://my305237.crm.ondemand.com/sap/c4c/odata/cust/v1/asignarcotizacionreparacion/AsignarCotizacionReparacionRootCollection";
	private final static String SERVICE_URL_SOLICITUDES_X_COTIZAR = "https://my305237.crm.ondemand.com/sap/c4c/odata/v1/c4codata/ServiceRequestCollection?%24filter=ServiceRequestUserLifeCycleStatusCode+eq+%27YI%27";

	private final static String JSON_FIRST_NODE = "d";
	private final static String JSON_SECOND_NODE = "results";
	private final static String JSON_SOLICITUD_ID = "ID";

	private CotizacionOdataAdapter() {
	}

	public static CotizacionOdataAdapter getInstance() {
		if (CotizacionOdataAdapter.cotizacionOdataAdapterImpl == null) {
			CotizacionOdataAdapter.cotizacionOdataAdapterImpl = new CotizacionOdataAdapter();
		}
		return CotizacionOdataAdapter.cotizacionOdataAdapterImpl;
	}

	public JSONObject asignarValorCotizacion(ValorCotizacionDto valorCotizacionDto) {
		ObjectMapper objectMapper = new ObjectMapper();
		String jSonRequest = null;
		try {
			jSonRequest = objectMapper.writeValueAsString(valorCotizacionDto);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		JSONObject jSonResponse = null;
		try {
			jSonResponse = OdataHttpRequest.getInstance()
					.post(CotizacionOdataAdapter.SERVICE_URL_ASIGNAR_COTIZACION, jSonRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jSonResponse;
	}

	public List<ValorCotizacionDto> getSolicitudesACotizar() {
		List<ValorCotizacionDto> cotizaciones = new ArrayList<ValorCotizacionDto>();
		ValorCotizacionDto valorCotizacionDto = null;
		try {

			JSONObject jSonResponse = OdataHttpRequest.getInstance()
					.get(CotizacionOdataAdapter.SERVICE_URL_SOLICITUDES_X_COTIZAR);
			JSONObject nodeD = (JSONObject) jSonResponse.get(CotizacionOdataAdapter.JSON_FIRST_NODE);
			JSONArray nodeResponses = (JSONArray) nodeD.get(CotizacionOdataAdapter.JSON_SECOND_NODE);
			@SuppressWarnings("unchecked")
			Iterator<JSONObject> solicitudes = (Iterator<JSONObject>) nodeResponses.iterator();
			while (solicitudes.hasNext()) {
				JSONObject solicitud = (JSONObject) solicitudes.next();
				valorCotizacionDto = new ValorCotizacionDto();
				valorCotizacionDto.IDSolicitud = solicitud.getString(CotizacionOdataAdapter.JSON_SOLICITUD_ID);
				cotizaciones.add(valorCotizacionDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cotizaciones;
	}

}
