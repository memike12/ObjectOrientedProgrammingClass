public class Exam1a {
    public static Lion [] arrLions;

    public static void main(String [] args ){
        arrLions = new Lion [args.length/3];
        int lionCount =0;
        for(int ii=0; ii<args.length; ii++){
            double first = Double.parseDouble(args[ii]);
            ii++;
            double second = Double.parseDouble(args[ii]);
            ii++;
            double third = Double.parseDouble(args[ii]);
            arrLions[lionCount] = new Lion(first,second,third);
            lionCount++;
        }
        printLions();
        bestLion();
        
    }
    
    public static void printLions(){
        for( int ii=0; ii<arrLions.length; ii++){
            String lion = arrLions[ii].toString();
            System.out.println(lion);
        }
    }

    public static void bestLion(){
        Lion winner = arrLions[0];
        for( int ii=1; ii<arrLions.length; ii++){
            if (!winner.isMoreFitThan(arrLions[ii] ) )
                winner = arrLions[ii];
        }
        System.out.println("Best lion: " + winner);

    }
}