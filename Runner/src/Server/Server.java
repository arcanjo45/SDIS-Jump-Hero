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

import GUI.Game;



public class Server {

    private HttpServer server;

     public Server(Game game) throws Exception {
		server = HttpServer.create(new InetSocketAddress(8000), 0);
		//server.setHttpsConfigurator(new HttpsConfigurator(createSSLContext()));
		server.createContext("/api", new Handler(game));
		server.setExecutor(null);
		
	}

    public void start()
    {
        server.start();
    }

}
