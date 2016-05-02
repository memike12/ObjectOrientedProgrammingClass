public abstract class Temperature {
    private double degrees;

   /**********************************************
     *This Consturctor is  the holder of the temperature of the selected measure. It takes a double.

Also the error exception has to be fixed.
     **************************/
    protected Temperature(double dd){
        degrees = dd;
        if (this.toKelvin() < 0){
            throw new IllegalArgumentException(dd + " is below absolute zero!");
        }
    }

    /**********************************************
     *This Consturctor is  the holder of the temperature of the selected measure. It takes a double.
     **************************/
    protected Temperature(){
        degrees = freezingPoint();
    }

    public abstract double freezingPoint();
    public abstract double boilingPoint();
    public abstract double absoluteZero();
    public abstract String toString();

    public abstract double toFahrenheit();
    public abstract double toCelsius();
    public abstract double toKelvin();


    /**********************************************
     *This sets 
     **************************/
    public void set(double n){
        degrees = n;
        if (this.toKelvin() < 0){
            throw new IllegalArgumentException(n + " is below absolute zero!");
        }
    }

    public double get() {
        double val = degrees;
        return val;
    }
}