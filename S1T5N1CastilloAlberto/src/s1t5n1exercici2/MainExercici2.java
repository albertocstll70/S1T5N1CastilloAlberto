package s1t5n1exercici2;

import java.io.IOException;
public class MainExercici2 {

	public static void main(String[] args) {
	
		
		String nombreDir = System.getProperty("user.home");
		
		ListAlfa2 list1 = new ListAlfa2(nombreDir);
		
		try {
			list1.listar();
		} catch (IOException e) {
			
			System.err.println("No se encontro el directorio");
		}

	}

}
