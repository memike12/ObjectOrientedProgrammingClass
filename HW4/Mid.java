import java.util.Scanner;
public class Mid {
     public String alpha;
     public String firstName;
     public String lastName;
     public int company;

public Mid(){
    alpha = "123456";
    firstName = "null";
    lastName = "null";
    company = 0;
}

public Mid NewMid(){
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

public void printMid(Mid midToPrint){
    System.out.print(midToPrint.alpha + " " + midToPrint.firstName + " " +  midToPrint.lastName + " " +  midToPrint.company + "\n");
  }

public boolean isInCompany(int c){
        if (Mid.company == c){
            return true;
        }
        else{
            return false;
        }

    }

 }