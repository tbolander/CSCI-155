/**
 * File: MagicArray.java
 * Description: Replace every match of a chosen number with zero. Prints the array before and after.
 * Date: 10/02/26
 * @author Tyler Bolander
 */

public class MagicArray {

    public static void main(String[] args) {
        int[] sampleNumbers = {5, 10, 5, 15, -2, 3};
        int magicNumber = 5;

        System.out.println("before replacing " + magicNumber + ":");
        displayArray(sampleNumbers);

        int[] replacedNumbers = magicReplace(sampleNumbers, magicNumber);

        System.out.println("after replacing " + magicNumber + ":");
        displayArray(replacedNumbers);
    }

    /** Returns a new array with each matching number replaced by 0. */
    public static int[] magicReplace(int[] theArray, int magicNumber) {
        int[] replacedNumbers = new int[theArray.length];

        for (int i = 0; i < theArray.length; i++) {
            if (theArray[i] == magicNumber) {
                replacedNumbers[i] = 0;
            } else {
                replacedNumbers[i] = theArray[i];
            }
        }

        return replacedNumbers;
    }

    /** Prints the array's numbers on a single line. */
    public static void displayArray(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
