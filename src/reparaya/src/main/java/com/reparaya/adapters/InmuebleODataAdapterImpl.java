package com.reparaya.adapters;

import com.reparaya.dtos.AgenciaDto;
import com.reparaya.dtos.ArrendatarioDto;
import com.reparaya.dtos.InmuebleDto;


public class InmuebleODataAdapterImpl implements InmuebleAdapter {
	
	private final static String PASSWORD="ReparaYa";
	private final static String USERNAME="REPYAADMIN";
	private final static String ENTITY="";
	private final static String FIST_FILTER="ProcessingTypeCode eq 'ZSRI'";
	private final static String SERVICE_URL = "https://my305237.crm.ondemand.com/sap/c4c/odata/v1/c4codata/";
	private static InmuebleODataAdapterImpl inmuebleODataAdapterImpl;
	
	private InmuebleODataAdapterImpl() {
		
	}
	
	public static InmuebleODataAdapterImpl getInstance(){
		if(InmuebleODataAdapterImpl.inmuebleODataAdapterImpl==null){
			InmuebleODataAdapterImpl.inmuebleODataAdapterImpl=new InmuebleODataAdapterImpl();
		}
		return InmuebleODataAdapterImpl.inmuebleODataAdapterImpl;
	}
	
	
	public void completeInmueble(InmuebleDto inmuebleDto) {
		this.completeInmuebleDto(inmuebleDto);
	}

	private void completeInmuebleDto(InmuebleDto InmuebleDto) {
		InmuebleDto.setCodigo_pais("CO");
		InmuebleDto.setPais("Colombia");
		InmuebleDto.setCodigo_departamento("ANT");
		InmuebleDto.setDepartamento("Antioquia");
		InmuebleDto.setCodigo_ciudad("0501000");
		InmuebleDto.setCiudad("Medellin");
		InmuebleDto.setDireccion("Calle 30 #45-12");
		InmuebleDto.setAgenciaDto(this.buildAgenciaDto());
		InmuebleDto.setArrendatarioDto(this.buildArrendatarioDto());
	}
	
	private ArrendatarioDto buildArrendatarioDto() {
		int id=20;
		String nombre="Juan Mauricio Mariño Agudelo"; 
		String celular="3058795493";
		return new ArrendatarioDto(id,nombre,celular);
	}
	
	private AgenciaDto buildAgenciaDto() {
		int id=30;
		String nombreSede="Eafit"; 
		String direccion="Calle 22 #57-34"; 
		String telefono="4594832";
		return new AgenciaDto(id,nombreSede,direccion,telefono);
	}
}
