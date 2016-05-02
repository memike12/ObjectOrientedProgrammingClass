import java.util.Scanner;
public class HW3{
  public static Mid createMid(){
    Scanner in = new Scanner(System.in);
    Mid newMid = new Mid();
    System.out.print("Alpha? ");
    newMid.alpha = in.nextLine();

    System.out.print("First name? ");
    newMid.firstName = in.nextLine();

    System.out.print("Last name? ");
    newMid.lastName = in.nextLine();

    System.out.print("Company? ");
    newMid.company = in.nextInt();

    return newMid;

  }

  public static void printMid(Mid midToPrint){
    System.out.print(midToPrint.alpha + " " + midToPrint.firstName + " " +  midToPrint.lastName + " " +  midToPrint.company + "\n");
  }

  public static void main(String[] args){

    Scanner in = new Scanner(System.in);

    System.out.print("How many mids?");

    int numOfMids = in.nextInt();
    Mid[] midArray = new Mid[numOfMids];
    for (int ii = 0; ii < numOfMids; ii++){
      midArray[ii] = createMid();
    }
  
    System.out.print("What company would you like to print out? ");
    int companyNum = in.nextInt();
    for (int ii = 0; ii < numOfMids; ii++){
      if (midArray[ii].company == companyNum)
	printMid(midArray[ii]);
    }
  
  }
}