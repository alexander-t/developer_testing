package mocking;

import shop.campaign.Campaign;
import shop.purchase.Purchase;
import shop.purchase.PurchaseWorkflow;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static shop.inventory.Inventory.getBookByTitle;
import static shop.inventory.Inventory.getTraining;

public class ManualMockTest {

    // new PurchaseWorkflow(new Books10PercentOffCampaign())

    @Test
    public void useLenientMock() {
        LenientMock campaignMock = new LenientMock();
        new PurchaseWorkflow(campaignMock)
                .addItem(getBookByTitle("Developer Testing"))
                .usingExistingCustomer(1234567)
                .enterDiscountCode("DEAL");
        campaignMock.verify();
    }

    @Test
    public void useAverageMock() {
        Purchase expectedPurchase
                = new Purchase(getBookByTitle("Refactoring"));
        AverageMock campaignMock
                = new AverageMock(expectedPurchase);
        new PurchaseWorkflow(campaignMock)
                .addItem(getBookByTitle("Refactoring"))
                .usingExistingCustomer(1234567)
                .enterDiscountCode("WEEKEND DEAL");
        campaignMock.verify();
    }

    @Test
    public void useDemandingMock() {
        DemandingMock campaignMock = new DemandingMock();
        new PurchaseWorkflow(campaignMock)
                .usingExistingCustomer(1234567)
                .addItem(getTraining("TDD for dummies (5 days)"))
                .addItem(getBookByTitle("TDD from scratch"))
                .enterDiscountCode("DISCOUNT_123X")
                .enterDiscountCode("DISCOUNT_234Y")
                .enterDiscountCode("DISCOUNT_999Z");
        campaignMock.verify();
    }

    private class LenientMock implements Campaign {

        private boolean wasInvoked;

        @Override
        public void applyDiscount(long customerNumber,
                                  String discountCode,
                                  Purchase purchase) {
            wasInvoked = true;
        }

        public void verify() {
            assertTrue(wasInvoked);
        }
    }

    private class AverageMock implements Campaign {

        private Purchase expectedPurchase;
        private boolean wasInvoked;

        private AverageMock(Purchase expectedPurchase) {
            this.expectedPurchase = expectedPurchase;
        }

        @Override
        public void applyDiscount(long customerNumber,
                                  String discountCode,
                                  Purchase purchase) {
            assertThat(customerNumber, greaterThan(0L));
            assertEquals("WEEKEND DEAL", discountCode);
            assertEquals(expectedPurchase, purchase);
            wasInvoked = true;
        }

        public void verify() {
            assertTrue(wasInvoked);
        }
    }

    private class DemandingMock implements Campaign {

        private int timesInvoked;

        @Override
        public void applyDiscount(long customerNumber,
                                  String discountCode,
                                  Purchase purchase) {
            assertThat(customerNumber,
                    allOf(greaterThanOrEqualTo(1000000L),
                            lessThanOrEqualTo(9999999L)));
            assertTrue(discountCode
                    .matches("DISCOUNT_\\d{3,10}[X-Z]?"));
            assertThat(purchase,
                    new PremiumPurchaseMatcher());
            timesInvoked++;
        }

        public void verify() {
            assertEquals(3, timesInvoked);
        }
    }
}


