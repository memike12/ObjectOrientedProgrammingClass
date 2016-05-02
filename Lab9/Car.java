import java.util.*;
import java.io.*;

public class Car implements Comparable, Serializable {
    public String make;
    public int year;
    public double cost;

    /*************
     *This is the Constructor for the Car Class. It takes a string, int, and double and then assigns them to the class. 
     ***************/
    public Car(String newMake, int newYear, double newCost) {
        make = newMake;
        year = newYear;
        cost = newCost;
    }
    
    /*************
     *This returns the car object in the form of a string that is easy to read. 
     ***************/
    public String toStiring(){
        String s = year + "\t" + make + ",\t" + "$" +cost;
    }

    /*************
     *This method takes an object and compaires it to another object. 
     ***************/
    public int compareTo(Car o) {
        if (this <= o)
            return -1;
        else if (this == o )
            return 0;
        else 
            return 1;
    }

     
}