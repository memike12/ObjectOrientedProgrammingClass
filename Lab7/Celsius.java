public final class Celsius extends Temperature {
    /**********************************************
     *This constructor takes a double and  sets the temperature to what ever that double was.
     **************************/
    public Celsius(double dd){
        super(dd);
    }

    /**********************************************
     *This constructor takes no input and  sets the temperature zero.
     **************************/
    public Celsius(){
        super();
    }
    
    /**********************************************
     *This returns the freezing point of the request scale as a double.
     **************************/
    public double freezingPoint(){
        return 0.0;
    }

    /**********************************************
     *This returns the boiling point of the request scale as a double.
     **************************/
    public double boilingPoint(){
        return 100.0;
    }

    /**********************************************
     *This returns the absolute zero temperature of the request scale as a double.
     **************************/
    public double absoluteZero()
    {
        return -273.15;
    }

    /**********************************************
     *This returns the Temperature as a string with units.
     **************************/
    public String toString(){
        double degrees = super.get();
        String s = String.format("%.1f C", degrees);
        return s;
    }

    /**********************************************
     *This converts Celsius to Fahrenheit and returns a double.
     **************************/
    public double toFahrenheit(){
        double orig = super.get();
        double newTemp = orig*9/5+32;
        return newTemp;
    }

    /**********************************************
     *This converts Celsius to Celsius and returns a double.
     **************************/
    public double toCelsius(){
        double orig = super.get();
        return orig;
    }

    /**********************************************
     *This converts Celsius to Kelvin and returns a double.
     **************************/
    public double toKelvin(){
        double orig = super.get();
        double newTemp = orig + 273.15;
        return newTemp;
    }

    /**********************************************
     *This is a main function used for testing.
     **************************/
    public static void main(String[] args){
        Celsius degrees2test = new Celsius(15);
        double tester;
        System.out.println("Temp is " + degrees2test.toString());
        tester = degrees2test.toFahrenheit();
        System.out.println("Temp is " + tester + " F");
        tester = degrees2test.toCelsius();
        System.out.println("Temp is " + tester + " C");
        tester = degrees2test.toKelvin();
        System.out.println("Temp is " + tester + " K");

        degrees2test = new Celsius();
        System.out.println("Temp is " + degrees2test.toString());
        tester = degrees2test.toFahrenheit();
        System.out.println("Temp is " + tester + " F");
        tester = degrees2test.toCelsius();
        System.out.println("Temp is " + tester + " C");
        tester = degrees2test.toKelvin();
        System.out.println("Temp is " + tester + " K");
    }
}