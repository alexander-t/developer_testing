package domain;

import java.util.List;

public class Purchase {

    private List<Product> products;

    public void addProduct(Product product) {
        products.add(product);
    }

    public void getTotalPrice() {
        products.stream().forEach(p -> {
            System.err.println(p.getPrice());
        });
    }
}
