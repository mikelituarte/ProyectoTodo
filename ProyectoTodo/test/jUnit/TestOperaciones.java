package jUnit;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestOperaciones {

	public static Operaciones tester;
	
	@BeforeClass	
	public static void iniciaClase(){
		tester = new Operaciones();
	}
	
	@Test
	public void testSuma() {
		//fail("Not yet implemented");
		assertEquals("5 mas 3 = 8", 8, tester.suma(5, 3));
	}

	@Test
	public void testMultiplicacion() {
		//fail("Not yet implemented");
		assertEquals("5 por 3 = 15", 15, tester.multiplicacion(5, 3));
	}

	@Test
	public void testDivision() {
		//fail("Not yet implemented");
		assertEquals("5 entre 3 = 1", 1, tester.division(5, 3));
	}

	@Test
	public void testResta() {
		//fail("Not yet implemented");
		assertEquals("5 menos 3 = 2", 2, tester.resta(5, 3));
	}
	
	@AfterClass
	public static void finalClase(){
		tester = null;
		System.out.println("Fin del Test");
	}

}
