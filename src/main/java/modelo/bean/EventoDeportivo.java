package modelo.bean;

public class EventoDeportivo {
	private int id;
	private String nombre;
	private String descripcion;
	private String tipoDeporte;
	private Organizador organizador;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipoDeporte() {
		return tipoDeporte;
	}
	public void setTipoDeporte(String tipoDeporte) {
		this.tipoDeporte = tipoDeporte;
	}
	public Organizador getOrganizador() {
		return organizador;
	}
	public void setOrganizador(Organizador organizador) {
		this.organizador = organizador;
	}
	public EventoDeportivo(int id, String nombre, String descripcion, String tipoDeporte, Organizador organizador) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipoDeporte = tipoDeporte;
		this.organizador = organizador;
	}
	public EventoDeportivo( String nombre, String descripcion, String tipoDeporte, Organizador organizador) {
		super();
	
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipoDeporte = tipoDeporte;
		this.organizador = organizador;
	}
	public EventoDeportivo() {}
}
