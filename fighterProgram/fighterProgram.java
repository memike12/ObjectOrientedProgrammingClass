import java.util.Scanner;
import java.util.*;
public class fighterProgram{
    
    public static String[] getFighters(){
        Scanner in = new Scanner(System.in);
	System.out.print("How many fighters?");
        int fighters = in.nextInt();
        String [] arr = new String[fighters];
	return arr;
    }


    public static String[] makeMatch(String[] old){
        int rando1 = (int)(Math.random() * ((old.length-1) + 1));
        int rando2 = (int)(Math.random() * ((old.length-1) + 1));  
        while(rando2 == rando1){
            rando2 = (int)(Math.random() * ((old.length-1) + 1)); 
        }
        System.out.println("The random match up is " +  rando1 + " vs. " + rando2);

        old = old[ran
        String[] newArr = old;
    
        return newArr;        
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
	String[] arr = getFighters();
	System.out.println("Enter the contestants.");
	for( int x = 0; x<arr.length; x++){
	    arr[x]=in.next();
	}
        
        while(arr.length>0){
            arr = makeMatch(arr);
        }
    }


}