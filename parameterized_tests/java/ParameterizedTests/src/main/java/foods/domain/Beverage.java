package foods.domain;

public class Beverage extends SizableFastFood {

    private BeverageType beverageType;

    public Beverage(Money price, int calories, Size size) {
        this(price, calories, size, BeverageType.REGULAR);
    }

    public Beverage(Money price, int calories, Size size, BeverageType beverageType) {
        super(price, calories, size);
        this.beverageType = beverageType;
    }

    public boolean isDiet() {
        return beverageType == BeverageType.DIET;
    }

    public static enum BeverageType {
        REGULAR, DIET
    }
}
