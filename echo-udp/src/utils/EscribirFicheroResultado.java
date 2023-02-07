package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirFicheroResultado {

	public void escribirResultado(String resultado, String ruta) throws IOException {
		File ficheroNombre = new File(ruta);
		BufferedWriter writer = new BufferedWriter(new FileWriter("resultado.txt", true));
		double result = Double.parseDouble(resultado);
		double resultadoRedondeo = Math.round(result * 10000.0) / 10000.0;
		writer.write("El resultado del fichero " + ficheroNombre.getName() + " es : "
				+ String.valueOf(resultadoRedondeo) + "\n");
		writer.close();
	}
}
