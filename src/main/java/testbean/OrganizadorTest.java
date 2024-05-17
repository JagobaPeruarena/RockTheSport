package testbean;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.bean.Inscripcion;
import modelo.bean.Organizador;

class OrganizadorTest {
	private Organizador organizador = null;

	@Test
	void testSetAndGetId() {
		organizador = new Organizador();
		organizador.setId(12);
		assertEquals("error", 12, organizador.getId());

	}

	@Test
	void testSetAndGetNombre() {
		organizador = new Organizador();
		organizador.setNombre("memuero");
		assertEquals("error", "memuero", organizador.getNombre());

	}

	@Test
	void testSetAndGetEmail() {
		organizador = new Organizador();
		organizador.setEmail("doslineasmas@adios.dead");
		assertEquals("error", "doslineasmas@adios.dead", organizador.getEmail());

	}

	@Test
	void testSetAndGetTelefono() {
		organizador = new Organizador();
		organizador.setTelefono(66666);
		assertEquals("error", 66666, organizador.getTelefono());

	}

	@Test
	void testSetAndGetDni() {
		organizador = new Organizador();
		organizador.setDni("1234D");
		assertEquals("error", "1234D", organizador.getDni());

	}

	@Test
	void testOrganizadorId() {
		int id = 12;
		String nombre = "memuero";
		String email = "doslineasmas@adios.dead";
		int telefono = 66666;
		String dni = "1234D";

		organizador = new Organizador(id, nombre, email, telefono, dni);

		assertEquals("error", 12, organizador.getId());
		assertEquals("error", "memuero", organizador.getNombre());
		assertEquals("error", "doslineasmas@adios.dead", organizador.getEmail());
		assertEquals("error", 66666, organizador.getTelefono());
		assertEquals("error", "1234D", organizador.getDni());
	}

	@Test
	void testOrganizadorNoId() {

		String nombre = "memuero";
		String email = "doslineasmas@adios.dead";
		int telefono = 66666;
		String dni = "1234D";

		organizador = new Organizador(nombre, email, telefono, dni);

		assertEquals("error", "memuero", organizador.getNombre());
		assertEquals("error", "doslineasmas@adios.dead", organizador.getEmail());
		assertEquals("error", 66666, organizador.getTelefono());
		assertEquals("error", "1234D", organizador.getDni());
	}

	@Test
	void testOrganizador() {
		organizador = new Organizador();
		Organizador organizadorn = new Organizador();
		assertEquals("error",organizadorn, organizadorn);
	}

}
