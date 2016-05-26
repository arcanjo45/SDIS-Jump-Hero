package Server;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.util.ArrayList;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsServer;


public class Server {

    private InetSocketAddress port;



    private HttpsServer server;


     Server() throws Exception {
		server = HttpsServer.create(new InetSocketAddress(443), 0);
		server.setHttpsConfigurator(new HttpsConfigurator(createSSLContext()));
		server.createContext("/api", new Handler());
		server.setExecutor(null);
		
	}
	
	private static SSLContext createSSLContext() throws Exception {
		SSLContext sslContext = SSLContext.getInstance("TLS");
	    char[] keystorePassword = "123456".toCharArray();
	    KeyStore ks = KeyStore.getInstance("JKS");
	    ks.load(new FileInputStream("assets/server.keys"), keystorePassword);
	    KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
	    kmf.init(ks, keystorePassword);
	    sslContext.init(kmf.getKeyManagers(), null, null);
	    return sslContext;
    }

    public void start()
    {
        server.start();
    }

    public InetSocketAddress getPort()
    {
        return port;
    }

    public void setPort(InetSocketAddress port)
    {
        this.port = port;
    }

}
