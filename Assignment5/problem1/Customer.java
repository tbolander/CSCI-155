/**
 * File: Customer.java
 * Description: Both of the customer types use this class for their main contact info
 * Date: 11/20/26
 * @author Tyler Bolander
 */

public abstract class Customer {
    private String name;
    private String address;
    private String phone;

    public Customer(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return name + ", " + address + ", phone " + phone;
    }
}
