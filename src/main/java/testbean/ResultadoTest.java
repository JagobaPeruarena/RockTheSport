package testbean;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.bean.Inscripcion;
import modelo.bean.Organizador;
import modelo.bean.Resultado;

class ResultadoTest {
	private Resultado resultado = null;
	
	@Test
	void testSetAndGetId() {
		resultado = new Resultado();
		resultado.setId(12);
		assertEquals("error", 12, resultado.getId());

	}
	@Test
	void testSetAndGetTiempo() {
		resultado = new Resultado();
		resultado.setTiempo("12:00");
		assertEquals("error", "12:00", resultado.getTiempo());

	}
	@Test
	void testSetAndGetClasificacion() {
		resultado = new Resultado();
		resultado.setClasificacion(12);
		assertEquals("error", 12, resultado.getClasificacion());

	}
	@Test
	void testSetAndGetInscripcion() {
		resultado = new Resultado();
		Inscripcion inscripcion = new Inscripcion();
		resultado.setInscripcion(inscripcion);
		assertEquals("error", inscripcion, resultado.getInscripcion());

	}
	

	@Test
	void testResultadoIntStringIntInscripcion() {
		int id = 12;
		String tiempo = "12:00";
		int clasificacion = 12;
		Inscripcion inscripcion = new Inscripcion();
		
		resultado = new Resultado(id, tiempo, clasificacion, inscripcion);
		
		assertEquals("error", 12, resultado.getId());
		assertEquals("error", "12:00", resultado.getTiempo());
		assertEquals("error", 12, resultado.getClasificacion());
		assertEquals("error", inscripcion, resultado.getInscripcion());
	}

	@Test
	void testResultadoStringIntInscripcion() {
		
		String tiempo = "12:00";
		int clasificacion = 12;
		Inscripcion inscripcion = new Inscripcion();
		
		resultado = new Resultado( tiempo, clasificacion, inscripcion);
	
		assertEquals("error", "12:00", resultado.getTiempo());
		assertEquals("error", 12, resultado.getClasificacion());
		assertEquals("error", inscripcion, resultado.getInscripcion());
	}

	@Test
	void testResultado() {
		resultado = new Resultado();
		
		Resultado resultadod= new Resultado();
		assertEquals("error",resultadod, resultadod);
	}

}
