package com.reparaya.adapters;

import java.util.List;
import java.util.ArrayList;
import com.reparaya.dtos.InmuebleDto;
import com.reparaya.dtos.SolicitudReparacionDto;

public class SolicitudRepacionODataAdapterImpl implements SolicitudReparacionAdapter {

	
	private final static String SERVICE_URL = "https://my305237.crm.ondemand.com/sap/c4c/odata/v1/c4codata/ServiceRequestCollection?%24filter=ServiceRequestUserLifeCycleStatusCode+eq+%27YG%27+or+ServiceRequestUserLifeCycleStatusCode+eq+%27YM%27";
	
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
		/*CredentialsProvider provider = new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("REPYAADMIN", "ReparaYa");
		provider.setCredentials(AuthScope.ANY, credentials);
		CloseableHttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();

		HttpGet httpGet = new HttpGet("https://my305237.crm.ondemand.com/sap/c4c/odata/v1/c4codata/ServiceRequestCollection?%24filter=ServiceRequestUserLifeCycleStatusCode+eq+%27YG%27+or+ServiceRequestUserLifeCycleStatusCode+eq+%27YM%27");
	
		try {
			HttpResponse response = client.execute(httpGet);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println(result.toString());
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
		} catch (ClientProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedOperationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} */
		
		/*List<SolicitudReparacionDto> solicitudes=new ArrayList<SolicitudReparacionDto>();
		for (OEntity oEntity : this.oDataConsumer.getEntities(SolicitudRepacionODataAdapterImpl.ENTITY).filter(SolicitudRepacionODataAdapterImpl.FIST_FILTER).execute()) {	
				solicitudes.add(this.buildSolicitudReparacionDto(oEntity));
			}
		return solicitudes;*/
		
		try {
			String response = OdataHttpRequest.getInstance().get(this.SERVICE_URL);
			System.out.println(response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
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