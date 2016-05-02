public class King extends Piece {

    /**
     * This is the constructor. it accepts a location and an in color which is either white or black
     */ 
    public King(Location loc, int color){
        super(loc, color);
    }

    /**
     * This function accepts a location of the spot you want to travel to and returns 
     * a boolean saying weither the move is legal or not
     */ 
    public boolean checkMove(Location toSpot){
        int fc = loc.getColIndex();
        int fr = loc.getRowIndex();
        int tc = toSpot.getColIndex();
        int tr = toSpot.getRowIndex(); 
        if ((((tr == fr + 1) || (tr == fr -1)) && (fc == tc)) || (((tr == fr + 1) || (tr == fr - 1)) && (fc - tc == 1)) || (((tr == fr + 1) || (tr == fr - 1)) && (fc - tc == -1)) ||  (((tc == fc + 1) || (tc == fc - 1)) && (fr == tr)) ){
            return true;
        }
        else
            return false;
    }

    /**
     * This function accepts a location of the spot you want to travel to and returns 
     * a boolean saying weither the move is made or not
     */
    public boolean makeMove (Location toSpot){
        if (checkMove(toSpot)){
            super.loc = toSpot;
            return true;
        }
        else 
            return false;
    }

    /**
     * Retuns the string of the color of the rook
     */
    public String toString(){
        if (color == 10)
            return "\u265A";
        else
            return "\u2654";
    }

     /**
     * This function makes sure there is no pieces in the way of the jump. Takes a location of the spot
     * you want to go to and returns a Location array.
     */
    public Location[] mustBeOpen(Location toSpot){
        Location[] a = new Location[0];
            return a;
    }
}