package scenarios;

import org.junit.Test;
import shop.campaign.Campaign;
import shop.purchase.Purchase;
import shop.purchase.PurchaseWorkflow;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.number.OrderingComparison.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.argThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.longThat;
import static org.mockito.Matchers.matches;
import static org.mockito.Mockito.*;
import static shop.inventory.Inventory.getBookByTitle;
import static shop.inventory.Inventory.getTraining;

/**
 * This is a reimplementation of the ManualMockTest class, but using Mockito this time.
 */
public class UsingMockitoTest {

    @Test
    public void useLenientMock() {
        Campaign campaignMock = mock(Campaign.class);
        new PurchaseWorkflow(campaignMock)
                .addItem(getBookByTitle("Developer Testing"))
                .usingExistingCustomer(1234567)
                .enterDiscountCode("DEAL");

        verify(campaignMock).applyDiscount(anyLong(),
                anyString(), any(Purchase.class));
    }

    @Test
    public void useAverageMock() {
        Campaign campaignMock = mock(Campaign.class);
        Purchase expectedPurchase
                = new Purchase(getBookByTitle("Refactoring"));
        new PurchaseWorkflow(campaignMock)
                .addItem(getBookByTitle("Refactoring"))
                .usingExistingCustomer(1234567)
                .enterDiscountCode("WEEKEND DEAL");
        verify(campaignMock).applyDiscount(
                longThat(greaterThan(0L)),
                eq("WEEKEND DEAL"), eq(expectedPurchase));
    }

    @Test
    public void useDemandingMock() {
        Campaign campaignMock = mock(Campaign.class);
        new PurchaseWorkflow(campaignMock)
                .usingExistingCustomer(1234567)
                .addItem(getTraining("TDD for dummies (5 days)"))
                .addItem(getBookByTitle("TDD from scratch"))
                .enterDiscountCode("DISCOUNT_123X")
                .enterDiscountCode("DISCOUNT_234Y")
                .enterDiscountCode("DISCOUNT_999Z");
        verify(campaignMock, times(3))
                .applyDiscount(longThat(
                        allOf(greaterThanOrEqualTo(1000000L),
                                lessThanOrEqualTo(9999999L))),
                        matches("DISCOUNT_\\d{3,10}[X-Z]?"),
                        argThat(new PremiumPurchaseMatcher()));
    }

}
