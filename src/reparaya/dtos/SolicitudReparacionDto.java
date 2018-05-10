package reparaya.dtos;

public class SolicitudReparacionDto {
	private int id;
	private InmuebleDto inmuebleDto;
	private ArrendatarioDto arrendatarioDto;
	private AgenciaDto agenciaDto;
	private String descripcion;
	
	
	public SolicitudReparacionDto(int id, InmuebleDto inmuebleDto, ArrendatarioDto arrendatarioDto,
			AgenciaDto agenciaDto, String descripcion) {
		super();
		this.id = id;
		this.inmuebleDto = inmuebleDto;
		this.arrendatarioDto = arrendatarioDto;
		this.agenciaDto = agenciaDto;
		this.descripcion = descripcion;
	}
	
	public int getId() {
		return id;
	}
	public InmuebleDto getInmuebleDto() {
		return inmuebleDto;
	}
	public ArrendatarioDto getArrendatarioDto() {
		return arrendatarioDto;
	}
	
	public AgenciaDto getAgenciaDto() {
		return agenciaDto;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
}
