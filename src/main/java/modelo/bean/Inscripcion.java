package modelo.bean;

import java.util.Date;

public class Inscripcion {
	private int id;
	private int dorsal;
	private Date fechaInscripcion;
	private Deportista deportista;
	private Edicion edicion;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getDorsal() {
		return dorsal;
	}



	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}



	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}



	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}



	public Deportista getDeportista() {
		return deportista;
	}



	public void setDeportista(Deportista deportista) {
		this.deportista = deportista;
	}



	public Edicion getEdicion() {
		return edicion;
	}



	public void setEdicion(Edicion edicion) {
		this.edicion = edicion;
	}
	


	public Inscripcion(int id, int dorsal, Date fechaInscripcion, Deportista deportista, Edicion edicion) {
		super();
		this.id = id;
		this.dorsal = dorsal;
		this.fechaInscripcion = fechaInscripcion;
		this.deportista = deportista;
		this.edicion = edicion;
	}



	public Inscripcion() {}

}
