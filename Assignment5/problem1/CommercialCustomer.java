/**
 * File: CommercialCustomer.java
 * Description: Business contact info and credit rating
 * Date: 11/20/26
 * @author Tyler Bolander
 */

public class CommercialCustomer extends Customer {
    private int creditRating;
    private String contactPerson;
    private String contactPhone;

    public CommercialCustomer(String name, String address, String phone, int creditRating, String contactPerson, String contactPhone) {
        super(name, address, phone);
        this.creditRating = creditRating;
        this.contactPerson = contactPerson;
        this.contactPhone = contactPhone;
    }

    public int getCreditRating() {
        return creditRating;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    @Override
    public String toString() {
        return super.toString() + "\nContact: " + contactPerson + ", " + contactPhone
                + "\nCredit rating: " + creditRating;
    }
}
