package psp.ud03.ejemplos.echoudp.servidor;

import psp.ud03.ejemplos.echoudp.Endpoint;
import psp.ud03.ejemplos.echoudp.Mensaje;
import psp.ud3.ejemplos.propiedades.LeeFicheroPropiedades;

public class ServidorEchoApp {

	private static final int DEFAULT_PORT = 2222;
	private static final String ERROR_MSG = "El nombre no se encuentra";

	public static void main(String[] args) {
		// Si se pasa el puerto, lo toma, si no toma el puerto por defecto
		String portString = (args.length > 0) ? args[0] : Integer.toString(DEFAULT_PORT);
		// Se intenta convertir el puerto a entero. Si no se puede se termina con error
		LeeFicheroPropiedades leer = new LeeFicheroPropiedades();
		try {

			int port = Integer.parseInt(portString);
			// Creamos el servidor con el puerto
			Endpoint servidor = new Endpoint(port);

			// Esperamos conexiones una detrás de otra (Si se produce un error, se termina)
			Mensaje peticion;
			while ((peticion = servidor.recibir()) != null) {

				String ip = leer.consultarPropiedades(peticion.getContent());
				if (ip != null) {

					Mensaje mensajeIp = new Mensaje(peticion.getHost(), peticion.getPort(), ip);
					servidor.enviar(mensajeIp);
				} else {

					Mensaje mensajeError = new Mensaje(peticion.getHost(), peticion.getPort(), ERROR_MSG);
					servidor.enviar(mensajeError);
				}
			}
		} catch (NumberFormatException e) {
			System.err.println("El puerto proporcionado no es válido");
			return;
		}

	}

}
