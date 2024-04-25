package modelo.bean;

public enum Genero {
	
	Man("Hombre"),
	Woman("Mujer"),
	Binari("No-Binario"),
	Apache("Apache 130DX")
	;
	
	private String nombre;
	Genero(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return this.nombre;
	}

}
