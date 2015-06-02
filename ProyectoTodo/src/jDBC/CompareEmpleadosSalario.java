package jDBC;

import java.util.Comparator;


public class CompareEmpleadosSalario implements Comparator<Empleado> {

	@Override
	public int compare(Empleado e1, Empleado e2) {
		return e2.getSalary() - e1.getSalary();
	}
}
