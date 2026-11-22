/**
 * File: PersonalCustomer.java
 * Description: Adds a home number and work number to a customer record.
 * Date: 11/20/26
 * @author Tyler Bolander
 */

public class PersonalCustomer extends Customer {
    private String homePhone;
    private String workPhone;

    public PersonalCustomer(String name, String address, String phone, String homePhone, String workPhone) {
        super(name, address, phone);
        this.homePhone = homePhone;
        this.workPhone = workPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    @Override
    public String toString() {
        return super.toString() + "\nHome: " + homePhone + ", work: " + workPhone;
    }
}
