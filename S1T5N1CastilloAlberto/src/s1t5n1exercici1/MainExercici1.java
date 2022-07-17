package s1t5n1exercici1;

import java.io.IOException;

public class MainExercici1 {

	public static void main(String[] args) {
		
		String nombreDir = System.getProperty("user.dir");
	
		ListAlfa list1 = new ListAlfa(nombreDir);
		
		try {
			list1.listar();
		} catch (IOException e) {
			
			System.err.println("No se encontro el directorio");
		}

	}

}
