import java.util.*;
public class Lab1b {

  public static int factorial(int value) {
    if (value == 1){
      return 1;
    }
    else{
      int product = value * factorial(value-1);
      return product;
    }
  }
 
  public static int numerator(int value, int decValue, int secondValue) {
    
    if (decValue == value - secondValue +1){
      return decValue;
    }
    else{
      int product = decValue * numerator(value, decValue - 1, secondValue);
      return product;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Please enter your name ");
    String name = in.nextLine();
    System.out.print("Please input an integer ");
    int n = in.nextInt();
    System.out.print("Please input a second integer ");
    int k = in.nextInt();
    /*int numerator = 1;               This is the older version to find the numerator
    for ( int g = n;g>=n-k+1;g--){
      numerator = numerator*g;
    }
    int denominator = 1;              This is how I found the denominator
    for ( int h = k;h > 0;h--){
      denominator = denominator * h;
      }*/
    //System.out.println(denominator);    error checking
    int x = factorial(k);
    //System.out.println(x);              error checking
    //System.out.println(numerator);      error checking
    int y = numerator(n,n,k);
    //System.out.println(y);              error checking

    System.out.println("The lottery is " + y/x + ". Thanks for playing " + name + ".");
    

  }

}