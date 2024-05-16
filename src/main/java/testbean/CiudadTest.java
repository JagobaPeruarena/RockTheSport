package testbean;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;



import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import modelo.bean.Ciudad;


class CiudadTest {
	
	private Ciudad ciudad = null;
	
	
	
	
	@Test
	void testSetAndGetId() {
		ciudad = new Ciudad();
		ciudad.setId(12);
		assertEquals("error",12,ciudad.getId());
		
	}

	
	@Test
	void testSetAndGetNombre() {
		ciudad = new Ciudad();
		ciudad.setNombre("paris");
		assertEquals("error",ciudad.getNombre(), "paris");
	}

	

	@Test
	void testSetAndGetUbicacionGeografica() {
		ciudad = new Ciudad();
		ciudad.setUbicacionGeografica("espana");
		assertEquals("error",ciudad.getUbicacionGeografica(),"espana");
	}

	
	@Test
	void testSetAndGetPoblacion() {
		ciudad = new Ciudad();
		ciudad.setPoblacion(12345);
		assertEquals("error",ciudad.getPoblacion(),12345);
	}

	@Test
	void testCiudadNoId() {
		
		
		String nombre = "paris";
		String localizacion = "espana";
		int poblacion=1234;
		
		ciudad= new Ciudad(nombre, localizacion, poblacion);
		assertEquals("error",ciudad.getUbicacionGeografica(),"espana" );
		assertEquals("error",ciudad.getNombre(),"paris");
		assertEquals("error",ciudad.getPoblacion(), 1234);
		
	}

	@Test
	void testCiudadId() {
		
		int id = 1;
		String nombre = "paris";
		String localizacion = "espana";
		int poblacion=1234;
		
		 ciudad= new Ciudad(id,nombre, localizacion, poblacion);
		
		assertEquals("error",ciudad.getUbicacionGeografica(),"espana" );
		assertEquals("error",ciudad.getNombre(),"paris");
		assertEquals("error",ciudad.getPoblacion(), 1234);
		assertEquals("error",ciudad.getId(), 1);
	}

	@Test
	void testCiudad() {
		ciudad = new Ciudad();
		
		Ciudad ciudadn= new Ciudad();
		assertEquals("error",ciudadn,ciudadn);
	}

}
