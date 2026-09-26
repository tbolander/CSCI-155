/**
 * File: MultiplicationSkillsComplete.java
 * Description: Practicing Java by generating single digit multiplication problems (until the user enters -1 to terminate).
 * Date: 09/25/26
 * @author A. Alnusair (skeleton), Tyler Bolander 
 */

import java.util.Random;
import java.util.Scanner;

public class MultiplicationSkillsComplete {

    static int correctAnswer;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask the first question, then keep reading answers until -1 is used as input.
        createQuestion();
        while (true) {
            System.out.print("Enter your answer (or -1 to exit): ");
            int userResponse = input.nextInt();

            if (userResponse == -1) {
                break;
            }

            checkAnswer(userResponse);
        }

        input.close();
    }

    /** Creates and displays a random multiplication problem. */
    public static void createQuestion() {
        Random randGen = new Random();
        int firstNumber = randGen.nextInt(10);
        int secondNumber = randGen.nextInt(10);

        correctAnswer = firstNumber * secondNumber;
        System.out.println("\nWhat is " + firstNumber + " * " + secondNumber + "?");
    }

    /** Checks the answer and displays feedback accordingly. */
    public static void checkAnswer(int userResponse) {
        if (userResponse == correctAnswer) {
            System.out.println(createCorrectMessage());
            createQuestion();
        } else {
            System.out.println(createIncorrectMessage());
        }
    }

    /** Returns a random message for a correct answer. */
    public static String createCorrectMessage() {
        Random randGen = new Random();
        switch (randGen.nextInt(4)) {
            case 0: return "Very good!";
            case 1: return "Correct!";
            case 2: return "Excellent, keep up the good work!";
            case 3: return "Great job!";
            default: return "";
        }
    }

    /** Returns a random message for an incorrect answer. */
    public static String createIncorrectMessage() {
        Random randGen = new Random();
        switch (randGen.nextInt(4)) {
            case 0: return "Wrong answer, keep trying";
            case 1: return "Don't give up, you can do it!";
            case 2: return "Incorrect, try again.";
            case 3: return "Not quite right. Try again.";
            default: return "";
        }
    }
}
