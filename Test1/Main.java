public class Main {
    public static void fiddle(Point p){
        p.x = 4;
    }

     public static int Factorial (int nn) {
        int product = nn;
        for (int ii = 1; ii<nn; ii++){

            product = product * (nn-ii);
        }
        return product;
    }

    public static void main (String[] args) {
        Point p = new Point();
        p.x = 3;
        p.y = 7;
        fiddle (p);
        System.out.println(p.x + "," + p.y);
        
        int factor = Factorial(6);
        System.out.println(factor);
    }
}