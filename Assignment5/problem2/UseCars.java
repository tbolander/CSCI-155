/**
 * File: UseCars.java
 * Description: Enter owners and cars, then search a car by VIN.
 * Date: 11/21/26
 * @author Tyler Bolander
 */

import java.util.ArrayList;
import java.util.Scanner;

public class UseCars {
    private Scanner input = new Scanner(System.in);
    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<CarOwner> owners = new ArrayList<>();

    public static void main(String[] args) {
        UseCars registry = new UseCars();
        registry.run();
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Owner " + i);
            owners.add(readOwner());
        }
        for (int i = 1; i <= 4; i++) {
            boolean sportsCar = i <= 2;
            if (sportsCar) {
                System.out.println("\nEnter a sports car");
            } else {
                System.out.println("\nEnter a sedan");
            }

            String make = readText("Make: ");
            String model = readText("Model: ");
            int year = readNumber("Year: ", 1);
            String vin = readText("VIN: ");
            while (vin.isEmpty() || findCar(vin) != null) {
                if (vin.isEmpty()) {
                    vin = readText("VIN can't be blank. Enter a VIN: ");
                } else {
                    vin = readText("That VIN is already in the list. Enter a different VIN: ");
                }
            }
            CarOwner owner = chooseOwner();

            if (sportsCar) {
                addSportsCar(make, model, year, vin, owner);
            } else {
                addSedan(make, model, year, vin, owner);
            }
        }
        String searchVin = readText("VIN to find: ");
        displayByVin(searchVin);
        System.out.println("\nAll cars:");
        for (Car car : cars) {
            System.out.println(car);
        }
        input.close();
    }

    private CarOwner readOwner() {
        String name = readText("Name: ");
        String address = readText("Address: ");
        return new CarOwner(name, address);
    }

    private CarOwner chooseOwner() {
        for (int i = 0; i < owners.size(); i++) {
            System.out.println((i + 1) + ". " + owners.get(i).getName());
        }
        int choice = readNumber("Owner number: ", 1);
        while (choice > owners.size()) {
            choice = readNumber("Choose an owner from the list: ", 1);
        }
        return owners.get(choice - 1);
    }

    private void addSportsCar(String make, String model, int year, String vin, CarOwner owner) {
        int wins = readNumber("Races won: ", 0);
        cars.add(new SportsCar(make, model, year, vin, owner, wins));
    }

    private void addSedan(String make, String model, int year, String vin, CarOwner owner) {
        int doors = readNumber("# of doors: ", 1);
        int trunk = readNumber("Trunk size in cu. feet: ", 0);
        cars.add(new Sedan(make, model, year, vin, owner, doors, trunk));
    }

    private void displayByVin(String vin) {
        Car car = findCar(vin);
        if (car == null) {
            System.out.println("No car found for VIN " + vin);
        } else {
            System.out.println("\nCar found:\n" + car);
        }
    }

    private Car findCar(String vin) {
        for (Car car : cars) {
            if (vin.equalsIgnoreCase(car.getVin())) {
                return car;
            }
        }
        return null;
    }

    private String readText(String prompt) {
        System.out.print(prompt);
        return input.nextLine().trim();
    }

    private int readNumber(String prompt, int minimum) {
        while (true) {
            try {
                int number = Integer.parseInt(readText(prompt));
                if (number >= minimum) {
                    return number;
                }
            } catch (NumberFormatException e) {
                // Entries like "2026 car" need to be entered again.
            }
            System.out.println("Enter a whole number of " + minimum + " or more ");
        }
    }
}
