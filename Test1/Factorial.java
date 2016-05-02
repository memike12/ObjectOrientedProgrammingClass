public class Factorial {
    public int Factorial (int nn) {
        int product = nn;
        for (int ii = 1; ii<nn; ii++){

            product = product * (nn-ii);
        }
        return product;
    }
}