package testbean;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.bean.Ciudad;
import modelo.bean.Deportes;
import modelo.bean.Deportista;

class DeportistaTest {
	private Deportista deportista;

	@Test
	void testSetAndGetId() {
		deportista = new Deportista();
		deportista.setId(12);
		assertEquals("error", 12, deportista.getId());

	}

	@Test
	void testSetAndGetNombre() {
		deportista = new Deportista();
		deportista.setNombre("jose");
		assertEquals("error", "jose", deportista.getNombre());

	}

	@Test
	void testSetAndGetEdad() {
		deportista = new Deportista();
		deportista.setEdad(12);
		assertEquals("error", 12, deportista.getEdad());

	}

	@Test
	void testSetAndGetGenero() {
		deportista = new Deportista();
		deportista.setGenero("Mujer");
		assertEquals("error", "Mujer", deportista.getGenero());

	}

	@Test
	void testSetAndGetEmail() {
		deportista = new Deportista();
		deportista.setEmail("aa@a.com");
		assertEquals("error", "aa@a.com", deportista.getEmail());

	}

	@Test
	void testSetAndGetTelefono() {
		deportista = new Deportista();
		deportista.setTelefono(12345);
		assertEquals("error", 12345, deportista.getTelefono());

	}

	@Test
	void testSetAndGetDni() {
		deportista = new Deportista();
		deportista.setDni("123A");
		assertEquals("error", "123A", deportista.getDni());

	}

	@Test
	void testDeportistaID() {
		int id = 12;
		String nombre = "jose";
		int edad = 12;
		String genero = "Mujer";
		String email = "aa@a.com";
		int telefono = 12345;
		String dni = "123A";

		deportista = new Deportista(id, nombre, edad, genero, email, telefono, dni);
		assertEquals("error", "123A", deportista.getDni());
		assertEquals("error", 12345, deportista.getTelefono());
		assertEquals("error", "aa@a.com", deportista.getEmail());
		assertEquals("error", "Mujer", deportista.getGenero());
		assertEquals("error", 12, deportista.getEdad());
		assertEquals("error", "jose", deportista.getNombre());
		assertEquals("error", 12, deportista.getId());
	}

	@Test
	void testDeportista() {
		deportista = new Deportista();

		Deportista deportistas = new Deportista();
		assertEquals("error", deportistas, deportistas);
	}

	@Test
	void testDeportistaNoId() {

		String nombre = "jose";
		int edad = 12;
		String genero = "Mujer";
		String email = "aa@a.com";
		int telefono = 12345;
		String dni = "123A";

		deportista = new Deportista(nombre, edad, genero, email, telefono, dni);
		assertEquals("error", "123A", deportista.getDni());
		assertEquals("error", 12345, deportista.getTelefono());
		assertEquals("error", "aa@a.com", deportista.getEmail());
		assertEquals("error", "Mujer", deportista.getGenero());
		assertEquals("error", 12, deportista.getEdad());
		assertEquals("error", "jose", deportista.getNombre());

	}

}
