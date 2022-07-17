package s1t5n1exercici5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class ListAlfa5 implements Serializable {

	private static final long serialVersionUID = 1L;

	private String dir;
	
	private ArrayList<String> contenido;


	public ListAlfa5(String dir) {

		this.dir = dir;
		this.contenido = new ArrayList<String>();
		
	}

	//método lista el contenido del directorio,  subdirectorios y fecha de modificación en orden alfabético 
	public void listar() throws IOException {
		File[] result = null;

		File directorio = new File(this.dir);
		if (!directorio.isDirectory()) {
			throw new IOException();
		} else {

			result = directorio.listFiles();
			Arrays.sort(result);
			long date;
			DateFormat formato = new SimpleDateFormat("MMM dd, yyyy hh:mm a");
			String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "s1t5n1exercici5"+File.separator;
			for (int i = 0; i < result.length; i++) {

				if (result[i].isDirectory()) {
					date = result[i].lastModified();

					escribirAcchivo("D :" + result[i].getAbsolutePath() + formato.format(date) + "\n",
							path + "result.txt");
					contenido.add("D :" + result[i].getAbsolutePath() + formato.format(date)+"\n");

				} else if (result[i].isFile()) {
					
					date = result[i].lastModified();
					escribirAcchivo("F :" + result[i].getAbsolutePath() + formato.format(date) + "\n",
							path + "result.txt");
					contenido.add("D :" + result[i].getAbsolutePath() + formato.format(date)+"\n");
				}

			}

			leerArchivo(path + "result.txt");
		}
		
		
	}

	// método que escribe en  un  archivo
	public void escribirAcchivo(String ruta, String path) {

		try {
			try (FileWriter escribiendo = new FileWriter(path, true)) {

				for (int i = 0; i < ruta.length(); i++) {
					escribiendo.write(ruta.charAt(i));

				}
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	// método que lee   un  archivo linea a linea
	public void leerArchivo(String path) {

		try (FileReader entrada = new FileReader(path)) {

			BufferedReader leer = new BufferedReader(entrada);

			String linea = "";

			while (linea != null) {

				linea = leer.readLine();
				if (linea != null) {

					//System.out.println(linea);
				}
			}

		} catch (IOException e) {

			System.out.println(" No se encontro el archivo");
		}

	}


	@Override
	public String toString() {
		return "ListAlfa5 [dir=" + dir + ", contenido=" + contenido + "]";
	}


	
	
	
	
	
	
}
