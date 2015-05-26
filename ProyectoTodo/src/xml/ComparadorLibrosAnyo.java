package xml;

import java.util.Comparator;

public class ComparadorLibrosAnyo implements Comparator<Libro>{

	@Override
	public int compare(Libro arg0, Libro arg1) {
		// TODO Auto-generated method stub
		return arg0.getAnyo().compareTo(arg1.getAnyo());
	}
	
}
