package foods.domain;

public class SizableFastFood extends FastFood {
    private final Size size;

    public SizableFastFood(Money price, int calories ) {
        this(price, calories, null);
    }

    public SizableFastFood(Money price, int calories, Size size) {
        super(price, calories);
        this.size = size;
    }
}
