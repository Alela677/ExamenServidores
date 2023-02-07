package psp.ud03.ejemplos.echoudp.servidor;

import java.io.File;
import java.io.IOException;
import java.util.List;

import psp.ud03.ejemplos.echoudp.Endpoint;
import psp.ud03.ejemplos.echoudp.Mensaje;
import utils.DesviacionTipica;
import utils.LeeFicheroNumeros;

public class HiloServidor extends Thread {

	private Endpoint servidor;

	public HiloServidor(Endpoint servidor) {
		this.servidor = servidor;
	}

	@Override
	public void run() {
		Mensaje mensaje;
		do {
			
			mensaje = servidor.recibir();
			String peticion = mensaje.getContent();
			File fichero = new File(peticion);
			
			if (fichero.exists()) {

				try {
					List<Double> listaNumeros = new LeeFicheroNumeros().leeficheronumeros(fichero);
					double resultado = new DesviacionTipica().calculateSD(convertiListaArray(listaNumeros));
					Mensaje respuestaServer = new Mensaje(mensaje.getHost(), mensaje.getPort(),
							String.valueOf(resultado));
					servidor.enviar(respuestaServer);

					System.out.println("Enviando");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} while (mensaje != null);

	}

	private double[] convertiListaArray(List<Double> lista) {

		double[] array = new double[lista.size()];

		for (int i = 0; i < array.length; i++) {

			array[i] = lista.get(i);
		}
		return array;
	}

}
