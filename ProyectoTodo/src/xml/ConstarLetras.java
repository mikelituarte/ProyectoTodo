package xml;

public class ConstarLetras {

	
	public static String contar(String linea, char letra) {
		String res = "la letra se encuentra en: ";
		
		for(int i = 0; i< linea.length(); i++){
			if (linea.charAt(i) == letra){
				res += i +", ";
			}
		}
		if(res.charAt(res.length()-2) == ','){			
			res = res.substring(0, (res.length()-2));
			res += ".";
		}
		else 
			res += "No hay conicidencias de la letra \""+ letra+ "\" en \"" + linea + "\".";
		
		return res;
	}
	
	public static void piramide(){
		String res = "";
		
		for(int i = 0; i<11; i++){
			res =res+ i + " ";
			System.out.println(res);
		}
		
	}
	
	public static void piramide2(){
		String res = "0";
		
		System.out.println(res);
		for(int i = 1; i<11; i++){
			res =res + (i) + " " + (i-1) + " " + (i) + " ";
			System.out.println(res);
		}
		
	}
	
	public static void main(String[] args) {
		String linea ="hjkhljlh djsb fjbrf je ";
		char letra = 'w';
		
		System.out.println(contar(linea, letra));
		piramide2();
	}
}
