package jDBC_DAO_DTO;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {


		
		
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();
		ArrayList<EmpleadoDTO> leDTO = empleadoDAO.recuperarTodos();
		
		
		Iterator<EmpleadoDTO> it = leDTO.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
