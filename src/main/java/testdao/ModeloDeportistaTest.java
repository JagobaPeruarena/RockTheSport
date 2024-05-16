package testdao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import modelo.bean.Ciudad;
import modelo.bean.Deportista;
import modelo.dao.ModeloDeportista;

class ModeloDeportistaTest {
	private ModeloDeportista modeloDeportista = new ModeloDeportista();
	private Deportista deportista = null;
	@Test
	void testGetAll() {
		modeloDeportista.getAll();
	}

	@Test
	void testSelect() {
		modeloDeportista.select(7);
	}

	@Test
	void testSelectDNI() {
		modeloDeportista.selectDNI("87654321B");
	}

	@Test
	void testInsertDeportista() {
		
		String nombre = "jose";
		int edad = 12;
		String genero = "Mujer";
		String email = "aa@a.com";
		int telefono = 12345;
		String dni = "123A";

		deportista = new Deportista( nombre, edad, genero, email, telefono, dni);
		
		assertTrue(modeloDeportista.insertDeportista(deportista));
	}
	@Test
	void testModificarDeportista() {
		String nombre = "jose";
		int edad = 12;
		String genero = "Mujer";
		String email = "aa@a.com";
		int telefono = 12345;
		String dni = "123A";

		deportista = new Deportista( nombre, edad, genero, email, telefono, dni);
		ArrayList<Deportista>deportistas =modeloDeportista.getAll();
		int last =deportistas.get(deportistas.size()-1).getId();
		deportista.setId(last);
		assertTrue(modeloDeportista.modificarDeportista(deportista));
	}

	@Test
	void testEliminarDeportista() {
		ArrayList<Deportista>deportistas =modeloDeportista.getAll();
		int last =deportistas.get(deportistas.size()-1).getId();
		assertTrue(modeloDeportista.eliminarDeportista(last));
	}

	

	@Test
	void testGetMaxIdForDeportista() {
		modeloDeportista.getMaxIdForDeportista();
	}

}
