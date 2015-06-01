package persona;

public class Piramide {

	
	public static String linea(int numero){
		String res = "";
		
		int espacios =0;
		String numeroS= "";
		String sp = "";
		for(int i=0; i<=numero; i++){
			numeroS += i;
		}
		for(int i=numero-1; i>=0; i--){
			numeroS += i;
		}
		
		return numeroS;
	}
	
	public static void piramide(int tamaño){
		
		int espacios =0;
		String numero= "";
		String sp = "";
		String res = "";
		for(int i=1; i<=tamaño; i++){
			
			numero = linea(i) ;
			espacios = linea(tamaño).length() - (i-1);
			sp = "";
			for(int j=0; j<espacios; j++){
				sp += " ";
			}
			res = sp + numero;
			System.out.println(res);
		}

	}
	
	public void cuadrado(int tamaño) {
		for(int i=0; i<tamaño; i++){
			
		}
	}
	
	public static void main(String[] args) {
		piramide(110);
		//System.out.println(linea(5));
	}
}
