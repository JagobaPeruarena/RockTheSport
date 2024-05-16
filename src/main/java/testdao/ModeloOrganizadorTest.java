package testdao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import modelo.bean.Organizador;
import modelo.dao.ModeloOrganizador;

class ModeloOrganizadorTest {
	private ModeloOrganizador modeloOrganizador = new ModeloOrganizador();
	private Organizador organizador;
	@Test
	void testGetAll() {
		modeloOrganizador.getAll();
	}

	@Test
	void testSelect() {
		modeloOrganizador.select(3);
	}

	@Test
	void testCrearOrganizador() {
		String nombre = "memuero";
		String email = "doslineasmas@adios.dead";
		int telefono = 66666;
		String dni = "1234D";

		organizador = new Organizador(nombre, email, telefono, dni);
		
		assertTrue(modeloOrganizador.crearOrganizador(organizador));
	}

	@Test
	void testActualizarOrganizador() {
		String nombre = "memuero";
		String email = "doslineasmas@adios.dead";
		int telefono = 66666;
		String dni = "1234D";

		organizador = new Organizador(nombre, email, telefono, dni);
		ArrayList<Organizador> organizadors = modeloOrganizador.getAll();
		int last = organizadors.get(organizadors.size()-1).getId();
		organizador.setId(last);
		
		assertTrue(modeloOrganizador.actualizarOrganizador(organizador));
	}

	@Test
	void testEliminarOrganizador() {
		ArrayList<Organizador> organizadors = modeloOrganizador.getAll();
		int last = organizadors.get(organizadors.size()-1).getId();
		assertTrue(modeloOrganizador.eliminarOrganizador(last));
	}

}
