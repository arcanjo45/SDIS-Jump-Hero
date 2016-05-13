package Server;

/**
 * Created by Pedro on 13/05/2016.
 */

import java.io.IOException;
import java.net.InetSocketAddress;
public class Main {

    static public void main (String[] argr) throws IOException{

        System.out.println("entered main");
        Server server = new Server(new InetSocketAddress(9001));
        server.start();

    }
}
