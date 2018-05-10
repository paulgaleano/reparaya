package reparaya.dtos;

public class InmuebleDto {
	private int id;
	private String codigo_pais;
	private String pais;
	private String codigo_departamento;
	private String departamento;
	private String codigo_ciudad;
	private String ciudad;
	private String  direccion;
	
	public InmuebleDto(int id, String codigo_pais, String codigo_departamento, String codigo_ciudad, String direccion) {
		this.id = id;
		this.codigo_pais = codigo_pais;
		this.codigo_departamento = codigo_departamento;
		this.codigo_ciudad = codigo_ciudad;
		this.direccion = direccion;
	}
	
	public int getId() {
		return id;
	}
	public String getCodigo_pais() {
		return codigo_pais;
	}
	public String getPais() {
		return pais;
	}
	public String getCodigo_departamento() {
		return codigo_departamento;
	}
	public String getDepartamento() {
		return departamento;
	}
	public String getCodigo_ciudad() {
		return codigo_ciudad;
	}
	public String getCiudad() {
		return ciudad;
	}
	public String getDireccion() {
		return direccion;
	}
}
