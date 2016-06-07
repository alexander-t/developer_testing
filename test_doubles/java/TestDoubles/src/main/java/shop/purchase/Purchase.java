package shop.purchase;

import java.util.ArrayList;
import java.util.List;

public class Purchase {

    private List<Item> items = new ArrayList<Item>();

    public Purchase() {
    }

    public Purchase(Item ... items) {
        for (Item item : items) {
            addItem(item);
        }
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public double getPrice() {
        double totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public int getItemCount() {
        return items.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchase purchase = (Purchase) o;

        if (items != null ? !items.equals(purchase.items) : purchase.items != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return items != null ? items.hashCode() : 0;
    }
}
