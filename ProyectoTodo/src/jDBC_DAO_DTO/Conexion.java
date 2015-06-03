package jDBC_DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class Conexion {

	//obtener conexion
	//liberar recursos
	//implementar el patron single tone (solo se va a tener un objeto de esa clase)
	
	private  final String driver = "oracle.jdbc.driver.OracleDriver";;
	private final String bbdd = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String usuario = "HR";
	private final String pass = "mikelbbdd";
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rset;
	private static Savepoint sp;
	

	/*private Conexion(){
		
	}
	
	public Conexion getConexion(){
		return this;
	}*/
	
	public Statement conectar() throws ClassNotFoundException, SQLException{
		
		Savepoint sp = null;
		//registro el driver, en realidad, hago que se ejecuten unas pocas líneas de la clase OracleDriver
		Class.forName(this.driver);
		//DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());// método equivalente al anterior
		//Sea como sea, es, <<oye, si te piden una conexión, se la pides a esa clase!>>
		try{
			this.conn = DriverManager.getConnection (this.bbdd, this.usuario, this.pass);
			this.conn.setAutoCommit(false);
			sp =  this.conn.setSavepoint();
			this.stmt = this.conn.createStatement();
			this.conn.commit();
		}
		catch(Throwable t){
			this.conn.rollback(sp);
		}
		return this.stmt;
	}
	
	public  void savePoint() throws SQLException{
		this.sp = this.conn.setSavepoint();
	}
	
	public void commit() throws SQLException{
		this.conn.commit();
	}
	
	public void rollBack() throws SQLException{
		this.conn.rollback(sp);
	}
	
	public void liberarRecursos(){
		
		if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
	}

	public ResultSet getRset() {
		return rset;
	}

	public void setRset(ResultSet rset) {
		this.rset = rset;
	}
	
	
	
	
	
	
}
