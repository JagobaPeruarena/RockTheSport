package modelo.bean;


public class Organizador {
	private int id;
	private String nombre;
	private String email;
	private int telefono;
	private String dni;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Organizador(int id, String nombre, String email, int telefono, String dni) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.dni = dni;
	}
	
	
	public Organizador() {}
}
