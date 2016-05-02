public class MString extends ICString{

    /********************************************
     *This is the Constructor for MString. It takes a string.
     */
    public MString (String s) {
        super(s);
    }

    /********************************************
     *This is makes sure that all characters input by the user are in the array
     */
    public boolean setCharAt(int i, char c) {
        if (i > this.length()-1 || i < 0)
            return false;
        else {
            charArray[i]= c;
            return true;
        }
    }

     /********************************************
     *This is a static test used for testing.
     */
    public static String staticTest = "set from MString";

    /********************************************
     *This reverses the character array
     */
    public void reverse() {
        for(int ii = 0; ii < charArray.length / 2; ii++){
            char temp = charArray[ii];
            charArray[ii] = charArray[charArray.length - ii - 1];
            charArray[charArray.length - ii - 1] = temp;
        }
    }

    /********************************************
     *This is the main function used for testing.
     */
    public static void main(String[] args) {     
        MString m = new MString("Tests");
        System.out.println("MString: " + m);
        System.out.println("length:   " + m.length());
        char p = 'p';
        m.setCharAt(0, p);
        System.out.println("New MString is: " + m); 
    }
}       