package xml;

import java.util.HashMap;
import java.util.Iterator;

public class ToStringHasMpLibros extends HashMap<String, Libro>{

	
	public ToStringHasMpLibros(){
		super();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String res = "";
		
		Iterator it = super.values().iterator();
		while(it.hasNext()){
			res += it.next() +" \n";
		}
		return res;
	}
}
