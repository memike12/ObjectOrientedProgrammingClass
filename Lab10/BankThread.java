import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class BankThread extends Thread{
    private Scanner fin;
    private Accounts acc;

    /***********
     * This is the constructor and it accepts a string for the file it opens and an Accounts object 
     * to work with;
     *********/
    public BankThread(String file, Accounts acc){
        try{
            fin = new Scanner(new File(file));
        }
        catch (FileNotFoundException fnfe){
            System.out.println("I cant open file " + file + "!");
            return;
        }
        this.acc = acc;
    }


     /***********
     * This is the main method of the thread and where all the work is done.
     *********/
    public void run(){
        while(fin.hasNextLine()){
            String[] part = fin.nextLine().split(" ");
            double transAmt = Double.parseDouble(part[2]);
            int accNum = Integer.parseInt(part[1]);
            if (part[0].equals("deposit")){
                acc.deposit(accNum, transAmt);
            }
            else
                acc.withdraw(accNum, transAmt);
        }
    }

}