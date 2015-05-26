package xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class PracticaJDOM {
	
	/**
	 * Dado un fichero XML, devuelve el Elemento raiz de dicho fichero
	 * @param ficheroXML
	 * @return Devuelve un Element que es la Raiz del fichero
	 * @throws FileNotFoundException
	 * @throws JDOMException
	 * @throws IOException
	 */
	public static Element raizFichero(String ficheroXML) throws FileNotFoundException, JDOMException, IOException{
		//CREAMOS EL PARSER
		SAXBuilder builder = new SAXBuilder();
		Element raiz = null;
		// Construimos el arbol DOM a partir del fichero xml
		Document documentJDOM = builder.build(new FileInputStream(ficheroXML));
		raiz = documentJDOM.getRootElement();
		
		return raiz;
	}
	
	/**
	 * Dado un fichero XML con Libros, devuelve un ArrayList de Libros con todos los libros del fichero XML
	 * @param ficheroXML Es la ruta donde se encuentra el fichero XML 
	 * @return ArrayList de Libros
	 * @throws FileNotFoundException
	 * @throws JDOMException
	 * @throws IOException
	 */
	public static ArrayList<Libro> obtenerLibrosXML(String ficheroXML) throws FileNotFoundException, JDOMException, IOException{
		ArrayList<Libro> arrayLibros = new ArrayList<Libro>();
		Libro book = null;
		String isbn = null;
		String titulo = null;
		String autor = null;
		String anyo = null;
		String editorial = null;
		
		
		Element raiz = raizFichero(ficheroXML);//obtnemos el 
		// Recorremos los hijos de la etiqueta raíz
		List<Element> libros = raiz.getChildren();
		for (Element libro : libros) {
			//para cada libro, obtenemos su detalle
			List<Element> detalles = libro.getChildren();
			//Guardo el isbn...
			isbn = libro.getAttribute("isbn").getValue(); 
			for (Element detalle : detalles) {
				switch (detalle.getName()) {
				case "titulo":
					titulo = detalle.getValue();
					break;
				case "autor":
					 autor = detalle.getValue();
					break;
				case "anyo":
					anyo = detalle.getValue();
					break;
				case "editorial":
					editorial = detalle.getValue();
					break;
				}
			}
			//Creo el nuevo libro con los datos capturados anteriormente (isb, titulo...)
			book = new Libro(isbn, titulo, autor, anyo, editorial);
			//Añado el nuevo libro al arrayList
			arrayLibros.add(book);			
		}
		return arrayLibros;
	}
	
	/**
	 * Seriealizamos el arrayList de libros pasado como parametro en un nuevo fichero XML pasado como parametro
	 * @param rutaDestino Es la ruta del nuevo fichero XML
	 * @param arrayLibros Es el arrayList de Libros que quiero serializar
	 * @throws FileNotFoundException
	 * @throws JDOMException
	 * @throws IOException
	 */
	public static void serializarLibros(String rutaDestino, ArrayList<Libro> arrayLibros) throws FileNotFoundException, JDOMException, IOException{		
		
		Libro libro = null;

		Element elementoRaiz = new Element("libros");//creamos el elemento Raiz
		Document documentJDOM = new Document(elementoRaiz);//creamos un nuevo documentoXML con raiz el elemento Padre
		Element padre = documentJDOM.getRootElement();//Obtenemos la raiz del nuevo fichero XML
		Iterator<Libro> it =  arrayLibros.iterator();
		
		Element nuevoLibro = null;
		Element titulo = null;
		Element autor = null;
		Element anyo = null;
		Element editorial = null;
		Element total = null;
		int totalLibros = arrayLibros.size();
		while(it.hasNext()){
			libro = it.next();
			
			nuevoLibro = new Element("libro");
			nuevoLibro.setAttribute("isbn", libro.getIsbn());
			
			titulo = new Element("titulo");	
			titulo.addContent(libro.getTitulo());
			autor = new Element("autor");
			autor.addContent(libro.getAutor());
			anyo = new Element("anyo");	
			anyo.addContent(libro.getAnyo());
			editorial = new Element("editorial");
			editorial.addContent(libro.getEditorial());
			total = new Element("total");	
			//total.addContent(""+ totalLibros);
			//total.addContent(Integer.toString(totalLibros));

			nuevoLibro.addContent(titulo);
			nuevoLibro.addContent(autor);
			nuevoLibro.addContent(anyo);
			nuevoLibro.addContent(editorial);
			//nuevoLibro.addContent(total);
			padre.addContent(nuevoLibro);
			padre.setAttribute("total",Integer.toString(totalLibros));
		}
		//padre.addContent(total);
	    Format format = Format.getPrettyFormat();
	    // Creamos el serializador con el formato deseado  
	    XMLOutputter xmloutputter = new XMLOutputter(format);
	    // Serializamos el document parseado  
	    String docStr = xmloutputter.outputString(documentJDOM); 
	    //Volcamos en un fichero
	    FileWriter fw = new FileWriter(rutaDestino);
	    fw.write(docStr);
	    fw.close();
	}
	


	
	public static void main(String[] args) throws FileNotFoundException, JDOMException, IOException {
		//CREAMOS EL PARSER
		
		ArrayList<Libro> arrayLibros = new ArrayList<Libro>();

		
		arrayLibros = obtenerLibrosXML("libros.xml");
		//Ordenamos el arrayList
		//arrayLibros.sort(ComparadorLibrosTitulo, arrayLibros);
		System.out.println("----- Inicio Array Desordenado ------");
		System.out.println(arrayLibros);
		System.out.println("----- Fin Array Desordenado ------");
		System.out.println("                       ");
		System.out.println("----- Inicio Array Ordenado por Titulo ------");
		Collections.sort(arrayLibros, new ComparadorLibrosTitulo());
		System.out.println(arrayLibros);
		System.out.println("----- Fin Array Ordenado por Titulo ------");
	    
		
		
		
		//serializamos el arrayList
		serializarLibros("Prueba.xml", arrayLibros);
		
	
	
	}
	
	
}
