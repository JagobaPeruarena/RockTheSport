package modelo.bean;

public class Deportista {
	private int id;
	private String nombre;
	private int edad;
	private String genero;
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
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
	public Deportista(int id, String nombre, int edad, String genero, String email, int telefono, String dni) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.genero = genero;
		this.email = email;
		this.telefono = telefono;
		this.dni = dni;
	}
	public Deportista () {}
	
	
}
