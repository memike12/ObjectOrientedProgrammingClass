public class TryMe { 
    public static int num = 0;

    public TryMe() {
        num++;
    }

    public static void main( String [] args){
        TryMe one= new TryMe();
        TryMe two= new TryMe();
        two.num +=5;
        System.out.println(one.num + " and " + two.num);
    }
}