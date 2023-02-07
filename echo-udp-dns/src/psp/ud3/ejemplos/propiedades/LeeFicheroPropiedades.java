package psp.ud3.ejemplos.propiedades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import psp.ud03.ejemplos.echoudp.Mensaje;

public class LeeFicheroPropiedades {

	private static Map<String, String> mapaPropiedades = new HashMap<>();
	private static Properties propiedades = new Properties();
	private static InputStream leerFichero;

	final static String FICHERO_PROP = "properties/dns.properties";
	final static String EQUIPO = "equipo1";
	final static String SERVIDOR = "servidor";
	final static String ROUTER = "router";
	final static String ROUTER_DEFAULT = "192.292.212.212";

	private String equipo;
	private String router;
	private String servidor;

	public LeeFicheroPropiedades() {

		try {
			leerFichero = new FileInputStream(FICHERO_PROP);
			propiedades.load(leerFichero);
			try {
				router = propiedades.getProperty(ROUTER, ROUTER_DEFAULT);
				if (router.length() == 0) {
					router = ROUTER_DEFAULT;
				}
			} catch (Exception e) {
				router = ROUTER_DEFAULT;
			}
			equipo = propiedades.getProperty(EQUIPO);
			servidor = propiedades.getProperty(SERVIDOR);

			mapaPropiedades.put(EQUIPO, equipo);
			mapaPropiedades.put(SERVIDOR, servidor);
			mapaPropiedades.put(ROUTER, router);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String consultarPropiedades(String clave) {
		String resultado = null;
		try {
			leerFichero = new FileInputStream(FICHERO_PROP);
			propiedades.load(leerFichero);

			resultado = mapaPropiedades.get(clave);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultado;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public String getRouter() {
		return router;
	}

	public void setRouter(String router) {
		this.router = router;
	}

	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

}
