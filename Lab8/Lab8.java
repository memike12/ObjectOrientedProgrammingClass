import java.util.Scanner;
import java.io.File;

public class Lab8 {
    public Lab8(){};


    public int stringToInteger(String str) throws NotAnIntException{
        int result;
        try{
            result = Integer.parseInt(str);
        }
        catch(Exception e){
            throw new NotAnIntException();
        }
        return result;
    }

    public float stringToFloat(String str) throws NotAFloatException{
        float result;
        try{
            result = Float.parseFloat(str);
        }
        catch(Exception e){  
            throw new NotAFloatException();
        }
        return result;
    }

    public void readFile(String str) throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        Lab8 disLab = new Lab8();
        try{
            Scanner fin = new Scanner(new File(str));
            while(fin.hasNext()){
                String word = fin.next();
                try{
                    float fl = disLab.stringToInteger(word);
                    System.out.println("INT:\t" + word);
                }
                catch (NotAnIntException naie){
                    //System.out.println("STRING:\t" + word);
                    try{
                        float num = disLab.stringToFloat(word);
                        System.out.println("FLOAT:\t" + word);
                    }
                    catch (NotAFloatException  nafe){
                        System.out.println("STRING:\t" + word);
                    }
                    //System.out.println("FLOAT:\t" + word);
                }
                //System.out.println("INT:\t" + word); 
            }
        }
        catch (Exception fnfe) {
            throw new FileNotFoundException();
        }
                
    }

    public static void main(String[] args) {
        Lab8 disLab = new Lab8();
        String str;
        try{
            str = args[0];
        }
        catch (Exception e){
            System.out.println("You didn't give me a file!");
            return;
        }
        try{
            disLab.readFile(str);
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("I did not find the file " + str);
            return;
        }
        
        /*Scanner in = new Scanner(new File(str));
        while(in.hasNext()){
            String word = in.next();
            try{
                float fl = disLab.stringToFloat(word);
            }
            catch (NotAFloatException nafe){
                System.out.println("STRING: /t" + word);
            }
            try{
                int num = disLab.stringToInteger(word);
            }
            catch (NotAnIntException naie){
                System.out.println("FLOAT: /t" + word);
            }
            System.out.println("INT: /t" + word);
            }*/
    }
}

    
