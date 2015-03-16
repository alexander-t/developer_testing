package foods.domain;

public abstract class FastFood {
    private Money price;
    private int calories;

    public FastFood(Money price, int calories) {
        this.price = price;
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }
}
