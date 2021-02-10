public class mcmLength {
    public static final int CM_PER_M = 100;
    public static final int MM_PER_CM = 10;
    public static final int MM_PER_M = MM_PER_CM*CM_PER_M;

    // Private member variables:
    private int meters = 0;
    private int centimeters = 0;
    private int millimeters = 0;

    /**
     * constructors
     * @param cm
     */
    public mcmLength(double cm) {
        this((int)Math.round(cm*MM_PER_CM));
    }

    public mcmLength(int mm) {
        meters = mm/MM_PER_M;
        centimeters = (mm - meters*MM_PER_M)/MM_PER_CM;
        millimeters = mm - meters*MM_PER_M - centimeters*MM_PER_CM;
    }

    /**
     * In order to determine the validity of the input, we need to check whether the mm and cm values in the object
     * passed are valid or not. With this approach below, we ensure that all arguments passed in the object are valid.
     * @param m
     * @param cm
     * @param mm
     */
    public mcmLength(int m, int cm, int mm) {
        this(m*MM_PER_M + cm*MM_PER_CM + mm);
    }

    public mcmLength(){}

    /**
     * This method replaces the default toString method in the Object
     * @return
     */
    public String toString() {
        return Integer.toString(meters) + "m " + centimeters + "cm " + millimeters + "mm";
    }

    public int toMM() {
        return meters*MM_PER_M + centimeters*MM_PER_CM + millimeters;
    }


    public double toMeters() {
        return meters + ((double)(centimeters))/CM_PER_M + ((double)(millimeters))/MM_PER_M;
    }

    /**
     * All of the following methods are using the toMM() method
     * @param length
     * @return
     */
    public mcmLength add(mcmLength length)
    {
        return new mcmLength(toMM()+length.toMM());
    }

    public mcmLength subtract(mcmLength length)
    {
        return new mcmLength(toMM()-length.toMM());
    }

    public mcmLength multiply(int n)
    {
        return new mcmLength(n*toMM());
    }

    public mcmLength divide(int y)
    {
        return new mcmLength(toMM()/y);
    }

    //Calculate area in square mm

    public long area(mcmLength length) {
        return (toMM()*length.toMM());
    }

    /**
     * This is comparing the lengths of the two inputs, and returns the value 1 if the current value is greater than arg,
     * 0 if current vlaue is equal to arg, and -1 if the current value is less than arg
     * @param length
     * @return
     */
    public int compare(mcmLength length) {
        return greaterThan(length) ? 1 : (equals(length) ? 0 : -1);
    }

    public boolean equals(mcmLength length) {
        return toMM() == length.toMM();
    }

    public boolean lessThan(mcmLength length) {
        return toMM() < length.toMM();
    }

    public boolean greaterThan(mcmLength length) {
        return toMM() > length.toMM();
    }
}

