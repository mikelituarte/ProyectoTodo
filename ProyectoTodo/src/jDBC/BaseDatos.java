package jDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseDatos {
	
	
	public static void main(String[] args) throws Exception {
		
		
		Connection conn = null;
		ResultSet rset = null;
		Statement stmt = null;
		
		
		try
		{
			//registro el driver, en realidad, hago que se ejecuten unas pocas l�neas de la clase OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());// m�todo equivalente al anterior
			//Sea como sea, es, <<oye, si te piden una conexi�n, se la pides a esa clase!>>
			conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "mikelbbdd");
  	        stmt = conn.createStatement();

  	        //rset = stmt.executeQuery("select BANNER from SYS.V_$VERSION");
			rset = stmt.executeQuery("select * from employees");
			while (rset.next()){	
				//System.out.println (rset.getString(2));
				for (int i=1; i<=11; i++){
					System.out.print (rset.getString(i) +" // ");
					
				}
				System.out.println("");
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

