import java.io.IOException;
import java.net.Socket;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileClient {

    public void connect(String ip, int port, String data) {
        try{
            // (1) Open Socket to server
            Socket client = new Socket(ip, port);

            // (2) Create an object to write data to the socket
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);            

            // (3) Create a Scanner to read from the socket
            Scanner in = new Scanner(client.getInputStream());

            // (4) Send out data to the server
            //out.println(data);

            // Receive the file list from the server
            String fileList = in.nextLine();
            
            // Prints the file list and asks for input
            System.out.println("Please select a file from this list:" + fileList);
            
            // Open a scanner for the user to select a file
            Scanner usrIn = new Scanner(System.in);
            String fileName = usrIn.nextLine();
            
            // Send file selection to the server
            out.println(fileName);
            
            // Client then waits for the file
            String file;
            file = in.nextLine();
            
            if(file.charAt(0) == '1')
            {
            	
            	PrintWriter pw = null;
                try {
                  pw = new PrintWriter(new File(fileName));
                  pw.print(file.substring(1));
                } catch (FileNotFoundException fnfe) {
                  fnfe.printStackTrace();
                } finally {
                  pw.close();
                }
            }
            else{
            	System.out.println("File did not exist.");
            	System.exit(-1);
            }

            // Close all the things we opened
            client.close();
            in.close();
            usrIn.close();
            
        } catch (IOException e) {
            System.out.println("Could not connect on port " + port);
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        FileClient uc = new FileClient();
        String ip ="";
        int port = 0;
        if(args.length > 2){
        	System.out.println("Please enter an IP address followed by a port number.");
        	System.exit(-1);
        }
        try{
        	ip = args[0];
        	port = Integer.parseInt(args[1]);
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
        
        uc.connect(ip, port, "This is a test");
        System.out.println("Client is done.");
    }

	
}