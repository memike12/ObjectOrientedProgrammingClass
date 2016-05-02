public abstract class Piece{

     /**
     * This is a final integer to identify if the piece is white
     */
    public static final int WHITE = 10;

    /**
     * This is a final integer to identify if the piece is black
     */
    public static final int BLACK = 11;
    
    /**
     * This is a final integer to identify the color
     */
    protected final int color;

    /**
     * This is the location of the piece
     */
    protected Location loc;

    /**
     * This is the constructor for the piece. it accepts a Location and an int for the color.
     * it throws an illegial argument exception if the color provided isn't possible.
     */
    protected Piece (Location loc, int color) throws java.lang.IllegalArgumentException {
        if (color != 10 && color != 11) {
            throw new IllegalArgumentException("Thats not a cool color");
        }
        this.loc = loc;
        this.color = color;
    }

    /**
     * This is the constructor for the piece. it accepts a character for the column and an int for the row.
     * It also accepts an int for the color. It throws an illegial argument exception 
     * if the color provided isn't possible.
     */
    protected Piece (char col, int row, int color) throws java.lang.IllegalArgumentException {
        if (color != 10 && color != 11) {
            throw new IllegalArgumentException();
        }
        this.color = color;
        loc = new Location(col,row);
    }
    
    /**
     * This function returns the pieces location
     */
    public Location getLoc(){
        return loc;
    }

    /**
     * This function returns the pieces color, which is an it.
     */
    public int getColor(){
        return color;
    }
    
   
    /**
     * This function returns the string of the piece.
     */
    public abstract java.lang.String toString();

    /**
     * This function makes sure there is no pieces in the way of the jump. Takes a location of the spot
     * you want to go to and returns a Location array.
     */
    public abstract Location[] mustBeOpen(Location toSpot);

}