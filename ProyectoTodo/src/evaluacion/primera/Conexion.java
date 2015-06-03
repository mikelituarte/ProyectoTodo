package evaluacion.primera;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Conexion {

	
	//private static Conexion conexion = new Conexion();
	//private Connection connection;
	//private final String RUTA_PROPERTIES = "db.properties";
	//private Logger log = Logger.getLogger("mylog");
	
	private final static String driver = "oracle.jdbc.driver.OracleDriver";;
	private final static String bbdd = "jdbc:oracle:thin:@localhost:1521:xe";
	private final static String usuario = "HR";
	private final static String pass = "mikelbbdd";
	
	
	
	public Conexion () {
		
			
	}
	
	public static Connection obtenerConexion () throws ClassNotFoundException, SQLException
	{
		Connection conn;
		Class.forName(driver);
		conn = DriverManager.getConnection (bbdd, usuario, pass);	
		return conn;
	}
	
	public static void liberarRecursos (Connection conn, PreparedStatement pstmt, ResultSet rset)
	{
		if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (pstmt != null)	{ try {	pstmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
	}
	
	public static void liberarRecursos2 (Connection conn, Statement stmt, ResultSet rset)
	{
		if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
	}
}
