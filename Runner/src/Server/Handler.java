package Server;


        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.io.OutputStream;
        import java.net.DatagramPacket;
        import java.net.DatagramSocket;
        import java.net.HttpURLConnection;
        import java.net.InetAddress;
        import java.net.InetSocketAddress;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.util.ArrayList;
        import java.util.Scanner;

        import com.sun.net.httpserver.HttpExchange;
        import com.sun.net.httpserver.HttpHandler;

public class Handler implements HttpHandler{


    public Handler(){
    	
    	
    }


    @Override
    public void handle(HttpExchange t) throws IOException {
    	System.out.println("Entered HANDLER");
    	InputStream is = t.getRequestBody();
    	
    	Scanner sc = new Scanner(is,"UTF-8").useDelimiter("\n");
    	String path = t.getRequestURI().getPath();
    	String response;
    	System.out.println(path);
    	if(path.endsWith("left"))
    		moveLeft();
    	if(path.endsWith("right"))
    		moveRight();
    
    }


	private void moveRight() {
		System.out.println("Right");
	}


	private void moveLeft() {
		System.out.println("Left");
		
	}
    
  

  

}
