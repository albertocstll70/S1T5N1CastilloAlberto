package s1t5n1exercici4;

import java.io.IOException;



public class MainExercici4 {

	public static void main(String[] args) {
	String nombreDir = System.getProperty("user.home");
		
		ListAlfa4 list1 = new ListAlfa4(nombreDir);	
		
		try {
			list1.listar();
		} catch (IOException e) {
			
			System.err.println("No se encontro el directorio");
		}

	}
		

	

}
