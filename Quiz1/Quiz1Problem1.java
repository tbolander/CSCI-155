/*
 * File: Quiz1Problem1.java
 * Description: Converts feet to meters and meters to feet.
 * Date: 09/26/26
 * @author Tyler Bolander
 */

public class Quiz1Problem1 {

    public static void main(String[] args) {
        // Trial each conversion method with a test value.
        System.out.println("10 feet = " + footToMeter(10) + " meters");
        System.out.println("10 meters = " + meterToFoot(10) + " feet");
    }

    // Convert from feet -> meters.
    public static double footToMeter(double foot) {
        return 0.305 * foot;
    }

    // Convert from meters -> feet.
    public static double meterToFoot(double meter) {
        return 3.279 * meter;
    }
}
