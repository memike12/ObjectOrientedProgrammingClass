import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FileClient {
	final static FileClient uc = new FileClient();
	static String ip ="";
    static int port = 0;
    static JTextField textField=new JTextField("Please press the connect button.");
    static String fileList;
    static JPanel myPanel=new JPanel(new BorderLayout());
    static JFrame window = new JFrame(ip + ":" + port);
    static String fileName;
    Socket client ;
    static PrintWriter out ;     
    Scanner in;
    static JTextField fileField;
    static JButton button;
    static JButton updateButton;
    static int update = 0;
    
    public void reconnect() throws IOException {
    	
    	//tells the server I want a file
    	out.println("1");
    	//tells the server what file I want
    	out.println(fileName);
        
        // Client then waits for the file
        String file;
        file = in.nextLine();
        
        if(file.charAt(0) == '1')
        {
        	
        	PrintWriter pw = null;
            try {
              pw = new PrintWriter(new File(fileName));
              //System.out.println(file.substring(1));
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

        client.close();
        in.close();
    	
    }
    
    public void update(){
    	if(update == 1){
    	try{
    		client = new Socket(ip, port);
    		out = new PrintWriter(client.getOutputStream(), true);  
    		in = new Scanner(client.getInputStream());
	    		
	        // Receive the file list from the server
	        fileList = in.nextLine();
	        textField.setText("Newest " + fileList);
	        
	    }
	    catch(IOException e) {
	    	System.out.println("Could not connect on port " + port);
	        System.exit(-1);
	    }
    	}
    }
    
    public void connect() {
        try{
            // (1) Open Socket to server
            client = new Socket(ip, port);
            update = 0;
            // (2) Create an object to write data to the socket
            out = new PrintWriter(client.getOutputStream(), true);            

            // (3) Create a Scanner to read from the socket
            in = new Scanner(client.getInputStream());

            // Receive the file list from the server
            fileList = in.nextLine();
           
        } catch (IOException e) {
            System.out.println("Could not connect on port " + port);
            System.exit(-1);
        }
    }

    public static class ButtonAdapter3 extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            uc.update();
            update = 0;
            //myPanel.remove(updateButton);
            window.add(myPanel);
        }
    }
    
    public static class ButtonAdapter extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            uc.connect();
            ((JButton)e.getComponent()).setText("Connected to the server");
            //System.out.println(fileList);
            
            textField.setText(fileList);
            JButton fileButton=new JButton("Get File");
            fileButton.addMouseListener(new ButtonAdapter2());
            myPanel.add(fileButton, BorderLayout.EAST);
            
            updateButton=new JButton("Update File List");
            updateButton.addMouseListener(new ButtonAdapter3());
            myPanel.add(updateButton, BorderLayout.CENTER);
            
            fileField=new JTextField("type file here");
            myPanel.add(fileField, BorderLayout.WEST);
           
            myPanel.remove(button);
            //myPanel.remove(updateButton);
            //window = new JFrame(ip + ":" + port);
            window.add(myPanel);
        }
    }
    
    public static class ButtonAdapter2 extends MouseAdapter {
    	public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            try {
            	updateButton=new JButton("Update Files");
                updateButton.addMouseListener(new ButtonAdapter3());
                myPanel.add(updateButton, BorderLayout.CENTER);
            	update = 1;
            	fileName = fileField.getText();
            	
				uc.reconnect();
				textField.setText("Downloaded file!");
				//window = new JFrame(ip + ":" + port);
				window.add(myPanel);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				out.println("0");
				System.exit(-1);
			}
    	}
    }
            
    public void gui(){
    	button=new JButton("Connect");
    	button.addMouseListener(new ButtonAdapter());
    	
        myPanel.add(textField,BorderLayout.SOUTH);
        myPanel.add(button, BorderLayout.NORTH);

        window = new JFrame(ip + ":" + port);
        window.add(myPanel);
        window.setSize(500, 200);
        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
            	out.println("0");
                System.exit(0);
            }
        });
        window.setVisible(true);
    
    }
    
    public static void main(String[] args) {
    	
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
        uc.gui();
    }
}