package s1t5n1exercici3;

import java.io.IOException;



public class MainExercici3 {

	public static void main(String[] args) {
		
		String nombreDir = System.getProperty("user.home");
		
		ListAlfa3 list1 = new ListAlfa3(nombreDir);
		
		try {
			list1.listar();
		} catch (IOException e) {
			
			System.err.println("No se encontro el directorio");
		}

	}
		

	

}
