package jDBC;

import java.util.ArrayList;

public class ListaEmpleados {

	
	private ArrayList<Empleado> listaEmpleado;

	public ListaEmpleados() {
		this.listaEmpleado = new ArrayList<Empleado>();
	}

	public ArrayList<Empleado> getListaEmpleado() {
		return listaEmpleado;
	}

	/*public void setListaEmpleado(ArrayList<Empleado> listaEmpleado) {
		this.listaEmpleado = listaEmpleado;
	}*/
	
	public void insertarEmpleado(Empleado nuevoEmpleado){
		this.listaEmpleado.add(nuevoEmpleado);
	}
	
	public void borrarEmpleado(Empleado empleado){
		this.listaEmpleado.remove(empleado);
	}
	
	
	
	
	
	
	
}
