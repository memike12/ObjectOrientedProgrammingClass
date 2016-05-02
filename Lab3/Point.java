/**
 *This class creates a private X and Y coordinate
 */
public class Point {
    private float x,y;

    /**
     * Constructor to make a point. Accepts two floats.
     */
    public Point(float newx, float newy) {
        x = newx;
        y = newy;
    }

    /**
     *Prints out the point as a string
     */
    public String toString() {
        return "(" + x + "," + y + ")" ;
    }

    /**
     *Prints out the x coordinate
     */
    public float getX() {
        return x;
    }

    /**
     *Prints out the Y coordinate
     */
    public float getY() {
        return y;
    }
}