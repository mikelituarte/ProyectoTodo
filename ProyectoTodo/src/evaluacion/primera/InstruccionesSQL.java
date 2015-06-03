package evaluacion.primera;

public class InstruccionesSQL {

	
	public static final String CONSULTAR_REGION_POR_ID = "SELECT * FROM regions WHERE region_id = ?";
	
	public static final String CONSULTAR_REGIONES = "SELECT * FROM regions";
	
	public static final String INSERTAR_REGION = "INSERT INTO REGIONS (region_id, region_name) VALUES (?,?)";
	
}
