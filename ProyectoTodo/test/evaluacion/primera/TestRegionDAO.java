package evaluacion.primera;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import javafx.scene.layout.Region;

import org.junit.Test;

public class TestRegionDAO {

	@Test
	public void testRecuperarRegionPorID() throws ClassNotFoundException, SQLException {
		assertNotNull("El objeto ha dado nulo", RegionDAO.recuperarRegionPorID(5));
	}

	@Test
	public void testRecuperarRegiones() throws ClassNotFoundException, SQLException {
		RegionDTO rgDTO1 = new RegionDTO(10, "AAA");
		
		RegionDAO.insertarRegion(rgDTO1);
		assertTrue(RegionDAO.recuperarRegiones().contains(rgDTO1));
	}

	@Test
	public void testInsertarRegion() throws ClassNotFoundException, SQLException {
		//fail("Not yet implemented");
		RegionDTO rgDTO1 = new RegionDTO(10, "AAA");
		
		
		assertTrue(!RegionDAO.insertarRegion(rgDTO1));
		
	}

}
