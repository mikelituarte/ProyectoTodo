package persona;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Spliterator;
import java.util.function.Consumer;

import org.apache.log4j.Logger;

//import curso.ejemplos.basicos.Persona;
//import curso.repaso.excepciones.InsertarPersonaException;



//package val.examples.basic;

//import val.examples.basic.exceptions.InsertarPersonaException;

//public class ListaPersonas implements Iterator<Persona>{
public class ListaPersonas implements Iterable<Persona>{
	
	private final static Logger log = Logger.getLogger("mylog");
	public static final int CAPACIDAD = 10;
	
	private Persona[] array_personas;
	private int cantidadPersonas; //indica el numero de personas que hay en el array_personas

	
	/**
	 * Es muy posible que haga falta a�adir alg�n campo m�s
	 */
	
	public ListaPersonas()
	{
		//TODO HAY QUE HACER UN CONSTRUCTOR
		//RECUERDA QUE EL CONSTRUCTOR SIRVE PARA
			//RESERVAR MEMORIA
			//INICIALIZAR EL ESTADO DEL OBJETO Y SUS ATRIBUTOS
		
		this.array_personas = new Persona[CAPACIDAD];
		this.cantidadPersonas = 0;
	}
	
	

	
	
	public Persona[] getListaPersonas ()
	{
		//TODO HAY QUE DEVOLVER EL ARRAY DE PERSONAS QUE CONFORMAN LA LISTA
		
		return this.array_personas;
	}
	
	public int getCantidadPersonas() {
		return this.cantidadPersonas;
	}
	
	
	
	
	public Persona buscarPersona (String nombre)
	{
		//TODO BUSCAR PERSONA POR NOMBRE Y DEVOLVERLA
		//SI NO ESTa, DEVOLVER NULO
		boolean encontrado = false;
		int pos = 0;
		Persona persona = null;
		if(this.cantidadPersonas>0){
			while(!encontrado && (pos < this.cantidadPersonas)){ //he puesto pos<Capacidad
				if (this.array_personas[pos].getNombre().equals(nombre)){
					encontrado = true;
					persona = this.array_personas[pos];
				}
				pos++;
			}
		}
		return persona;
	}
	
	
	
	public Persona busarPersona (int edad)
	{
		//TODO BUSCAR PERSONA POR EDAD Y DEVOLVERLA
		//SI NO EST�, DEVOLVER NULO
		boolean encontrado = false;
		int pos = 0;
		Persona persona = null;
		

		while(!encontrado && (pos < cantidadPersonas)){
			if (this.array_personas[pos].getEdad() == edad ){
				encontrado = true;
				persona = this.array_personas[pos];
			}
			pos++;
		}
		
		return persona;
		
	}
	
	
	
	public boolean serializar ()
	{
		//Hacer uso del fichero de propiedades serializa.properties, 
		//para obtener de él el valor de la clave destino, 
		//que representa el nombre del fichero de salida
		
		boolean exito = true;
		Properties propiedades = new Properties();//para properties
		FileInputStream fInputStream = null;//para properties
		ObjectOutputStream salida = null;//para serializar
		String ruta = null;
		
		//obtenemos la ruta de destino que es donde queremos serializar 
		try{
			fInputStream = new FileInputStream("serializa.properties"); 
			propiedades.load(fInputStream);
			ruta = propiedades.getProperty("destino");
		}
		catch(FileNotFoundException e){
			System.out.println("Error al leer el fichero \"serializa.properties\"");
			exito = false;
		}
		catch (IOException i) {
			System.out.println("Error al cargar el fichero \"serializa.properties\"");
			exito = false;
		}
		finally{
			//cerramos el fichero de properties
			try {
				fInputStream.close();
			} catch (IOException e) {
				System.out.println("Error al cerra el fichero de propiedades");
			}
		}
		
		//serializamos en el fichero ruta
		try{
			salida = new ObjectOutputStream(new FileOutputStream(ruta));
			salida.writeObject(this.array_personas);
		}
		catch(Exception e){
			System.out.println("Error al cargar el fichero de serializacion en la ruta: " + ruta);
			exito = false;
		}
		finally{
			try {
				salida.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar el fichero donde serializamos");
			}
		}
		return exito;
	}
	
	
	
	/*public boolean deserializar()
	{
		boolean exito = true;
		ObjectInputStream entrada = null;
		Persona[]  aP = null;
		
		try{
			entrada = new ObjectInputStream(new FileInputStream("listapersonas.dat"));
			aP = (Persona[])entrada.readObject();
		}
		catch(Exception e){
			System.out.println("Error al cargar el fichero deserializar \"listapersonas.dat\"");
			exito = false;
		}
		finally{
			try {
				entrada.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar el fichero deserializable \"listapersonas.dat\"");
			}
		} 
		
		this.array_personas = aP;
		return exito;

	}*/
	
	
	public Persona[] deserializar()
	{
		//boolean exito = true;
		ObjectInputStream entrada = null;
		Persona[]  aP = null;
		
		try{
			entrada = new ObjectInputStream(new FileInputStream("listapersonas.dat"));
			aP = (Persona[])entrada.readObject();
		}
		catch(Exception e){
			System.out.println("Error al cargar el fichero deserializar \"listapersonas.dat\"");
			//exito = false;
		}
		finally{
			try {
				entrada.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar el fichero deserializable \"listapersonas.dat\"");
			}
		} 
		
		//this.array_personas = aP;
		//return exito;
		return aP;

	}
	
	
	
	
	public void insertarPersona (Persona p) throws InsertarPersonaException
	{
		//log.trace("Invocado metodo InsertarPersonas");
		//no se debe insertar un duplicado de nombre
		Persona nuevaPersona = null;
		if (!estaLlena()){
			//si la persona no esta repetida...
			if (buscarPersona(p.getNombre()) == null){
				nuevaPersona = p;
				array_personas[this.cantidadPersonas] = nuevaPersona;
				this.cantidadPersonas++;
			}
			else{// si la persona esta repetida
				log.warn("Cuidaito!!!!! La persona ya esta insertada");
				System.out.println("La persona \"" + p.toString() + "\" ya esta insertada");
			}
		}
		else{
			log.error("Error grave al insertar Persona");
			throw new InsertarPersonaException();
		}
	}
	
	
	
	public int numeroPersonas()
	{
		return this.cantidadPersonas;
	}
	
	
	
	public boolean estaLlena()
	{
		/*
		boolean lleno = true;
		int pos = 0;
		
		while(lleno && pos < CAPACIDAD){
			if (array_personas[pos] == null){
				lleno = false;
			}
		}
		return lleno;*/
		
		return (numeroPersonas()==CAPACIDAD);
	}
	
	public void mostrar()
	{
		//TODO MOSTRAR LA LISTA DE PERSONAS
		// pista: ayudarse del metodo toString de persona
		if(this.cantidadPersonas>0){
			for (int i = 0; i < this.cantidadPersonas; i++){
				System.out.println(array_personas[i].toString());
			}
		}
		else{
			System.out.println("No hay personas en la lista");
		}
		
	}
	
	
	public int posPersona(String nombre){
		int pos =-1;
		boolean encontrada = false;
		int aux =0;
		while(!encontrada && aux < cantidadPersonas){
			if (this.array_personas[aux].getNombre().equals(nombre)){
				pos = aux;
			}
			aux++;
		}
		
		return pos;
	}
	
	
	public void eliminarPersona(String nombre){
		
		int pos =0;
		if (  (numeroPersonas()>0 )&&((pos =posPersona(nombre))!= -1)   ){ //si hay personas y si existe esa persona...
			for(int i= pos; i<CAPACIDAD-1; i++){
				this.array_personas[i] = this.array_personas[i+1];
			}
			this.array_personas[CAPACIDAD-1] = null;
			this.cantidadPersonas--;
		}
		else{//si no existe la persona a borrar
			System.out.println("La persona \"" + nombre + "\" NO existe en la lista" );
		}
	}


	@Override
	public void forEach(Consumer<? super Persona> arg0) {
		// TODO Auto-generated method stub	
	}


	@Override
	public Iterator<Persona> iterator() {
		// TODO Auto-generated method stub
		Recorrer r = new Recorrer(this);
		return r;
	}


	@Override
	public Spliterator<Persona> spliterator() {
		// TODO Auto-generated method stub
		return null;
	}

}

