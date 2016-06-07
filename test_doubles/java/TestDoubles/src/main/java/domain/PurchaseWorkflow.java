package domain;

import java.util.Arrays;

public class PurchaseWorkflow {
    private DiscountLogic discountLogic;
    private Purchase purchase = new Purchase();

    public PurchaseWorkflow(DiscountLogic discountLogic) {
        this.discountLogic = discountLogic;
    }

    public void addItemsStep(Item... items) {
        Arrays.stream(items).forEach(purchase::addItem);
    }

    public void discountStep() {
        discountLogic.applyDiscount(1254098L, "DISCOUNT_123", purchase);
    }
}
