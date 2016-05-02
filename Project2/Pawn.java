public class Pawn extends Piece {

    /**
     * This is the constructor. it accepts a location and an in color which is either white or black
     */ 
    public Pawn(Location loc, int color){
        super(loc, color);
    }

    /**
     * This function accepts a location of the spot you want to travel to and returns 
     * a boolean saying weither the move is legal or not
     */ 
    public boolean checkMove(Location toSpot){
        Location fromSpot = this.getLoc();
        int fc = loc.getColIndex();
        int fr = loc.getRowIndex();
        int tc = toSpot.getColIndex();
        int tr = toSpot.getRowIndex();  
        if(color == 10){
            if (((tr == fr + 1) && (fc == tc)) || ((tr == fr + 1) && (fc - tc == 1)) || ((tr == fr + 1) && (fc - tc == -1)) || ((moves == 0) && (tr == fr + 2)) ){
                
            return true;
        }}
        else if(((tr == fr - 1) && (fc == tc)) || ((tr == fr - 1) && (fc - tc == 1)) || ((tr == fr - 1) && (fc - tc == -1)) || ((moves == 0) && (tr == fr - 2)) ){
            return true;
        }
        return false;
    }

    /**
     * This function accepts a location of the spot you want to travel to and returns 
     * a boolean saying weither the move is made or not
     */
    public boolean makeMove (Location toSpot){
        if (checkMove(toSpot)){
            super.loc = toSpot;
            moves++;
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
            return "\u265F";
        else
            return "\u2659";
    }

    /**
     * This function makes sure there is no pieces in the way of the jump. Takes a location of the spot
     * you want to go to and returns a Location array.
     */
    private int moves = 0;
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