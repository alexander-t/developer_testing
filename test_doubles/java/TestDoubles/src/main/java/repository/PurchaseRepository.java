package repository;

import domain.Customer;
import domain.Invoice;
import domain.Product;
import domain.Purchase;

import java.util.List;

public class PurchaseRepository {
    public Purchase createPurchase(Customer customer) {
        // Here a new purchase would be created in the database
        return new Purchase();
    }

    public void addProduct(Purchase purchase, Product product) {

    }

    public Invoice createInvoice(Purchase purchase) {
        return new Invoice();
    }

    public Invoice createInvoice(Customer customer, List<Product> products) {
        throw new UnsupportedOperationException("Implement this!");
    }

}
