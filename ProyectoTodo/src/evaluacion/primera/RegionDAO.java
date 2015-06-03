package evaluacion.primera;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RegionDAO {

	
	private RegionDTO formarRegion(ResultSet rset){
		RegionDTO regionDTO = null;
		
		
		
		return regionDTO;
	}
	
	
	public static RegionDTO recuperarRegionPorID(int id_region) throws ClassNotFoundException, SQLException{
		RegionDTO regionDTO = null;
		ResultSet rset = null;
		int region_id = 0;
		String region_name = null;

		Connection nuevaConexion = Conexion.obtenerConexion();
		//PreparedStatement pstm = nuevaConexion.prepareStatement("SELECT * FROM REGIONS WHERE region_id = ?");
		PreparedStatement pstm = nuevaConexion.prepareStatement(InstruccionesSQL.CONSULTAR_REGION_POR_ID);
		pstm.setInt(1, id_region);
		rset = pstm.executeQuery();
		while(rset.next()){
			region_id = rset.getInt(1);
			region_name = rset.getString(2);
		}
		//comprobar que existe la region
		
		regionDTO = new RegionDTO(region_id, region_name);
		
		Conexion.liberarRecursos(nuevaConexion, pstm, rset);
		return regionDTO;
	}
	
	
	public static ArrayList<RegionDTO> recuperarRegiones() throws ClassNotFoundException, SQLException{
		RegionDTO regionDTO = null;
		ResultSet rset = null;
		int region_id = 0;
		String region_name = null;
		ArrayList<RegionDTO> lrDTO = new ArrayList<RegionDTO>();

		Connection nuevaConexion = Conexion.obtenerConexion();
		//PreparedStatement pstm = nuevaConexion.prepareStatement("SELECT * FROM REGIONS WHERE region_id = ?");
		Statement stm = nuevaConexion.createStatement();
		rset = stm.executeQuery(InstruccionesSQL.CONSULTAR_REGIONES);
		while(rset.next()){
			region_id = rset.getInt(1);
			region_name = rset.getString(2);
			
			regionDTO = new RegionDTO(region_id, region_name);
			lrDTO.add(regionDTO);
		}
		//comprobar que existe la region
		
		
		
		Conexion.liberarRecursos2(nuevaConexion, stm, rset);
		return lrDTO;
	}
	
	
	public static void insertarRegion(RegionDTO regionDTO) throws ClassNotFoundException, SQLException{
		ResultSet rset = null;

		Connection nuevaConexion = Conexion.obtenerConexion();
		//PreparedStatement pstm = nuevaConexion.prepareStatement("SELECT * FROM REGIONS WHERE region_id = ?");
		PreparedStatement pstm = nuevaConexion.prepareStatement(InstruccionesSQL.INSERTAR_REGION);
		pstm.setInt(1, regionDTO.getRegion_id());
		pstm.setString(2, regionDTO.getRegion_name());
		pstm.execute();
		//comprobar que existe la region
		
		Conexion.liberarRecursos(nuevaConexion, pstm, rset);
	}
	
	
	
}