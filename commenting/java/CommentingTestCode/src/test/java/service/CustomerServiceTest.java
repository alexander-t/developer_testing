package service;

import domain.Customer;
import domain.Money;
import domain.Product;
import domain.Purchase;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CustomerServiceTest {

    @Test
    public void hasFreeShipping_productsInHistoryWithTotalPriceLessThan100_NoFreeShipping() {
        Customer customerWithoutFreeShipping
                = customerWithTotalPurchaseAmount(99);
        assertFalse(customerWithoutFreeShipping
                .hasFreeShipping());
    }

    @Test
    public void hasFreeShipping_productsInHistoryWithTotalPriceGreaterThan100_GetFreeShipping() {
        Customer customerWithFreeShipping
                = customerWithTotalPurchaseAmount(150);
        assertTrue(customerWithFreeShipping
                .hasFreeShipping());
    }

    private Customer customerWithTotalPurchaseAmount(double amount) {
        Customer customer
                = new Customer(1, "Abel", "Abelsson");
        Purchase purchase = new Purchase();
        purchase.addProduct(new Product(1,
                "Product", new Money(amount)));
        customer.getPurchaseHistory().add(purchase);
        return customer;
    }
}
