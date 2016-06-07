package shop.campaign;

import shop.purchase.Purchase;

public interface Campaign {
    void applyDiscount(long customerNumber, String discountCode, Purchase purchase);
}
