package modelo.bean;

import java.util.Date;

public class Edicion {
	private int id;
	private Date fecha;
	private int cuposDisponibles;
	private EventoDeportivo eventoDeportivo;
	private Ciudad ciudad;
	
	
	public Edicion(int id, Date fecha, int cuposDisponibles, EventoDeportivo eventoDeportivo, Ciudad ciudad) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.cuposDisponibles = cuposDisponibles;
		this.eventoDeportivo = eventoDeportivo;
		this.ciudad = ciudad;
	}
	public Edicion( Date fecha, int cuposDisponibles, EventoDeportivo eventoDeportivo, Ciudad ciudad) {
		super();
		
		this.fecha = fecha;
		this.cuposDisponibles = cuposDisponibles;
		this.eventoDeportivo = eventoDeportivo;
		this.ciudad = ciudad;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public int getCuposDisponibles() {
		return cuposDisponibles;
	}


	public void setCuposDisponibles(int cuposDisponibles) {
		this.cuposDisponibles = cuposDisponibles;
	}


	public EventoDeportivo getEventoDeportivo() {
		return eventoDeportivo;
	}


	public void setEventoDeportivo(EventoDeportivo eventoDeportivo) {
		this.eventoDeportivo = eventoDeportivo;
	}


	public Ciudad getCiudad() {
		return ciudad;
	}


	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}


	public Edicion () {}

}
