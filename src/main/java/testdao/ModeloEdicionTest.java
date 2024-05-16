package testdao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import modelo.bean.Ciudad;
import modelo.bean.Edicion;
import modelo.bean.EventoDeportivo;
import modelo.dao.ModeloEdicion;

class ModeloEdicionTest {
	private ModeloEdicion modeloEdicion	= new ModeloEdicion();
	private Edicion edicion = null;
	@Test
	void testGetEdicions() {
		modeloEdicion.getEdicions();
	}

	@Test
	void testGetEdicionsCiudad() {
		modeloEdicion.getEdicionsCiudad(2);
	}

	@Test
	void testSelect() {
		modeloEdicion.select(14);
	}

	@Test
	void testCrearEdicion() {
	
		Date date = new java.util.Date();
		int cuposDisponibles = 1222;
		EventoDeportivo eventoDeportivo = new EventoDeportivo();
		eventoDeportivo.setId(11);
		Ciudad ciudad = new Ciudad();
		ciudad.setId(2);

		edicion = new Edicion( date, cuposDisponibles, eventoDeportivo, ciudad);
		
		assertTrue(modeloEdicion.crearEdicion(edicion));
	}

	@Test
	void testActualizarEdicion() {
	
		Date date = new java.util.Date();
		int cuposDisponibles = 1222;
		EventoDeportivo eventoDeportivo = new EventoDeportivo();
		eventoDeportivo.setId(11);
		Ciudad ciudad = new Ciudad();
		ciudad.setId(3);

		edicion = new Edicion( date, cuposDisponibles, eventoDeportivo, ciudad);
		ArrayList<Edicion> edicions = modeloEdicion.getEdicions();
		int last = edicions.get(edicions.size()-1).getId();
		edicion.setId(last);
		assertTrue(modeloEdicion.actualizarEdicion(edicion));

	}

	@Test
	void testEliminarEdicion() {
		ArrayList<Edicion> edicions = modeloEdicion.getEdicions();
		int last = edicions.get(edicions.size()-1).getId();
		assertTrue(modeloEdicion.eliminarEdicion(last));
	}

	@Test
	void testSelectByEventoDeportivoId() {
		modeloEdicion.selectByEventoDeportivoId(11);
	}

}
