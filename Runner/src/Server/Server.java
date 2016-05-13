package Server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpServer;


/**
 * Created by Pedro on 13/05/2016.
 */
public class Server {

    private InetSocketAddress port;

    //private Handler myhandler;

    private ArrayList<InetAddress>contributors;

    private HttpServer server;

    static public int counter = 2;

    public Server(InetSocketAddress port ) throws IOException{

        contributors = new ArrayList<InetAddress>();

        System.out.println("started server");
        //myhanlder = new Handler(this);

        server = HttpServer.create(port,0);

        //server.createContext("x",myhandler),

        server.setExecutor(null); // creates a default executor




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
/*
    public Handler getMyHandler()
    {
        return myhandler;
    }

    public void setMyHandler(Handler myHandler) {
		this.myHandler = myHandler;
	}
*/

    public ArrayList<InetAddress> getContributors() {
        return contributors;
    }

    public void setContributors(ArrayList<InetAddress> contributors) {
        this.contributors = contributors;
    }
}
