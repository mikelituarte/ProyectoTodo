package evaluacion.primera;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ArrayList<RegionDTO> lrDTO = null;
		RegionDTO regionDTO2 = new RegionDTO(8, "MiRegion") ;
		int id_region =7;
		boolean insertar = false;
		
		System.out.println("----------   Mostrar Region dado un ID ----------- ");
		RegionDTO regionDTO = RegionDAO.recuperarRegionPorID(id_region);
		if (regionDTO == null)
			System.out.println("No existe la region con el ID " + id_region);
		else
			System.out.println(regionDTO);

		
		System.out.println("-------------Insertamos una regin que ya existe -----------------");
		insertar = RegionDAO.insertarRegion(regionDTO2);
		if(!insertar){
			System.out.println("La region ya existe");
		}
		else{
			System.out.println("La region ha sido insertada correctamente \n");
		}
		 
	    System.out.println("------------------ Mostramos todas las regiones ----------------------");
		lrDTO = RegionDAO.recuperarRegiones();
		System.out.println(lrDTO);
		
		
	}
}
