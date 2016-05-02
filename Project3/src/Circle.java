
public class Circle extends Piece {


	    /**
	     * This is the constructor. it accepts a location and an in color which is either white or black
	     */ 
	    public Circle(Location loc, int color){
	        super(loc, color);
	    }

	   

	    /**
	     * Retuns the string of the color of the circle
	     */
	    public String toString(){
	        if (color == 10)
	            return "\u265F";
	        else
	            return "\u2659";
	    }

	    /**
	     * This function makes sure there is no pieces in the way of the jump. Takes a location of the spot
	     * you want to go to and returns a Location array.
	     */
	    
	    public Location[] mustBeOpen(Location toSpot){
	        int fc = loc.getColIndex();
	        int fr = loc.getRowIndex();
	        int tc = toSpot.getColIndex();
	        int tr = toSpot.getRowIndex();
	        Location[] a = new Location[1];
	        if (this.color == 10){
	            Location loc = new Location(fc, fr + 1);
	            //System.out.println(loc);
	            a[0] = loc;
	        }
	        else {
	            Location loc = new Location(fc, fr - 1);
	            //System.out.println(loc);
	            a[0] = loc;
	        }
	        //System.out.println(a[0]);
	        return a;
	    }
	}

