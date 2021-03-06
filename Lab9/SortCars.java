import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.Serializable;
public class SortCars implements Comparable {

    public SortCars(){};

    public void readFile(String str) throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        try{
            Scanner fin = new Scanner(new File(str));
            while(fin.hasNext()){
                String word = fin.next();
            }
        }
        catch (Exception fnfe) {
            throw new FileNotFoundException();
        }
                
    }

    public ArrayList sortCars(ArrayList cars){
        Collections.sort(cars);
        return cars;
    }

    public static void main(String [] args){
        SortCars cars = new SortCars();
        String str;
        try{
            str = args[0];
        }
        catch (Exception e){
            System.out.println("You didn't give me a file!");
            return;
        }
        try{
            cars.readFile(str);
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("I did not find the file " + str);
            return;
           
        }
        // Writing an array (cars) to file, serialized.
        try{
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("sorted.obj"));
            output.writeObject(cars);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Reading serial data from a file to an array of Cars.
        Car[] carsFromFile = new Car[5];
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("sorted.obj"));
            carsFromFile = (Car[])(input.readObject());
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}