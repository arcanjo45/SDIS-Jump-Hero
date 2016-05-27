package Server;


		import GUI.*;
		import java.io.*;
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

import org.hamcrest.core.SubstringMatcher;

import com.sun.net.httpserver.HttpExchange;
        import com.sun.net.httpserver.HttpHandler;


public class Handler implements HttpHandler{
	Game game;
    public Handler(Game game){
    	this.game = game;
    }


    @Override
    public void handle(HttpExchange t) throws IOException {
    	System.out.println("Entered HANDLER");
    	InputStream is = t.getRequestBody();
    	String response = "This is the response";

    	String path = t.getRequestURI().getPath();
    	System.out.println(path);
    	String newPath;
    	int playerNum=0;
    	
    	if(path.endsWith("left")){
				System.out.println("PATH: "+ path);

    			newPath = path.substring(0,path.length()-5);
    			System.out.println("NEW_PATH: "+ newPath);
    			newPath = newPath.substring(newPath.length()-1);
    			System.out.println("NEW_PATH2: "+ newPath);
    			playerNum=Integer.parseInt(newPath);
    			moveLeft(playerNum-1);
    			}
    	if(path.endsWith("right")){
    		newPath = path.substring(0,path.length()-6);
    		newPath = newPath.substring(newPath.length()-1);
    		playerNum=Integer.parseInt(newPath);
    		moveRight(playerNum-1);}
    	if(path.endsWith("connect"))
    		response = connect();
    	
    	
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    
    }


	private void moveRight(int index) {
		game.getListPlayers().get(index).setVelX(2);;
		System.out.println("Right");
	}


	private void moveLeft(int index) {
		game.getListPlayers().get(index).setVelX(-2);;
		System.out.println("Left");
		
	}
	
	public String connect(){
		
		int numPlayer = game.getListPlayers().size()+1;
		game.startPlayer();
		System.out.println("NewPlayer: "+numPlayer);
		return Integer.toString(numPlayer);
		
	}
    
 

}
