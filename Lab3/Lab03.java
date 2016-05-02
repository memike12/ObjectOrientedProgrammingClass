import java.util.Scanner;

public class Lab03 {
    public static void main(String[] args) {

        /**
         *This tests to see if there are the correct ammount of arguments
         */
        if (args.length != 4) {
            System.out.println("ERROR: You must enter four arguments");
            return;
        }
        
        float[] argFloat = new float[args.length];
        for (int ii = 0; ii < args.length; ii++) {
            argFloat[ii] = Float.parseFloat( args[ii] );
        }

        /**
         *This makes sure that the values are within the correct range
         */
        for (int ii = 0; ii < args.length; ii++) {
            if (argFloat[ii] > 1 || argFloat[ii] < -1) {
                System.out.println("ERROR: You must enter values that are in the range of -1 to 1.");
                return;
            }
        }

        Point firstPoint = new Point(argFloat[0], argFloat[1]);
        Point secondPoint = new Point(argFloat[2], argFloat[3]);
        Line myLine = new Line(firstPoint.getX(), firstPoint.getY(), secondPoint.getX(), secondPoint.getY());
        
        System.out.println("Leftmost:    " + myLine.getLeftPoint(firstPoint, secondPoint));
        System.out.println("Rightmost:   " + myLine.getRightPoint(firstPoint, secondPoint));
        System.out.println("Line length: " + myLine.getLength(firstPoint, secondPoint));
        return;
    }
}