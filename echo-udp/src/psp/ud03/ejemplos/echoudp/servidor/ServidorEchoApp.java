package psp.ud03.ejemplos.echoudp.servidor;

import psp.ud03.ejemplos.echoudp.Endpoint;
import psp.ud03.ejemplos.echoudp.Mensaje;
import utils.DesviacionTipica;

public class ServidorEchoApp {

	private static final int DEFAULT_PORT = 1234;

	public static void main(String[] args) throws InterruptedException {
		// Si se pasa el puerto, lo toma, si no toma el puerto por defecto
		String portString = (args.length > 0) ? args[0] : Integer.toString(DEFAULT_PORT);
		// Se intenta convertir el puerto a entero. Si no se puede se termina con error
		System.out.println("Iniciando servidor");
		try {
			int port = Integer.parseInt(portString);
			// Creamos el servidor con el puerto
			Endpoint servidor = new Endpoint(port);
			
//			Mensaje mensaje;
//			// Esperamos conexiones una detrás de otra (Si se produce un error, se termina)
//			while ((mensaje = servidor.recibir()) != null) {
				
				HiloServidor nuevohilo = new HiloServidor(servidor);
				nuevohilo.start();
//			}

		} catch (NumberFormatException e) {
			System.err.println("El puerto proporcionado no es válido");
			return;
		}

	}

}
