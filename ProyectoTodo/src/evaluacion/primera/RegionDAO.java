package evaluacion.primera;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;

public class RegionDAO {

	
	
	/**
	 * Dado un Id de Region, retorna una RegionDTO 
	 * @param id_region
	 * @return Devuelve la Region que coincida con el ID pasado como parametro, en caso de no existir, retorna null
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static RegionDTO recuperarRegionPorID(int id_region) throws ClassNotFoundException, SQLException{
		RegionDTO regionDTO = null;
		ResultSet rset = null;
		int region_id = 0;
		String region_name = null;

		Connection nuevaConexion = Conexion.obtenerConexion();
		PreparedStatement pstm = nuevaConexion.prepareStatement(InstruccionesSQL.CONSULTAR_REGION_POR_ID);
		pstm.setInt(1, id_region);
		rset = pstm.executeQuery();
		while(rset.next()){
			region_id = rset.getInt(1);
			region_name = rset.getString(2);
			regionDTO = new RegionDTO(region_id, region_name);
		}
		
		Conexion.liberarRecursos(nuevaConexion, pstm, rset);
		return regionDTO;
	}
	
	
	/**
	 * Inserta todas la Regiones de la base de datos en un ArrayList
	 * @return Retorna un ArrayList<RegionDTO> con todas las regiones de la BBDD
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ArrayList<RegionDTO> recuperarRegiones() throws ClassNotFoundException, SQLException{
		RegionDTO regionDTO = null;
		ResultSet rset = null;
		int region_id = 0;
		String region_name = null;
		ArrayList<RegionDTO> lrDTO = new ArrayList<RegionDTO>();

		Connection nuevaConexion = Conexion.obtenerConexion();
		Statement stm = nuevaConexion.createStatement();
		rset = stm.executeQuery(InstruccionesSQL.CONSULTAR_REGIONES);
		while(rset.next()){
			region_id = rset.getInt(1);
			region_name = rset.getString(2);
			
			regionDTO = new RegionDTO(region_id, region_name);
			lrDTO.add(regionDTO);
		}		
		
		Conexion.liberarRecursos(nuevaConexion, stm, rset);
		return lrDTO;
	}

	
	/**
	 * Inserta la region dada como parametro, en caso de ya existir su ID no inserta nada
	 * @param regionDTO
	 * @return Retorna TRUE si se ha insertado correctamente la region, False en caso contrario
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static boolean insertarRegion(RegionDTO regionDTO) throws ClassNotFoundException, SQLException{
		ResultSet rset = null;
		boolean exito = true;
		Savepoint sp = null;
		Connection nuevaConexion = null;
		PreparedStatement pstm = null;
		
		if(recuperarRegionPorID(regionDTO.getRegion_id()) == null){
			try{
				nuevaConexion = Conexion.obtenerConexion();
				nuevaConexion.setAutoCommit(false);
				sp = nuevaConexion.setSavepoint();
				pstm = nuevaConexion.prepareStatement(InstruccionesSQL.INSERTAR_REGION);
				pstm.setInt(1, regionDTO.getRegion_id());
				pstm.setString(2, regionDTO.getRegion_name());
				pstm.execute();
			}
			catch(Exception e){
				nuevaConexion.rollback(sp);
			}
			finally{
				Conexion.liberarRecursos(nuevaConexion, pstm, rset);
			}
		}
		else{
			exito = false;
		}
		return exito;
	}
	
	//Actualizar

	//borrar
	
	
	
}
