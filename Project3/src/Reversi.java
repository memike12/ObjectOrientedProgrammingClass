import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;



public class Reversi {
		
	public static void main(String[] args) {	

		if (args[0].equals("-h")){
			System.out.println("Usage:");
			System.out.println("\tReversi -s <port>\tStarts the Server for a networked game on the requested port");
			System.out.println("\t\t\t\te.g. java Reversi -s 12300");
			System.out.println("\tReversi -c <IP> <port>  Connects as a Client to an existing game on the requested socket");
			System.out.println("\t\t\t\te.g. java Reversi -c 10.10.1.4 12300");
			System.out.println("\tReversi -h\t\tprints this usage");
		}
		
		
		
		
		/////Server
		if (args[0].equals("-s")){
			Reversi server = new Reversi();
			int port = 00000;
			if(args.length != 2){
	        	System.out.println("Please enter the server flag then a port number.");
	        	System.exit(-1);
	        }
	        try{
	            port = Integer.parseInt(args[1]);
	        }
	        catch(NumberFormatException nfm){
	            System.out.println("Please enter the port as a number.");
	            System.exit(-1);
	        }
			try{
				
				server.listen(port);
			}
			catch(IOException IOE){
				System.out.println("The server isn't listening.");
			}
		}
		
		
		
		////Client
		if (args[0].equals("-c")){
			Reversi client = new Reversi();
			String ip = null;
			int port = 00000;
			if(args.length != 3){
		        	System.out.println("Please enter the client flag then an IP address followed by a port number.");
		        	System.exit(-1);
		        }
	        try{
	        	ip = args[1];
	            port = Integer.parseInt(args[2]);
	        }
	        catch(ArrayIndexOutOfBoundsException aiobe)
	        {
	        	System.out.println("Please enter an IP address followed by a port number.");
	        	System.exit(-1);
	        }
	        catch(NumberFormatException nfm)
	        {
	        	System.out.println("Please enter the port number as an integer.");
	        	System.exit(-1);
	        }
	                
	        client.connect(ip, port);
		}
		
		
		
		
	}

	private void connect(String ip, int port) {
		// TODO Auto-generated method stub
		boolean endOfGame = false;
		try {
			Socket client = new Socket(ip, port);
			System.out.println("Game started. You are the Black player. It is Black's turn.");
			boolean clientsTurn = true;
			Scanner socketIn = new Scanner(client.getInputStream());
			PrintWriter toServer = new PrintWriter(client.getOutputStream(), true); 
			Scanner keyboardIn = new Scanner(System.in);
			Board b = new Board();
			System.out.println(b);
			while(!endOfGame)
			{
				if(clientsTurn){
					//get move from the user
					System.out.println("It's Black's turn! Please enter a move.");
					String clientsMove = keyboardIn.nextLine();
										
					//send move to the server
					toServer.println(clientsMove);
					if(clientsMove.equals("/quit")){
						client.close();
						socketIn.close();
						toServer.close();
						keyboardIn.close();
						System.exit(0);
					}
					String accepted = socketIn.next();
					while(!accepted.equals("1")){
						System.out.println("Please enter a letter a-h followed by a number 1-8");
						clientsMove = keyboardIn.nextLine();
						toServer.println(clientsMove);
						if(clientsMove.equals("/quit")){
							client.close();
							socketIn.close();
							toServer.close();
							keyboardIn.close();
							System.exit(0);
						}
						accepted = socketIn.next();
					}
					System.out.println(b);
					System.out.println("Your's move: " + clientsMove);
					clientsTurn = false;
				}
				if(!clientsTurn){
					System.out.println("It's white's turn. Please wait.");
					String serversMove = socketIn.next();
					if(serversMove.equals("/quit")){
						client.close();
						socketIn.close();
						toServer.close();
						keyboardIn.close();
						System.exit(0);
					}
					System.out.println(b);
					System.out.println("White's move: " + serversMove);
					clientsTurn = true;
				}
				
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

	private void listen(int port) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket svr = new ServerSocket(port);
		while(true) {
            //  Wait for a client to connect
            Socket client = svr.accept();
            PrintWriter toClient = new PrintWriter(client.getOutputStream(), true);            
            Scanner fromClient = new Scanner(client.getInputStream());
            Scanner keyboardIn = new Scanner(System.in);
            boolean endOfGame = false;
            boolean serversTurn = false;
            Board b = new Board();
            System.out.println(b);
            System.out.println("Game started. You are the White player. It is Black's turn.");
            while(!endOfGame){
	            if(serversTurn){
	            	System.out.println("It's White's turn! Please enter a move.");
					//get move from the user
					String serversMove = keyboardIn.next();
					if(serversMove.equals("/quit")){
						toClient.println(serversMove);
						client.close();
						fromClient.close();
						keyboardIn.close();
						svr.close();
						System.exit(0);
					}
					while(!(serversMove.charAt(0)=='a' || serversMove.charAt(0)=='b' || serversMove.charAt(0)=='c' 
							|| serversMove.charAt(0)=='d' || serversMove.charAt(0)=='e' || serversMove.charAt(0)=='f' || serversMove.charAt(0)=='g' || 
							serversMove.charAt(0)=='h' ||serversMove.charAt(0)=='A' || serversMove.charAt(0)=='B' || serversMove.charAt(0)=='C' 
							|| serversMove.charAt(0)=='D' || serversMove.charAt(0)=='E' || serversMove.charAt(0)=='F' || serversMove.charAt(0)=='G' || 
							serversMove.charAt(0)=='H') || (!(serversMove.charAt(1)=='1' || serversMove.charAt(1)=='2' || serversMove.charAt(1)=='3' 
							|| serversMove.charAt(1)=='4' || serversMove.charAt(1)=='5' || serversMove.charAt(1)=='6' || serversMove.charAt(1)=='7' || 
							serversMove.charAt(1)=='8')) || serversMove.length()!=2 ){
						System.out.println("Please enter a letter a-h followed by a number 1-8");
						serversMove = keyboardIn.next();
						if(serversMove.equals("/quit")){
							toClient.println(serversMove);
							client.close();
							fromClient.close();
							keyboardIn.close();
							svr.close();
							System.exit(0);
						}
					}
					//send move to the server
					toClient.println(serversMove);
					System.out.println(b);
					System.out.println("Your move: " + serversMove);
					serversTurn = false;
				}
				if(!serversTurn){
					System.out.println("It's Black's turn. Please wait.");
					String clientsMove = fromClient.next();
					if(clientsMove.equals("/quit")){
						client.close();
						fromClient.close();
						keyboardIn.close();
						svr.close();
						System.exit(0);
					}
					String accept = "0";
					while(!(clientsMove.charAt(0)=='a' || clientsMove.charAt(0)=='b' || clientsMove.charAt(0)=='c' 
								|| clientsMove.charAt(0)=='d' || clientsMove.charAt(0)=='e' || clientsMove.charAt(0)=='f' || clientsMove.charAt(0)=='g' || 
								clientsMove.charAt(0)=='h' ||clientsMove.charAt(0)=='A' || clientsMove.charAt(0)=='B' || clientsMove.charAt(0)=='C' 
								|| clientsMove.charAt(0)=='D' || clientsMove.charAt(0)=='E' || clientsMove.charAt(0)=='F' || clientsMove.charAt(0)=='G' || 
								clientsMove.charAt(0)=='H') || (!(clientsMove.charAt(1)=='1' || clientsMove.charAt(1)=='2' || clientsMove.charAt(1)=='3' 
								|| clientsMove.charAt(1)=='4' || clientsMove.charAt(1)=='5' || clientsMove.charAt(1)=='6' || clientsMove.charAt(1)=='7' || 
								clientsMove.charAt(1)=='8')) || clientsMove.length()!=2 ){
						if(clientsMove.equals("/quit")){
							client.close();
							fromClient.close();
							keyboardIn.close();
							svr.close();
							System.exit(0);
						}
						toClient.println(accept);
						clientsMove = fromClient.next();
					}
					accept = "1";
					toClient.println(accept);
					System.out.println(b);
					System.out.println("Black's move: " + clientsMove);
					serversTurn = true;
				}
            }
		
		}
		//svr.close();
    }
	       
}
