/**
 * File: RegistrarMenuArray.java
 * Description: Let's the user add, remove, and print courses stored in a regular array. Counts courses that start with COMP.
 * Date: 10/03/26
 * @author A. Alnusair (menu example), Tyler Bolander
 */

import java.util.Scanner;

public class RegistrarMenuArray {

    static String[] coursesOffered = new String[0];
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
            input.nextLine(); // Reads the newline left by nextInt().

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

    /** Adds a course if the title is not blank AND not already stored in the array. */
    public static void createCourse() {
        System.out.print("Enter the course title you want to add: ");
        String courseTitle = input.nextLine().trim().toUpperCase();

        if (courseTitle.isEmpty()) {
            System.out.println("Please enter a course title.");
        } else if (findCourse(courseTitle) != -1) {
            System.out.println(courseTitle + " already exists. It was not added again to the list.");
        } else {
            // Copy into a new array with room for one more course.
            String[] expandedCourses = new String[coursesOffered.length + 1];
            for (int i = 0; i < coursesOffered.length; i++) {
                expandedCourses[i] = coursesOffered[i];
            }
            expandedCourses[coursesOffered.length] = courseTitle;
            coursesOffered = expandedCourses;
            System.out.println(courseTitle + " was added.");
        }
    }

    /** Removes a course regardless of capitalization. */
    public static void removeCourse() {
        System.out.print("Enter the course title you want to remove: ");
        String courseTitle = input.nextLine().trim().toUpperCase();
        int courseIndex = findCourse(courseTitle);

        if (courseIndex == -1) {
            System.out.println("That course wasn't found. Did you type it correctly?");
        } else {
            String[] remainingCourses = new String[coursesOffered.length - 1];
            int nextPosition = 0;

            // Copy every course except the one being removed.
            for (int i = 0; i < coursesOffered.length; i++) {
                if (i != courseIndex) {
                    remainingCourses[nextPosition] = coursesOffered[i];
                    nextPosition++;
                }
            }

            coursesOffered = remainingCourses;
            System.out.println(courseTitle + " was removed.");
        }
    }

    /** Returns a course's index, or -1 if not found. */
    public static int findCourse(String courseTitle) {
        for (int i = 0; i < coursesOffered.length; i++) {
            if (coursesOffered[i].equals(courseTitle)) {
                return i;
            }
        }
        return -1;
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

    /** Prints the courses actively stored in the array. */
    public static void displayCourses() {
        if (coursesOffered.length == 0) {
            System.out.println("No courses have been added!");
        } else {
            System.out.println("Current courses:");
            for (String courseTitle : coursesOffered) {
                System.out.println(courseTitle);
            }
        }
    }
}
