package jDBC_DAO_DTO;


import java.sql.SQLException;
import java.util.ArrayList;

public class EmpleadoDAO {

		//recuperarTodos() return lisEmpleadoDTO

	public ArrayList<EmpleadoDTO> recuperarTodos() throws ClassNotFoundException, SQLException{
		
		ArrayList<EmpleadoDTO> leDTO = new ArrayList<EmpleadoDTO>();//arrayList de empleadosDTO
		
		//Conexion conn = new Conexion(this.driver, this.bbdd, this.usuario, this.pass);//establezco la conexion
		Conexion conn = new Conexion();//establezco la conexion
		//Hago el Resulset con la consulta que esta en la clase InstruccionesSQL
		conn.setRset((conn.conectar()).executeQuery(InstruccionesSQL.consultaSueldo));
		EmpleadoDTO empleadoDTO = null;
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
		
		
		while (conn.getRset().next()){//Iteramos sobre cada empleado devuelto en la consulta
			employee_id = conn.getRset().getString(1);
			first_name= conn.getRset().getString(2);
			last_name= conn.getRset().getString(3);
			email= conn.getRset().getString(4);
			phone_number = conn.getRset().getString(5);
			hire_date = conn.getRset().getString(6);
			job_id = conn.getRset().getString(7);
			salary = conn.getRset().getInt(8);
			commission_pct = conn.getRset().getInt(9);
			manager_id = conn.getRset().getString(10);
			departament_id = conn.getRset().getString(11);
			//Creamos el objeto Empleado y lo añadimos al arrayList
			empleadoDTO = new EmpleadoDTO(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, departament_id);
			leDTO.add(empleadoDTO);
		}
		
		conn.liberarRecursos();
		
		return  leDTO;
	}
}
