package xml;

import java.util.Comparator;

public class ComparadorLibrosTitulo implements Comparator<Libro>{


	
	@Override
	public int compare(Libro arg0, Libro arg1) {
		// TODO Auto-generated method stub
		return arg0.getTitulo().compareTo(arg1.getTitulo());

	}
}
