package evaluacion.primera;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//import org.apache.log4j.Logger;

public class Conexion {
	
	private final static String driver = "oracle.jdbc.driver.OracleDriver";;
	private final static String bbdd = "jdbc:oracle:thin:@localhost:1521:xe";
	private final static String usuario = "HR";
	private final static String pass = "mikelbbdd";
	
	
	
	public Conexion () {
		
			
	}
	
	/**
	 * Establece la conexion con la Base de Datos
	 * @return Devuelve la Conection con la base de datos
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection obtenerConexion () throws ClassNotFoundException, SQLException
	{
		Connection conn;
		Class.forName(driver);
		conn = DriverManager.getConnection (bbdd, usuario, pass);	
		return conn;
	}
	
	/**
	 * Libera la conexion
	 * @param conn
	 * @param pstmt
	 * @param rset
	 */
	public static void liberarRecursos (Connection conn, PreparedStatement pstmt, ResultSet rset)
	{
		if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (pstmt != null)	{ try {	pstmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
	}
	
	public static void liberarRecursos (Connection conn, Statement stmt, ResultSet rset)
	{
		if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
	}
}
