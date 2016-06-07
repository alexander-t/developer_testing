package shop.purchase;

import shop.campaign.Campaign;

public class PurchaseWorkflow {

    private Campaign campaign;
    private long customerId;
    private Purchase purchase = new Purchase();

    public PurchaseWorkflow(Campaign campaign) {
        this.campaign = campaign;
    }

    public PurchaseWorkflow usingExistingCustomer(long customerId) {
        this.customerId = customerId;

        // Do something intriguing with a customer object.
        return this;
    }

    public PurchaseWorkflow addItem(Item item) {
        purchase.addItem(item);
        return this;
    }

    public PurchaseWorkflow enterDiscountCode(String discountCode) {
        campaign.applyDiscount(customerId, discountCode, purchase);
        return this;
    }
}
