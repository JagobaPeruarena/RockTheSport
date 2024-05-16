package testbean;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.bean.Ciudad;
import modelo.bean.Deportes;

class DeportesTest {
	private Deportes deportes;

	@Test
	void testSetAndGetId() {
		deportes = new Deportes();
		deportes.setId(12);
		assertEquals("error",12,deportes.getId());
		
	}


	@Test
	void testSetAndGetNombre() {
		deportes = new Deportes();
		deportes.setNombre("aa");
		assertEquals("error","aa",deportes.getNombre());
		
	}
	@Test
	void testDeportesIntString() {
		
		int id = 1;
		String nombre = "name";
		
		deportes = new Deportes(id, nombre);
		
		assertEquals("error",deportes.getId(),1 );
		assertEquals("error",deportes.getNombre(),"name");
	}

	@Test
	void testDeportes() {
		deportes = new Deportes();
		Deportes deportesn = new Deportes();
		assertEquals("error",deportesn, deportesn);
	}

}
