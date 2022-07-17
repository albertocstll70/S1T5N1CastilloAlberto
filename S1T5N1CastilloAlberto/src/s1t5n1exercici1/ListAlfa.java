package s1t5n1exercici1;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ListAlfa {

	private String dir;

	public ListAlfa(String dir) {

		this.dir = dir;
	}

	//método lista el contenido del directorio en orden alfabético
	public void listar() throws IOException {
		String[] result = null;

		File directorio = new File(this.dir);
		if (!directorio.isDirectory()) {
			throw new IOException();
		} else {

			result = directorio.list();
			Arrays.sort(result);

			for (int i = 0; i < result.length; i++) {
				System.out.println(result[i]);
			}

		}
	}

}
