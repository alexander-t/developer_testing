package domain;

public class Age {
    private int years;

    public Age(int years) {
        if (years < 1 || years >= 120) {
            throw new IllegalArgumentException("Invalid age");
        }
        this.years = years;
    }
}
