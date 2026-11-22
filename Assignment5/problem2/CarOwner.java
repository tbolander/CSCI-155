/**
 * File: CarOwner.java
 * Description: Stores an owner even if they have no cars put in the registry.
 * Date: 11/21/26
 * @author Tyler Bolander
 */

public class CarOwner {
    private String name;
    private String address;

    public CarOwner(String name, String address) {
        this.name = name;
        this.address = address;
    }

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

    @Override
    public String toString() {
        return name + ", " + address;
    }
}
