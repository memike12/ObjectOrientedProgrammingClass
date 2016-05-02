public class Queen extends Piece {

    /**
     * This is the constructor. it accepts a location and an in color which is either white or black
     */ 
    public Queen(Location loc, int color){
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
        if (toSpot.getCol() == fromSpot.getCol() || toSpot.getRow() == fromSpot.getRow() ){
            return true;
        }
        else
            for ( int i = 1; i < 8; i++)
                {
                    if((( fc - tc ) == i && (fr - tr) == i) || (( fc - tc ) == -i && (fr - tr) == -i) || (( fc - tc ) == i && (fr - tr) == -i) || (( fc - tc ) == -i && (fr - tr) == i))    
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
            return true;
        }
        else 
            return false;
    }

     /**
     * This function makes sure there is no pieces in the way of the jump. Takes a location of the spot
     * you want to go to and returns a Location array.
     */
    public Location[] mustBeOpen(Location toSpot){
        Location from = this.getLoc();
        Location[] locArr = new Location[0];
        try{
            locArr = new Location[loc.diagLocations(from, toSpot).length];
            locArr = loc.diagLocations(from, toSpot);      
        }catch(IllegalArgumentException e){}
        try{
            locArr = new Location[loc.rowLocations(from, toSpot).length];
            locArr = loc.rowLocations(from, toSpot);
        }catch(IllegalArgumentException e){}
        try{
            locArr = new Location[loc.colLocations(from, toSpot).length];
            locArr = loc.colLocations(from, toSpot);
        }
        catch(IllegalArgumentException e){}
        return locArr;
    }

    /**
     * Retuns the string of the color of the rook
     */
    public String toString(){
        if (color == 10)
            return "\u265B";
        else
            return "\u2655";
    }
}