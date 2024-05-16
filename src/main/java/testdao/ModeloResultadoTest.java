package testdao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import modelo.bean.Inscripcion;
import modelo.bean.Resultado;
import modelo.dao.ModeloResultado;
import servlet.resultado;

class ModeloResultadoTest {
	private ModeloResultado modeloResultado = new ModeloResultado();
	private Resultado resultado;
	@Test
	void testGetResultados() {
		modeloResultado.getResultados();
	}

	@Test
	void testSelect() {
		modeloResultado.select(10);
	}

	@Test
	void testCrearResultado() {
		String tiempo = "12:00";
		int clasificacion = 12;
		Inscripcion inscripcion = new Inscripcion();
		inscripcion.setId(42);
		
		resultado = new Resultado( tiempo, clasificacion, inscripcion);
		
		assertTrue(modeloResultado.crearResultado(resultado));
	}

	@Test
	void testActualizarResultado() {
		String tiempo = "12:00";
		int clasificacion = 12;
		Inscripcion inscripcion = new Inscripcion();
		inscripcion.setId(42);
		
		resultado = new Resultado( tiempo, clasificacion, inscripcion);
		ArrayList<Resultado> resultados= modeloResultado.getResultados();
		int last = resultados.get(resultados.size()-1).getId();
		resultado.setId(last);
		assertTrue(modeloResultado.actualizarResultado(resultado));
	}

	@Test
	void testEliminarResultado() {
		ArrayList<Resultado> resultados= modeloResultado.getResultados();
		int last = resultados.get(resultados.size()-1).getId();
		assertTrue(modeloResultado.eliminarResultado(last));
	}

	@Test
	void testSelectByDeportistaId() {
		modeloResultado.selectByDeportistaId(4);
	}

	@Test
	void testSelectByEdicionId() {
		modeloResultado.selectByEdicionId(16);
	}

}
