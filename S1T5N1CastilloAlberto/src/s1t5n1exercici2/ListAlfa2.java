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
			for (int i = 0; i < result.length; i++) {

				if (result[i].isDirectory()) {
					date = result[i].lastModified();
					System.out.println("D: " + result[i].getAbsolutePath() + formato.format(date));

				} else if (result[i].isFile()) {
					date = result[i].lastModified();
					System.out.println("F: " + result[i].getAbsolutePath() + formato.format(date));

				}

			}

		}
	}
}
