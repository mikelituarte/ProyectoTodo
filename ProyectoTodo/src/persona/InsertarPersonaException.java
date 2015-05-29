package persona;

//import curso.repaso.basico.ListaPersonas;

//package val.examples.basic.exceptions;

//import val.examples.basic.ListaPersonas;

public class InsertarPersonaException extends Exception{
	
	public static final String mensaje = "Numero de personas excecido. Maximo " + ListaPersonas.CAPACIDAD + " personas";
	
	public InsertarPersonaException(){
		//super (mensaje);
		System.out.println(mensaje);
	}
	
}