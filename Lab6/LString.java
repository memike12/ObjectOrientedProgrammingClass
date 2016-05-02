public class LString extends MString {

    /********************************************
     *This makes the character array lowercase.
     */
    private void toLower() {   
        for(int ii=0 ; ii < charArray.length; ii++) {
            if(Character.isUpperCase(charArray[ii]))
                charArray[ii] = Character.toLowerCase(charArray[ii]);
        }
    }

    /********************************************
     *This is the Constructor for LString. It takes a string.
     */
    public LString (String u) {
        super(u);
        toLower();
    }

    /********************************************
     *This is makes sure that all characters input by the user lower case.
     */ 
    public boolean setCharAt(int i, char c) {
        if(Character.isUpperCase(c)){
            c = Character.toLowerCase(c);
            return super.setCharAt( i , c);
        }
        else 
            return false;
    }
    
    /********************************************
     *This is the main function used for testing.
     */
    public static void main(String[] args) {     
        LString l = new LString("Ponies are pretty");
        System.out.println("LString: " + l);

        LString test1 = new LString("teSt oNe");
        System.out.println(test1);
        test1.setCharAt(0, 'T');
        System.out.println(test1);

        LString test2 = new LString("Backwards");
        test2.reverse();
        System.out.println(test2);
    }
}