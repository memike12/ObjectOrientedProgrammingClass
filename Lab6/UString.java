public class UString extends MString {
    
    /********************************************
     *This makes the character array uppercase.
     */
    private void toUpper() {   
        for(int ii=0 ; ii < charArray.length; ii++) {
            if(Character.isLowerCase(charArray[ii]))
                charArray[ii] = Character.toUpperCase(charArray[ii]);
        }
    }
    
     /********************************************
     *This is the Constructor for UString. It takes a string.
     */
    public UString (String u) {
        super(u);
        toUpper();
    }

    /********************************************
     *This is makes sure that all characters input by the user upper case.
     */ 
    public boolean setCharAt(int i, char c) {
        if(Character.isLowerCase(c)){
            c = Character.toUpperCase(c);
            return super.setCharAt( i , c);
        }
        else 
            return false;
    }

    /********************************************
     *This is the main function used for testing.
     */
    public static void main(String[] args) {     
        UString u = new UString("Ponies are pretty");
        System.out.println("UString: " + u);

        UString test1 = new UString("test one");
        System.out.println(test1);
        test1.setCharAt(0, 't');
        System.out.println(test1);

        System.out.println("\nOriginal static string value ...");
        System.out.println(MString.staticTest);
	
        System.out.println("\nChanging static string ...");
        UString.staticTest = "set from UString";
        System.out.println(MString.staticTest);
        System.out.println(UString.staticTest);
        MString m = new MString("x");
        System.out.println(m.staticTest);

        System.out.println("\nChanging static string again...");
        m.staticTest = "set from m";
        System.out.println(MString.staticTest);
        System.out.println(UString.staticTest);
        System.out.println(m.staticTest);
    }
}