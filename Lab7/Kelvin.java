public final class Kelvin extends Temperature {
    /**********************************************
     *This constructor takes a double and  sets the temperature to what ever that double was.
     **************************/
    public Kelvin(double dd){
        super(dd);
    }

    /**********************************************
     *This constructor takes no input and  sets the temperature zero.
     **************************/
    public Kelvin(){
        super();
    }
    
    /**********************************************
     *This returns the freezing point of the request scale as a double.
     **************************/
    public double freezingPoint(){
        return 273.15;
    }

    /**********************************************
     *This returns the boiling point of the request scale as a double.
     **************************/
    public double boilingPoint(){
        return 373.15;
    }

    /**********************************************
     *This returns the absolute zero temperature of the request scale as a double.
     **************************/
    public double absoluteZero()
    {
        return 0;
    }

    /**********************************************
     *This returns the Temperature as a string with units.
     **************************/
    public String toString(){
        double degrees = super.get();
        String s = String.format("%.1f K", degrees);
        return s;
    }

    /**********************************************
     *This converts Kelvin to Fahrenheit and returns a double.
     **************************/
    public double toFahrenheit(){
        double orig = super.get();
        double newTemp = ((9/5)*(orig-273.15)+32);
        return newTemp;
    }

    /**********************************************
     *This converts Kelvin to Celsius and returns a double.
     **************************/
    public double toCelsius(){
        double orig = super.get();
        double newTemp = orig-273.15;
        return newTemp;
    }

    /**********************************************
     *This converts Kelvin to Kelvin and returns a double.
     **************************/
    public double toKelvin(){
        double orig = super.get();
        return orig;
    }

    /**********************************************
     *This is a main function used for testing.
     **************************/
    public static void main(String[] args){
        Kelvin degrees2test = new Kelvin(15);
        double tester;
        System.out.println("Temp is " + degrees2test.toString());
        tester = degrees2test.toFahrenheit();
        System.out.println("Temp is " + tester + " F");
        tester = degrees2test.toCelsius();
        System.out.println("Temp is " + tester + " C");
        tester = degrees2test.toKelvin();
        System.out.println("Temp is " + tester + " K");

        degrees2test = new Kelvin();
        System.out.println("Temp is " + degrees2test.toString());
        tester = degrees2test.toFahrenheit();
        System.out.println("Temp is " + tester + " F");
        tester = degrees2test.toCelsius();
        System.out.println("Temp is " + tester + " C");
        tester = degrees2test.toKelvin();
        System.out.println("Temp is " + tester + " K");
    }
}
