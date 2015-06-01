package jDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Iterator;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Practica1 {

	
	
	
	public static Statement conectarBBDD(Connection conn) throws ClassNotFoundException, SQLException{
		conn = null;
		Statement stmt = null;
		
		
		//registro el driver, en realidad, hago que se ejecuten unas pocas líneas de la clase OracleDriver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());// método equivalente al anterior
		//Sea como sea, es, <<oye, si te piden una conexión, se la pides a esa clase!>>
		conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "mikelbbdd");
  	    stmt = conn.createStatement();
  	    return stmt;
	}
	
	
	
	public static void main(String[] args) {
		
		
		Connection conn = null;
		ResultSet rset = null;
		Statement stmt = null;
		
		 String employee_id;
		 String first_name;
		 String last_name;
		 String email;
		 String phone_number;
		 String hire_date;
		 String job_id;
		 int salary;
		 int commission_pct;
		 String manager_id;
		 String departament_id;
		 
		 Empleado empleado;
		 ListaEmpleados le = new ListaEmpleados();
		
		
		try
		{
			stmt = conectarBBDD(conn);
			rset = stmt.executeQuery("select * from employees");
			while (rset.next()){	
				  employee_id = rset.getString(1);
				  first_name= rset.getString(2);
				  last_name= rset.getString(3);
				  email= rset.getString(4);
				  phone_number = rset.getString(5);
				  hire_date = rset.getString(6);
				  job_id = rset.getString(7);
				  salary = rset.getInt(8);
				  commission_pct = rset.getInt(9);
				  manager_id = rset.getString(10);
				  departament_id = rset.getString(11);
				  empleado = new Empleado(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, departament_id);
				  le.insertarEmpleado(empleado);
			}
			/*Iterator<Empleado> it = le.getListaEmpleado().iterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}*/
			//Lo ordenamos por salario
			Collections.sort(le.getListaEmpleado());
			Iterator<Empleado> it = le.getListaEmpleado().iterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally //libero recursos, de "adentro a fuera" , ResultSet, Statment, Conexion
		{
			if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
		  	   
		}   
	}
	
}
