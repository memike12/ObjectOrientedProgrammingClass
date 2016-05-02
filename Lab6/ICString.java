public class ICString {
    
    
    /********************************************
     *This makes the character array.
     */
    protected char[] charArray;

    /********************************************
     *This is the constructor for ICString
     */
    public ICString(String s) {
        charArray = s.toCharArray();
    }

    /********************************************
     *This returns the length of the character array.
     */
    public int length() {
        return charArray.length;
    }

    /********************************************
     *This converts the character array to a string.
     */   
    public String toString() {
        return new String(charArray);
    }

    /********************************************
     *This is the main method used for testing.
     */
    public static void main(String[] args) {
        ICString s = new ICString("Test");
        System.out.println("ICString: " + s);
        System.out.println("length:   " + s.length());
    }
}