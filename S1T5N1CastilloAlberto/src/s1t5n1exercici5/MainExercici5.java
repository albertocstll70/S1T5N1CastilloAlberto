package s1t5n1exercici5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class MainExercici5 {

	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "s1t5n1exercici5"+File.separator;
        String nombreDir = System.getProperty("user.home");
		
		ListAlfa5 list1 = new ListAlfa5(nombreDir);	
		
		
		
		
		
		try {
			
			ObjectOutputStream escribirFichero = new ObjectOutputStream(new FileOutputStream(path+"copia.ser"));
			list1.listar();
			escribirFichero.writeObject(list1);
			escribirFichero.close();
			
			ObjectInputStream recuperarFichero = new ObjectInputStream(new FileInputStream(path+"copia.ser"));
			ListAlfa5   recuperarFichero1 = (ListAlfa5) recuperarFichero.readObject() ;			 
			  recuperarFichero.close();	
			  
				  System.out.println(recuperarFichero1.toString());
				  
			  
			  
			
			
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
		

	}

	
	
	
	
	

}
