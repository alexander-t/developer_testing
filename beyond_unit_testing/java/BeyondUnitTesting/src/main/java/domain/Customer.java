package domain;


import java.util.Date;

public class Customer {
    private final String firstName;
    private final String lastName;
    private SecurityCredentials securityCredentials;
    private String shippingAddress;
    private Date dateCreated;

    public Customer(String firstName, String lastName, String shippingAddress, Date dateCreated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.shippingAddress = shippingAddress;
        this.dateCreated = dateCreated;
    }

    public String getFirstName() {
        return firstName;
    }

    public SecurityCredentials getSecurityCredentials() {
        return securityCredentials;
    }

    public void setSecurityCredentials(SecurityCredentials securityCredentials) {
        this.securityCredentials = securityCredentials;
    }

    public String getLastName() {
        return lastName;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
}
