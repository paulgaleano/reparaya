package com.reparaya.adapters;

import java.util.List;
import java.util.ArrayList;
import com.reparaya.dtos.RequestDto;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RequestODataAdapter {

	private final static String SERVICE_URL = "https://my305237.crm.ondemand.com/sap/c4c/odata/v1/c4codata/ServiceRequestCollection?%24filter=ServiceRequestUserLifeCycleStatusCode+eq+%27YG%27+or+ServiceRequestUserLifeCycleStatusCode+eq+%27YM%27";

	private final static String JSON_FIRST_NODE = "d";
	private final static String JSON_SECOND_NODE = "results";
	private final static String JSON_REQUEST_ID = "ID";
	private final static String JSON_REQUEST_STATUS = "ServiceRequestUserLifeCycleStatusCode";
	
	private static RequestODataAdapter solicitudRepacionAdapterImpl;

	private RequestODataAdapter() {
	}

	public static RequestODataAdapter getInstance() {
		if (RequestODataAdapter.solicitudRepacionAdapterImpl == null) {
			RequestODataAdapter.solicitudRepacionAdapterImpl = new RequestODataAdapter();
		}
		return RequestODataAdapter.solicitudRepacionAdapterImpl;
	}

	public List<RequestDto> getRequests() {
		List<RequestDto> solicitudes=new ArrayList<RequestDto>();
		try {
			JSONObject jSonResponse = OdataHttpRequest.getInstance().get(this.SERVICE_URL);
			if(jSonResponse!=null) {
				JSONArray jsonArray=((JSONObject) jSonResponse.get(RequestODataAdapter.JSON_FIRST_NODE)).getJSONArray(RequestODataAdapter.JSON_SECOND_NODE);
				for(Object o : jsonArray) {
					if(o instanceof JSONObject) {
						solicitudes.add(this.buildRequestDto((JSONObject)o));				
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return solicitudes;
	}

	private RequestDto buildRequestDto(JSONObject jsonObject) {
		//System.out.println(jsonObject.toString());
		Object id=jsonObject.get(RequestODataAdapter.JSON_REQUEST_ID);
		//System.out.println("ID:"+id.toString());
		Object status=jsonObject.get(RequestODataAdapter.JSON_REQUEST_STATUS);
		//System.out.println("STATUS:"+status.toString());
		String requestId=id!=null?id.toString():"";
		String requestStatus=status!=null?status.toString():"";
		return new RequestDto(requestId,requestStatus);
	}
}