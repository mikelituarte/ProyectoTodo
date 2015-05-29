package persona;

//package val.examples.basic;
import java.io.Serializable;

public class Persona implements Serializable, Comparable<Persona> {
	
	private int edad;
	private String nombre;
	
	
	public Persona(String nombre, int edad) {
		this.edad = edad;
		this.nombre = nombre;
	}


	public int getEdad() {
		return this.edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getNombre() {
		return this.nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return this.nombre + " " + this.edad;
	}


	@Override
	public int compareTo(Persona arg0) {
		// TODO Auto-generated method stub	
		int comparacion = 0;
		if(this.edad > arg0.getEdad()){
			comparacion = 1;
		}
		else{
			if (this.edad < arg0.getEdad()){
				comparacion = -1;
			}
			else 
				comparacion = 0;
		}
		return comparacion;
		//return this.nombre.compareTo(arg0.getNombre());
	}

	//@Override
	public boolean equals(Persona p) {
		// TODO Auto-generated method stub
		return (    this.nombre.equals(p.getNombre())   &&      this.edad == p.getEdad()     );
	}
	
	

	
}