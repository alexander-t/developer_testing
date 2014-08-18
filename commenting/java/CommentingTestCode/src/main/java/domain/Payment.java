package domain;

public class Payment {
    private final long referenceNumber;
    private final Money money;

    public Payment(long referenceNumber, Money money) {
        this.referenceNumber = referenceNumber;
        this.money = money;
    }
}
