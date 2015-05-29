package persona;

import static org.junit.Assert.*;

import jUnit.Operaciones;

import org.hamcrest.core.IsNot;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPersona {
	private static Persona persona;

	@BeforeClass
	public static void iniciaClase(){
		persona = new Persona("AAA", 10);
	}
	
	@Before
	public void iniciaMetodo(){
		persona = new Persona("AAA", 10);
	}
	
	@Test
	public void testPersona() {
		assertNotNull(persona);
	}

	@Test
	public void testGetEdad() {		
		assertEquals("La edad debe ser 10: ", 10, persona.getEdad());
	}

	@Test
	public void testSetEdad() {
		int nuevaEdad = 20;
		persona.setEdad(nuevaEdad);
		assertEquals("Insertamos la nueva edad 20: ", nuevaEdad, persona.getEdad());
	}

	@Test
	public void testGetNombre() {
		assertEquals("El nombre debe ser \"AAA\": " , "AAA", persona.getNombre());
	}

	@Test
	public void testSetNombre() {
		String nuevoNombre = "BBB";
		persona.setNombre(nuevoNombre);
		assertEquals("Insertamos el nombre \"BBB\": ", nuevoNombre, persona.getNombre());
		
	}

	@Test
	public void testToString() {
		//fail("Not yet implemented");
		Persona p = new Persona("ZZZ", 100);
		assertEquals("ZZZ 100 ToString", "ZZZ 100", p.toString());
	}

	@Test
	public void testCompareTo() {
		Persona persona2 = new Persona("CCC", 2);
		assertEquals("Deberia dar 1", 1, persona.compareTo(persona2));
	}

}
