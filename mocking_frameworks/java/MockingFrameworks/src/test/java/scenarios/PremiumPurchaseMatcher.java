package scenarios;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import shop.purchase.Purchase;

/**
 * A custom matcher that matches specific business rules
 */
public class PremiumPurchaseMatcher
        extends TypeSafeMatcher<Purchase> {

    @Override
    public boolean matchesSafely(Purchase purchase) {
        return purchase.getPrice() > 1000
                && purchase.getItemCount() < 5;
    }

    @Override
    public void describeTo(Description desc) {
        desc.appendText("A purchase with the " +
                "total price > 1000 and " +
                "fewer than 5 items");
    }
}