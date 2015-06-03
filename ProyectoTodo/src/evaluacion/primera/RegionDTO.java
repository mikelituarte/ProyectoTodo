package evaluacion.primera;

public class RegionDTO implements Comparable<RegionDTO> {

	private int region_id;
	private String region_name;
	
	
	public RegionDTO(int region_id, String region_name) {
		super();
		this.region_id = region_id;
		this.region_name = region_name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String res = "----------------------\n";
		res += "region_id: " + this.region_id + "\n";
		res += "region_name: " + this.region_name + "\n";
		res += "----------------------\n";
		return res;
	}


	public int getRegion_id() {
		return region_id;
	}


	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}


	public String getRegion_name() {
		return region_name;
	}


	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	
	@Override
	public int compareTo(RegionDTO arg0) {
		// TODO Auto-generated method stub
		return this.region_id - arg0.getRegion_id();
	}
	
	
}
