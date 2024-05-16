package testdao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import modelo.bean.Ciudad;
import modelo.dao.ModeloCiudad;
import servlet.ciudad;

class ModeloCiudadTest {
	private Ciudad ciudad;
	private ModeloCiudad modeloCiudad = new ModeloCiudad();
	@Test
	void testGetCiudades() {
		modeloCiudad.getCiudades();
	}

	@Test
	void testSelect() {
		
		assertNotNull(modeloCiudad.select(2));
	}

	@Test
	void testInsertCiudad() {
		String nombre = "paris";
		String localizacion = "espana";
		int poblacion=12324;
		
		ciudad= new Ciudad(nombre, localizacion, poblacion);
		
		
		assertTrue(modeloCiudad.insertCiudad(ciudad));
	}

	

	@Test
	void testEditarCiudad() {
		String nombre = "paris";
		String localizacion = "espana";
		int poblacion=13342;
		
		ciudad= new Ciudad(nombre, localizacion, poblacion);
		ArrayList<Ciudad>ciudads =modeloCiudad.getCiudades();
		int last =ciudads.get(ciudads.size()-1).getId();
		ciudad.setId(last);
		assertTrue(modeloCiudad.editarCiudad(ciudad));
	}
	@Test
	void testEliminarCiudad() {
		ArrayList<Ciudad>ciudads =modeloCiudad.getCiudades();
		int last =ciudads.get(ciudads.size()-1).getId();
		assertTrue(modeloCiudad.eliminarCiudad(last));
	}

}
