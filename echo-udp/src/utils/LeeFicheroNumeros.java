package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeeFicheroNumeros {

	public List<Double> leeficheronumeros(File fichero) throws IOException {

		List<Double> listanumeros = new ArrayList<>();

		BufferedReader reader = new BufferedReader(new FileReader(fichero));
		String linea = reader.readLine();
		while (linea != null) {

			String numero = linea;
			listanumeros.add(Double.parseDouble(numero));

			linea = reader.readLine();
		}
		reader.close();
		return listanumeros;

	}
}
