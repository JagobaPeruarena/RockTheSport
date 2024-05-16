package testdao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.dao.ModeloDeportes;

class ModeloDeportesTest {
	private ModeloDeportes modeloDeportes = new ModeloDeportes();
	@Test
	void testGetDeportes() {
		modeloDeportes.getDeportes();
	}

	@Test
	void testSelect() {
		modeloDeportes.select(3);
	}

}
