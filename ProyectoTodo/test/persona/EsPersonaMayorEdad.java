package persona;

import org.hamcrest.Description;
import org.junit.internal.matchers.TypeSafeMatcher;

public class EsPersonaMayorEdad extends TypeSafeMatcher<Persona> {

	private int edad;
	
	@Override
	public void describeTo(Description arg0) {
		// TODO Auto-generated method stub
		arg0.appendText("Resultado esperado: persona mayor de edad\n");
		arg0.appendText("Obtenido pesona:" + this.edad);	
	}

	@Override
	public boolean matchesSafely(Persona arg0) {
		// TODO Auto-generated method stub
		
		boolean res = false;
		
		return arg0.isMAyorEdad();
	}

}
