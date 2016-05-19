package shop.inventory;

import shop.purchase.Item;

public class Training extends Item {

    private String name;

    public Training(String name, double price) {
        super(price);
        this.name = name;
    }
}
