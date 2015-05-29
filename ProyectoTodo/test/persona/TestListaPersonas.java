package persona;

import static org.junit.Assert.*;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestListaPersonas {
	
	private static ListaPersonas lp;

	@BeforeClass
	public static void iniciaClase() throws InsertarPersonaException{
		lp = new ListaPersonas();
		Persona p1 = new Persona("AAA", 10);
		Persona p2 = new Persona("BBB", 15);
		Persona p3 = new Persona("CCC", 20);
		lp.insertarPersona(p1);
		lp.insertarPersona(p2);
		lp.insertarPersona(p3);
	}
	
	@Before
	public  void iniciaMetodos() throws InsertarPersonaException{
		lp = new ListaPersonas();
		Persona p1 = new Persona("AAA", 10);
		Persona p2 = new Persona("BBB", 15);
		Persona p3 = new Persona("CCC", 20);
		lp.insertarPersona(p1);
		lp.insertarPersona(p2);
		lp.insertarPersona(p3);
	}
	
	/*@Test
	public void testListaPersonas() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testGetListaPersonas() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testGetCantidadPersonas() throws InsertarPersonaException {
		assertEquals("El numero de PErsonas esperado es 3: ", 3, lp.getCantidadPersonas());
	}

	@Test
	public void testBuscarPersona() throws InsertarPersonaException {
		Persona p = new Persona("CCC", 20);
		lp.insertarPersona(p);
		assertEquals("Buscar Persona por Nombre", lp.getListaPersonas()[2], lp.buscarPersona("CCC"));
	}

	@Test
	public void testBusarPersona() {
		Persona p4 = new Persona("CCC", 20);
		assertTrue(p4.equals(lp.busarPersona(20)));
	}
/*
	@Test
	public void testSerializar() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeserializar() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertarPersona() {
		fail("Not yet implemented");
	}

	@Test
	public void testNumeroPersonas() {
		fail("Not yet implemented");
	}

	@Test
	public void testEstaLlena() {
		fail("Not yet implemented");
	}

	@Test
	public void testMostrar() {
		fail("Not yet implemented");
	}

	@Test
	public void testPosPersona() {
		fail("Not yet implemented");
	}

	@Test
	public void testEliminarPersona() {
		fail("Not yet implemented");
	}

	@Test
	public void testForEach() {
		fail("Not yet implemented");
	}

	@Test
	public void testIterator() {
		fail("Not yet implemented");
	}

	@Test
	public void testSpliterator() {
		fail("Not yet implemented");
	}*/

}
