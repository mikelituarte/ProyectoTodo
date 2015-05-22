//package org.microforum.cursojava;
package xml;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

//import curso.repaso.basico.Persona;

public class ProcesoSAX {

	public static void main(String[] args) {  
		 Libro libro = new Libro(); 
         LibroXML libroXML = new LibroXML(libro);
	      try {  
	         // Creamos nuestro objeto libro vac�o  
	    	 //	Libro libro = new Libro();  
	         // Creamos la factoria de parseadores por defecto  
	         XMLReader reader = XMLReaderFactory.createXMLReader();  
	         // A�adimos nuestro manejador al reader pasandole el objeto libro  
	         reader.setContentHandler(libroXML);   //por cada evento qie ocurra, llama al manejador LibroXML (startelement,..)
	        // reader.setContentHandler(new LibroXML(libro));
	         // Procesamos el xml de ejemplo  
	         reader.parse(new InputSource(new FileInputStream("libros.xml")));  
	         
	        // System.out.println(libro.toString()); 
	         System.out.println(libroXML.getHasMapLibros());
	      } catch (SAXException e) {  
	         e.printStackTrace();  
	      } catch (IOException e) {  
	         e.printStackTrace();  
	      }  
	  
	   }  
}
