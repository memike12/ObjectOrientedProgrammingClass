/**
 *This class is to make a line between two point objects
 */
public class Line {
    private Point first, second;

    /**
     * Constructor to make a line. Accepts 4 floats.
     */
    public Line(float firstX, float firstY, float secondX, float secondY) {
        first = new Point(firstX, firstY);
        second = new Point(secondX, secondY);
    }

    /**
     *Returns the length of the line-segement between points. It accepts two points.
     */
    public double getLength(Point first, Point second) {
        float lengthSquared = (first.getX() - second.getX())*(first.getX() - second.getX()) + (first.getY() - second.getY())*(first.getY() - second.getY());
        double length = Math.sqrt(lengthSquared);
        return length;
    }

    /**
     *Determines which point is the left most point. Accepts two points.
     */
    public Point getLeftPoint(Point first, Point second) {
        if (first.getX() < second.getX())
            return first;
        else
            return second;
    }

    /**
     *Determines the right most point. Accepts two points.
     */
    public String getRightPoint(Point first, Point second) {
        if (first.getX() > second.getX()) {
            return first.toString();
        }
        else {
            return second.toString();
        }
    }
}