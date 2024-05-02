package modelo.bean;

public class Resultado {
	private int id;
	private String tiempo;
	private int clasificacion;
	private Inscripcion inscripcion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	public int getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(int clasificacion) {
		this.clasificacion = clasificacion;
	}
	public Inscripcion getInscripcion() {
		return inscripcion;
	}
	public void setInscripcion(Inscripcion inscripcion) {
		this.inscripcion = inscripcion;
	}
	public Resultado(int id, String tiempo, int clasificacion, Inscripcion inscripcion) {
		super();
		this.id = id;
		this.tiempo = tiempo;
		this.clasificacion = clasificacion;
		this.inscripcion = inscripcion;
	}
	public Resultado( String tiempo, int clasificacion, Inscripcion inscripcion) {
		super();
		
		this.tiempo = tiempo;
		this.clasificacion = clasificacion;
		this.inscripcion = inscripcion;
	}
	
	public Resultado() {}
}
