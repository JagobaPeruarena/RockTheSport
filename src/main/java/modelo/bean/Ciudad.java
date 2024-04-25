package modelo.bean;

public class Ciudad {
	private int id;
	private String nombre;
	private String ubicacionGeografica;
	private int poblacion;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUbicacionGeografica() {
		return ubicacionGeografica;
	}
	public void setUbicacionGeografica(String ubicacionGeografica) {
		this.ubicacionGeografica = ubicacionGeografica;
	}
	public int getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}
	public Ciudad(int id, String nombre, String ubicacionGeografica, int poblacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ubicacionGeografica = ubicacionGeografica;
		this.poblacion = poblacion;
	}
	
	public Ciudad( String nombre, String ubicacionGeografica, int poblacion) {
	
		this.nombre = nombre;
		this.ubicacionGeografica = ubicacionGeografica;
		this.poblacion = poblacion;
	}
	public Ciudad() {}
	
}
