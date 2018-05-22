package com.reparaya.adapters;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

public class OdataHttpRequest {
	private static OdataHttpRequest httpRequest;
	private final static String HEADER_X_CSRF_TOKEN = "X-CSRF-Token";
	private final static String PASSWORD="ReparaYa";
	private final static String USERNAME="REPYAADMIN";
	private final static String CONTENT_TYPE_HEADER="Content-Type";
	private final static String ACCEPT="Accept";
	private final static String APPLICATION_JSON_VALUE="application/json";
	
	private CredentialsProvider provider;
	private UsernamePasswordCredentials credentials;
	private CloseableHttpClient client;
	
	private OdataHttpRequest() {	
		this.provider = new BasicCredentialsProvider();
		this.credentials = new UsernamePasswordCredentials(OdataHttpRequest.USERNAME, OdataHttpRequest.PASSWORD);
		this.provider.setCredentials(AuthScope.ANY, this.credentials);
		this.client = HttpClientBuilder.create().setDefaultCredentialsProvider(this.provider).build();
	}
	
	public static OdataHttpRequest getInstance() {
		if(OdataHttpRequest.httpRequest==null){
			OdataHttpRequest.httpRequest=new OdataHttpRequest();
		}
		return OdataHttpRequest.httpRequest;
	}
	
	
	public String post(String urlService, String payLoad) throws Exception {
		HttpPost httpPost = new HttpPost(urlService);
		httpPost.setHeader(OdataHttpRequest.HEADER_X_CSRF_TOKEN, this.getToken(urlService));
		
		httpPost.setHeader(OdataHttpRequest.CONTENT_TYPE_HEADER, OdataHttpRequest.APPLICATION_JSON_VALUE);
		httpPost.setHeader(OdataHttpRequest.ACCEPT, OdataHttpRequest.APPLICATION_JSON_VALUE);
		StringEntity postRequest=new StringEntity(payLoad);
		
		postRequest.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, OdataHttpRequest.APPLICATION_JSON_VALUE));
		System.out.println("Solicitud: " + EntityUtils.toString(postRequest));
		httpPost.setEntity(postRequest);
		HttpResponse response = client.execute(httpPost);
		
		
		
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		System.out.println("Respuesta: " + EntityUtils.toString(response.getEntity()));
		
		return EntityUtils.toString(response.getEntity());
	}
	
	public JSONObject get(String urlService) throws Exception {
		JSONObject jsonObject = null;
		HttpGet httpGet = new HttpGet(urlService);
		httpGet.addHeader(OdataHttpRequest.ACCEPT,OdataHttpRequest.APPLICATION_JSON_VALUE);
		HttpResponse response = this.client.execute(httpGet);
		HttpEntity entity=response.getEntity();
		
		if (entity != null) {
            String result=EntityUtils.toString(entity,"UTF-8");
            jsonObject=JSONObject.fromObject(result);
        }
        httpGet.releaseConnection();
		return jsonObject;
	}
	
	
	private String convertStreamToString(InputStream is) {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	    StringBuilder sb = new StringBuilder();

	    String line = null;
	    try {
	        while ((line = reader.readLine()) != null) {
	            sb.append(line + "\n");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            is.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return sb.toString();
	}
	
	private String getToken(String urlService) throws Exception {
		this.provider = new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(OdataHttpRequest.USERNAME, OdataHttpRequest.USERNAME);
		this.provider.setCredentials(AuthScope.ANY, credentials);
		this.client = HttpClientBuilder.create().setDefaultCredentialsProvider(this.provider).build();
		String token = null;
		HttpGet httpGet = new HttpGet(urlService);
		httpGet.addHeader(OdataHttpRequest.HEADER_X_CSRF_TOKEN, "Fetch");
		
		HttpResponse response = this.client.execute(httpGet);
		Header headerToken = response.getFirstHeader(OdataHttpRequest.HEADER_X_CSRF_TOKEN);
		if (headerToken == null) {
			throw new Exception("No se retorno el token para las solicitudes");
		}
		token = headerToken.getValue();
		
		return token;
	}
}