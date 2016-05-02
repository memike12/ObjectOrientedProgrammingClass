import java.util.Scanner;
public class HW3{
 
  public static void main(String[] args){

    Scanner in = new Scanner(System.in);

    System.out.print("How many mids?");

    int numOfMids = in.nextInt();
    Mid[] midArray = new Mid[numOfMids];
    for (int ii = 0; ii < numOfMids; ii++){


      midArray[ii] = Mid.NewMid();
    }
  
    System.out.print("What company would you like to print out? ");
    int companyNum = in.nextInt();
    for (int ii = 0; ii < numOfMids; ii++){
      if (midArray[ii].company == companyNum)
	Mid.printMid(midArray[ii]);
    }
  
  }
}