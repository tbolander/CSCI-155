/**
 * File: RegistrarMenuArrayList.java
 * Description: Let's the user add, remove, and print courses stored in an ArrayList. Counts courses that start with COMP (v2).
 * Date: 10/05/26
 * @author A. Alnusair (menu example), Tyler Bolander
 */

import java.util.ArrayList;
import java.util.Scanner;

public class RegistrarMenuArrayList {

    static ArrayList<String> coursesOffered = new ArrayList<String>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean finished = false;

        while (!finished) {
            System.out.println("\nRegistrar Menu");
            System.out.println("====================");
            System.out.println("1. Add a course");
            System.out.println("2. Remove a course");
            System.out.println("3. Count computing courses");
            System.out.println("4. Display courses");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            if (!input.hasNextInt()) {
                input.nextLine();
                System.out.println("Please enter a number from 1 to 5.");
                continue;
            }

            int userChoice = input.nextInt();
            input.nextLine(); // Read the newline left by nextInt().

            switch (userChoice) {
                case 1:
                    createCourse();
                    break;
                case 2:
                    removeCourse();
                    break;
                case 3:
                    numComputingCourses();
                    break;
                case 4:
                    displayCourses();
                    break;
                case 5:
                    finished = true;
                    break;
                default:
                    System.out.println("Please enter a number from 1 to 5.");
            }
        }

        input.close();
    }

    /** Adds a course if it's title isn't blank AND isn't already stored. */
    public static void createCourse() {
        System.out.print("Enter the course title you want to add: ");
        // Use uppercase so capitalization doesn't matter when searching.
        String courseTitle = input.nextLine().trim().toUpperCase();
        if (courseTitle.isEmpty()) {
            System.out.println("Please enter a course title.");
        } else if (coursesOffered.contains(courseTitle)) {
            System.out.println(courseTitle + " already exists. It was not added again to the list.");
        } else {
            coursesOffered.add(courseTitle);
            System.out.println(courseTitle + " was added.");
        }
    }

    /** Removes a course regardless of capitalization. */
    public static void removeCourse() {
        System.out.print("Enter the course title you want to remove: ");
        String courseTitle = input.nextLine().trim().toUpperCase();

        if (coursesOffered.contains(courseTitle)) {
            coursesOffered.remove(courseTitle);
            System.out.println(courseTitle + " was removed.");
        } else {
            System.out.println("That course wasn't found. Did you type it correctly?");
        }
    }

    /** Counts courses whose titles begin with COMP. */
    public static void numComputingCourses() {
        int computingCount = 0;

        for (String courseTitle : coursesOffered) {
            if (courseTitle.startsWith("COMP")) {
                computingCount++;
            }
        }

        System.out.println("Computing courses: " + computingCount);
    }

    /** Prints the courses currently stored in the array list. */
    public static void displayCourses() {
        if (coursesOffered.isEmpty()) {
            System.out.println("No courses have been added!");
        } else {
            System.out.println("Current courses:");
            for (String courseTitle : coursesOffered) {
                System.out.println(courseTitle);
            }
        }
    }
}
