package service;

import domain.*;
import repository.PurchaseRepository;

public class PurchaseService {
    private PurchaseRepository purchaseRepository;

    public Invoice MakePurchase(Customer customer, Product product, Discount discount) {
        Purchase purchase = purchaseRepository.createPurchase(customer);
        purchaseRepository.addProduct(purchase, product);
        Invoice invoice = purchaseRepository.createInvoice(purchase);

        if (discount != null) {
            invoice.applyDiscount(discount);
        }
        return invoice;
    }
}

