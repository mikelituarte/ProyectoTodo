package xml;

import com.sun.xml.internal.bind.v2.model.core.ErrorHandler;
import com.sun.xml.internal.bind.v2.runtime.IllegalAnnotationException;



public class ErrorHandlerLibros extends Throwable implements ErrorHandler{

	public static final String mensaje = "Error al interpretar el fichero XML";
	
	@Override
	public void error(IllegalAnnotationException arg0) {
		// TODO Auto-generated method stub
		System.out.println(mensaje);
	}

	
	
}
