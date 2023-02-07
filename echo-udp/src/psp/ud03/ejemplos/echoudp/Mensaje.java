package psp.ud03.ejemplos.echoudp;

import java.util.List;

public class Mensaje {
  
  private String host;
  private int port;
  private String content;
  
  public Mensaje(String host, int port, String content) {
    this.host = host;
    this.port = port;
    this.content = content;
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
