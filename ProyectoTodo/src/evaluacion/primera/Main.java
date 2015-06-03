package evaluacion.primera;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ArrayList<RegionDTO> lrDTO = null;
		RegionDTO regionDTO2 = new RegionDTO(7, "Yucatan") ;
		
		System.out.println("Mostrar Region dado un ID");
		RegionDTO regionDTO = RegionDAO.recuperarRegionPorID(1);
		System.out.println(regionDTO);
		System.out.println("Mostramos la lista de Regiones:");
		lrDTO = RegionDAO.recuperarRegiones();
		System.out.println(lrDTO);
		System.out.println("Mostramos la lista A�adiendo Regione:");
		RegionDAO.insertarRegion(regionDTO2);
		System.out.println("Mostramos la lista A�adiendo una region -XXXXXXXXXXXXXXXXXXXXXxx");
		lrDTO = RegionDAO.recuperarRegiones();
		System.out.println(lrDTO);
		
		
	}
}
