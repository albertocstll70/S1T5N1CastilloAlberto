package s1t5n1exercici2;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class ListAlfa2 {

	private String dir;

	public ListAlfa2(String dir) {

		this.dir = dir;
	}

	// método lista el contenido del directorio en orden alfabético
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

			for (File f : result) {

				if (f.isDirectory()) {
					date = f.lastModified();
					System.out.println("D: " + f.getName() + " ultima modificación -->  " + formato.format(date));
					this.dir = (String) f.getPath();

					listar();
				} else if (f.isFile()) {
					date = f.lastModified();
					System.out.println("F: " + f.getName() + "  ultima modificación --> " + formato.format(date));

				}

			}

		}
	}

}
