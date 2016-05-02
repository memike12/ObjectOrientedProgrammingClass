import java.util.*;
public class Lab1c {
  public static void main(String[] args) {
    Random rand = new Random(System.currentTimeMillis());
    Scanner in = new Scanner(System.in);
    int randomInt = rand.nextInt(10);
    System.out.print("Please guess an integer ");
    int n = in.nextInt();
    while (n != randomInt){
      System.out.print("That wasn't even close. Guess again! ");
      n = in.nextInt();
    }
    System.out.println("Wow you actually won!");

    }

  }
