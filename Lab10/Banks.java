import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.InterruptedException;

public class Banks{

    /***********
     * This is the main method of Banks. It searches for the command line arguments, opens
     * a thread for every argument, runs the threads, then prints out the account balances
     *********/
    public static void main(String [] args){
        int fileCount = args.length;
        BankThread[] bt = new BankThread[fileCount];
        Accounts acc = new Accounts();

        for(int i = 0; i < fileCount; i++){
            bt[i] = new BankThread(args[i], acc);
            bt[i].start();
        }

        try{
            for(int i = 0; i < fileCount; i++){
                bt[i].join();
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println("ACCOUNT BALANCES");
        acc.printBalances();
        return;
    }
}