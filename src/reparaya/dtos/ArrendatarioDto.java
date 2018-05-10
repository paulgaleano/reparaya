package reparaya.dtos;

public class ArrendatarioDto {
	private int id;
	private String nombre;
	private String celular;
	
	public ArrendatarioDto(int id, String nombre, String celular) {
		this.id = id;
		this.nombre = nombre;
		this.celular = celular;
	}
	
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getCelular() {
		return celular;
	}
}
