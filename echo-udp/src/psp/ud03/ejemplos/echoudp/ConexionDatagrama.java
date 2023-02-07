package psp.ud03.ejemplos.echoudp;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConexionDatagrama {

	private static final int BUFFER_LEN = 2048;
	private DatagramSocket socket;

	public ConexionDatagrama(DatagramSocket socket) {
		this.socket = socket;
	}

	public void enviar(Mensaje mensaje) {
		try {
			byte[] mensajeBytes = mensaje.getContent().getBytes();

			DatagramPacket paquete = new DatagramPacket(mensajeBytes, mensajeBytes.length,
					InetAddress.getByName(mensaje.getHost()), mensaje.getPort());
			socket.send(paquete);
		} catch (Exception e) {
		}
	}

	public Mensaje recibir() {
		try {
			DatagramPacket paquete = new DatagramPacket(new byte[BUFFER_LEN], BUFFER_LEN);
			socket.receive(paquete);
			String mensaje = new String(paquete.getData(), paquete.getOffset(), paquete.getLength());

			return new Mensaje(paquete.getAddress().getHostAddress(), paquete.getPort(), mensaje);
		} catch (IOException e) {
			return null;
		}
	}

	public void cerrar() {
		socket.close();
	}

}
