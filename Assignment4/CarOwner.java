/**
 * File: CarOwner.java
 * Description: Store an owner's name and address separately from their cars.
 * Date: 10/27/26
 * @author Tyler Bolander
 */

public class CarOwner {

    private String name;
    private String address;

    /** Creates an owner whose information can be filled in later. */
    public CarOwner() {
        name = "Unknown";
        address = "Unknown";
    }

    public CarOwner(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Get and update the owner's info.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /** Returns the owner's name and address as text. */
    @Override
    public String toString() {
        return name + "\nAddress: " + address;
    }
}
