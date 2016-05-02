public class AClassMain {
    public static void main( String [] args){
        AClass a = new AClass();
        a.x =1.2;
        a.y= false;
        System.out.println(a.x + " " +  a.y);

        AClass p = new AClass(4.2, true);
        
        System.out.println(p.x + " " +  p.y);
        String str = "hello";
        char [] charArray = str.toCharArray();
        char [] ret= new char[charArray.length];
        int count = 0;
        for (int ii =charArray.length-1; ii>=0; ii--){
            ret[count]= charArray[ii];
            count++;
        }
        System.out.println(ret);
    }
        

}