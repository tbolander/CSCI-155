/**
 * File: Sedan.java
 * Description: Gets door count and trunk size for a sedan.
 * Date: 11/21/26
 * @author Tyler Bolander
 */

public class Sedan extends Car {
    private int doors;
    private int trunkSize;

    public Sedan(String make, String model, int year, String vin, CarOwner owner, int doors, int trunkSize) {
        super(make, model, year, vin, owner);
        this.doors = doors;
        this.trunkSize = trunkSize;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getTrunkSize() {
        return trunkSize;
    }

    public void setTrunkSize(int trunkSize) {
        this.trunkSize = trunkSize;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDoors: " + doors + ", trunk: " + trunkSize + " cubic feet";
    }
}
