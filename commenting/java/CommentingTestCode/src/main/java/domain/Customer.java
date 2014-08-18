package domain;

import java.util.stream.LongStream;

public class Customer {
    private long id;
    String firstName;
    String lastName;
    private PurchaseHistory purchaseHistory;

    public Customer(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean hasFreeShipping() {
        return false;
    }

    public PurchaseHistory getPurchaseHistory() {
        return purchaseHistory;
    }
}
