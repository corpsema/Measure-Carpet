public class Measures {

    public static void main(String args[]) {
        /*
        This array holds the carpet lengths for both the 200 carpets and the 60 carpets, which is
        4 meters for the 200 carpets, and 3 meters, 57 cm for the 60 carpets
         */
        mcmLength[] carpetLengths = { new mcmLength(4,0,0), new mcmLength(3,57,0) };
        /*
        This array holds the carpet widths for both the 200 carpets and the 60 carpets, which is 2 meters by 9 cm for
        the 200 carpets, and 5 meters for the 60 carpet one.
         */
        mcmLength[] carpetWidths = { new mcmLength(2,9,0), new mcmLength(5,0,0) };

        // Weight for the square meters of the carpets
        double[] carpetWtPerSquareMeters = { 1.25, 1.05 };

        // An array of the amount of carpets, which are 200 and 60 respectively
        int[] totalCarpetCount = { 200, 60 };

        // Stores the information for reference as to the weight of a carpet
        tkgWeight carpetWeight = null;

        // Store the information for the area of a carpet
        double carpetArea = 0.0;


        for(int i = 0 ; i < carpetLengths.length ; ++i) {
            // Calculates the area directly since it is the fastest method
            carpetArea = carpetLengths[i].toMeters()*carpetWidths[i].toMeters();

            carpetWeight = new tkgWeight(carpetWtPerSquareMeters[i]*carpetArea);

            System.out.println("\nCarpet " + (i + 1) + ": Size = " + carpetLengths[i] + " by "+ carpetWidths[i]);
            System.out.println("  Weight per sq. m. = " + carpetWtPerSquareMeters[i]);
            System.out.println("  Area = " + carpetArea + " sq. m.");
            System.out.println("  Weight = " + carpetWeight);
            System.out.println("  Weight of " + totalCarpetCount[i] + " carpets = " + carpetWeight.multiply(totalCarpetCount[i]));
        }
    }
}