package elevator;

/**
 * The BooleanSource class contains a constructor to indicate a probability and a method which returns true a percentage of the time equal to the probability and otherwise returns false.
 */
public class BooleanSource {

    private double probability;

    /**
     * Constructor for the BooleanSource class.
     * @param p
        * The probability of returning true.
     */
    public BooleanSource(double p){
    if (p < 0.0 || p > 1.0)
        throw new IllegalArgumentException();
    probability = p;
    }

    /**
     * Returns true a percentage of the time equal to the probability.
     * @return
        * If a request is received in accordance to the probability provided.
     */
    public boolean requestArrived() {
        return (Math.random() < probability);
    }
}

