package foods.domain;

public class SideOrder extends SizableFastFood {

    public SideOrder(Money price, int calories) {
        super(price, calories);
    }

    public SideOrder(Money price, int calories, Size size) {
        super(price, calories, size);
    }
}

