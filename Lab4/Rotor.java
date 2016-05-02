import static java.lang.System.out;
public class Rotor {
    public String rotorString ="#ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public char first = '#';

    /**
     *Constructor
     */
    public Rotor(String input){
        rotorString = input;
        first = rotorString.charAt(0);
    }
    public char firstChar(){
        return first;
    }
    public void rotate(){
        
        char[] sentRotor=rotorString.toCharArray();
        
        char[] rotatedRotor = new char [27];
        rotatedRotor[0]=sentRotor[sentRotor.length-1];
        for (int ii=0; ii<sentRotor.length-1;ii++){
            
            rotatedRotor[ii+1]=sentRotor[ii];
        }
       
        rotorString= new String (rotatedRotor);
       
        return;
    }
}