package domain;

public interface DiscountLogic
{
    void applyDiscount(long customerNumber, String discountCode, Purchase purchase);
}
