package foods.domain;

public class Money {

    private final int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public static Money SEK(int amount) {
        return new Money(amount);
    }
}
