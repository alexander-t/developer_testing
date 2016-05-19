package shop.inventory;

import shop.purchase.Item;

public class Book extends Item {
    private final String title;

    public Book(String title, double price) {
        super(price);
        this.title = title;
    }
}
