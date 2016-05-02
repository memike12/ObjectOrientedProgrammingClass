public class Lion{
    private double weight;
    private double health;
    private double intel;
    

    private double computeFitness(){
        double fitness = health + (.5 * weight) + (1.5 * intel);
        return fitness;
    }

    public Lion(double first, double second, double third){
        weight = first;
        health = second;
        intel = third;
    }
    
    public String toString(){
        double fit = computeFitness();
        String ret = "Lion " + String.valueOf(weight) + " " + String.valueOf(health) + " " + String.valueOf(intel) + " = " + String.valueOf(fit);
        return ret;
    }

    public boolean isMoreFitThan(Lion a){
        double fit = computeFitness();
        double otherfit = a.computeFitness();
        if ( fit > otherfit){
            return true;
        }
        else
        return false;
    }
}