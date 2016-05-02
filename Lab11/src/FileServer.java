import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileServer {

    public void listen(int port) {
        try{
            // (1) Create a ServerSocket to listen on a port
            ServerSocket svr = new ServerSocket(port);

            while(true) {
                // (2) Wait for a client to connect
            	System.out.println("Listening over: " + port);
                Socket client = svr.accept();
                System.out.println("Connected over: " + port);
                //Prints out all the files in the directory
                File folder = new File("./docs/");
                File[] listOfFiles = folder.listFiles();
                String fileName = "";
                
                // (3) Create an object to write data to the socket
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);            

                // (3) Create a Scanner to read from the socket
                Scanner in = new Scanner(client.getInputStream());

                // Goes through the file tree and makes a list of files
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile()) {
                        fileName = fileName + listOfFiles[i].getName() + " ";
                    }
                }
                
                // Sends the client the list of files
                out.println(fileName);
                
                // Listens for the clients response
                String datain = in.next();
                               
                String file ="";
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile()) {
                    	if( listOfFiles[i].getName().equals(datain))
                            {
                                try{
                                	
                                	File nfile = new File("./docs/" + datain);
                                    Scanner fin = new Scanner(nfile);
                                    while (fin.hasNextLine()){
                                        file = file + fin.nextLine();
                                    }
                                    System.out.println(file);
                                    out.println('1' + file);
                                }
                                catch(FileNotFoundException fnfe){
                                    System.out.println("File does not exist");
                                    fnfe.printStackTrace(System.out);
                                    out.println('0');
                                }
                			
                            }
                		
                    }
                }
                
                // (7) Close client and wait for next connection
                client.close();
                in.close();
            }
            //svr.close();
            //in.close();
			
        } catch (IOException e) {
            System.out.println("Could not listen on port " + port);
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        FileServer us = new FileServer();
        int port = 00000;
        try{
            port = Integer.parseInt(args[0]);
        }
        catch(NumberFormatException nfm){
            System.out.println("Please enter the port as a number.");
            System.exit(-1);
        }
        //System.out.println(port);
        us.listen(port);
        System.out.println("Server is done.");
    }
}