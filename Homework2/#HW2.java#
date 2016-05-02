import java.util.Scanner;

public class HW2{
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("How many integers will you enter? ");
    int x = in.nextInt();
    int[] numbers = new int[x];
    System.out.println("Please enter your integers: ");
    for(int y = 0; y < x; y++){
      numbers[y] = in.nextInt();
    }
    System.out.println("Now, please enter a String: ");
    String word = in.next();
    char[] charArray = word.toCharArray();
    int charArraylength = word.length();
 
    System.out.print("Your integers in reverse are: ");
    for(int y = x-1; y >=0; y--){
      System.out.print(numbers[y] + " ");
	}
    System.out.print("\n");
    System.out.print("Your String, with shffled-in spaces, is: ");
    for(int y = 0; y < charArraylength; y++){
      System.out.print(charArray[y] + " ");
	}
    System.out.print("\n");
  }
}