package psp.ud03.ejemplos.echoudp;

public class ConexionException extends RuntimeException {
  public ConexionException(Exception e) {
    super(e);
  }
  
  public ConexionException(String msg) {
    super(msg);
  }
}
