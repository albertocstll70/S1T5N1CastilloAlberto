package s1t5n1exercici4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class ListAlfa4 {

	private String dir;

	public ListAlfa4(String dir) {

		this.dir = dir;
	}

	// método lista el contenido del directorio, subdirectorios y fecha de
	// modificación en orden alfabético
	public void listar() throws IOException {
		File[] result = null;

		File directorio = new File(this.dir);
		if (!directorio.exists()) {
			throw new IOException();
		} else {

			result = directorio.listFiles();
			Arrays.sort(result);
			long date;
			DateFormat formato = new SimpleDateFormat("MMM dd, yyyy hh:mm a");
			String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "s1t5n1exercici4"
					+ File.separator;
			for (File f : result) {

				if (f.isDirectory()) {
					date = f.lastModified();
					escribir("D: " + f.getName() + "  ultima modificación --> " + formato.format(date) + "\n",
							path + "result.txt");
					this.dir = (String) f.getPath();

					listar();
				} else if (f.isFile()) {
					date = f.lastModified();
					escribir("F: " + f.getName() + "  ultima modificación --> " + formato.format(date) + "\n",
							path + "result.txt");

				}

			}

			leerArchivo(path + "result.txt");
		}
	}

	// método que escribe en un archivo
	public void escribir(String ruta, String path) {

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

	// método que lee un archivo linea a linea
	public void leerArchivo(String path) {

		try (FileReader entrada = new FileReader(path)) {

			BufferedReader leer = new BufferedReader(entrada);

			String linea = "";

			while (linea != null) {

				linea = leer.readLine();
				if (linea != null) {

					System.out.println(linea);
				}
			}

		} catch (IOException e) {

			System.out.println(" No se encontro el archivo");
		}

	}

}
