//package org.microforum.cursojava;
package xml;

import java.util.HashMap;

public class Libro implements Comparable<Libro> {
	   private String isbn;  
	   private String titulo;  
	   private String autor ;  
	   private String anyo;  
	   private String editorial;  
	  // private static HashMap<String, Libro> hasMapLibros;
	     
	   // Constructor por defecto  
	   public Libro() {  
	        this.isbn = null;
	        this.titulo = null;
	        this.autor = null;
	        this.anyo = null;
	        this.editorial = null;
	        //this.hasMapLibros = null;
	   }  
	   
	   public Libro(String isbn, String titulo, String autor, String anyo, String editorial) {  
	        this.isbn = isbn;
	        this.titulo = titulo;
	        this.autor = autor;
	        this.anyo = anyo;
	        this.editorial = editorial;
	   } 
	   
	   public String getIsbn() {  
	      return isbn;  
	   }  
	     
	   public void setIsbn(String isbn) {  
	      this.isbn = isbn;  
	   }  
	     
	   public String getTitulo() {  
	      return titulo;  
	   }  
	     
	   public void setTitulo(String titulo) {  
	      this.titulo = titulo;  
	   }  
	     
	   public String getAutor() {  
	      return autor;  
	   }  
	     
	   public void setAutor(String autor) {  
	      this.autor = autor;  
	   }  
	     
	   public String getAnyo() {  
	      return anyo;  
	   }  
	     
	   public void setAnyo(String anyo) {  
	      this.anyo = anyo;  
	   }  
	     
	   public String getEditorial() {  
	      return editorial;  
	   }  
	     
	   public void setEditorial(String editorial) {  
	      this.editorial = editorial;  
	   }  
	   
	/*	public HashMap<String, Libro> getHasMapLibros() {
			return hasMapLibros;
		}

		public void setHasMapLibros(HashMap<String, Libro> hasMapLibros) {
			this.hasMapLibros = hasMapLibros;
		}  */
	  
	   @Override  
	   public String toString() {  
	      StringBuilder sb = new StringBuilder(); //tipo de String m�s r�pido en a�adir! 
	      sb.append("\nISBN: "+isbn);  
	      sb.append("\nT�tulo: "+titulo);  
	      sb.append("\nAutor: "+autor);  
	      sb.append("\nA�o: "+anyo);  
	      sb.append("\nEditorial: "+editorial);  
	        
	      return sb.toString();  
	   }

	@Override
	public int compareTo(Libro arg0) {
		// TODO Auto-generated method stub
		return this.titulo.compareTo(arg0.getTitulo());
	}
	   
	   
	


	     
	     
	  
	}  
