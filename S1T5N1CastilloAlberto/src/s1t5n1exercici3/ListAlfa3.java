package s1t5n1exercici3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class ListAlfa3 {

	private String dir;

	public ListAlfa3(String dir) {

		this.dir = dir;
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
			String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "s1t5n1exercici3"+File.separator;
			for (int i = 0; i < result.length; i++) {

				if (result[i].isDirectory()) {
					date = result[i].lastModified();
				
					escribir("D :"+result[i].getAbsolutePath() + formato.format(date)+"\n",path+"result.txt");

				} else if (result[i].isFile()) {
					date = result[i].lastModified();
					
					escribir("F :"+result[i].getAbsolutePath() + formato.format(date)+"\n",path+"result.txt");

				}

			}

		}
	}
	
	// método que escribe en  un  archivo
	public  void escribir(String ruta, String path) {

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
	
}
