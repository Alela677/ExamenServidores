package psp.ud03.ejemplos.echoudp;

import java.net.DatagramSocket;

public class Endpoint {

	private ConexionDatagrama conexion;

	public Endpoint(int port) {
		try {
			this.conexion = new ConexionDatagrama(new DatagramSocket(port));
		} catch (Exception e) {
			throw new ConexionException(e);
		}
	}

	public Endpoint() {
		// TODO Auto-generated constructor stub
	}

	public void enviar(Mensaje msg) {
		conexion.enviar(msg);
	}

	public Mensaje recibir() {
		return conexion.recibir();
	}

	public void cerrar() {
		conexion.cerrar();
	}

}
