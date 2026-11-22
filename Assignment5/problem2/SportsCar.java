/**
 * File: SportsCar.java
 * Description: Adds the number of races won
 * Date: 11/21/26
 * @author Tyler Bolander
 */

public class SportsCar extends Car {
    private int racesWon;

    public SportsCar(String make, String model, int year, String vin, CarOwner owner, int racesWon) {
        super(make, model, year, vin, owner);
        this.racesWon = racesWon;
    }

    public int getRacesWon() {
        return racesWon;
    }

    public void setRacesWon(int racesWon) {
        this.racesWon = racesWon;
    }

    @Override
    public String toString() {
        return super.toString() + "\nRaces won: " + racesWon;
    }
}
