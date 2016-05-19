package scenarios

import shop.campaign.Campaign
import shop.purchase.Purchase
import shop.purchase.PurchaseWorkflow
import spock.lang.Specification

import static shop.inventory.Inventory.getBookByTitle
import static shop.inventory.Inventory.getTraining

/**
 * This is a reimplementation of the ManualMockTest class, but using Spock this time.
 */
class UsingSpockTest extends Specification {

    def "Use lenient mock"() {
        setup:
        def campaignMock = Mock(Campaign)

        when:
        new PurchaseWorkflow(campaignMock)
                .addItem(getBookByTitle("Developer Testing"))
                .usingExistingCustomer(1234567)
                .enterDiscountCode("DEAL");

        then:
        1 * campaignMock.applyDiscount(_ as Long, _ as String, _ as Purchase)
    }

    def "use average mock"() {
        setup:
        def campaignMock = Mock(Campaign)
        def expectedPurchase = new Purchase(getBookByTitle("Refactoring"))

        when:
        new PurchaseWorkflow(campaignMock)
                .addItem(getBookByTitle("Refactoring"))
                .usingExistingCustomer(1234567)
                .enterDiscountCode("WEEKEND DEAL");

        then:
        1 * campaignMock.applyDiscount({ it > 0 }, "WEEKEND DEAL",
                expectedPurchase)
    }

    def "use demanding mock"() {
        setup:
        def campaignMock = Mock(Campaign)

        when:
        new PurchaseWorkflow(campaignMock)
                .usingExistingCustomer(1234567)
                .addItem(getTraining("TDD for dummies (5 days)"))
                .addItem(getBookByTitle("TDD from scratch"))
                .enterDiscountCode("DISCOUNT_123X")
                .enterDiscountCode("DISCOUNT_234Y")
                .enterDiscountCode("DISCOUNT_999Z");

        then:
        3 * campaignMock.applyDiscount(
                { it >= 1000000L && it <= 9999999L },
                { it =~ "DISCOUNT_\\d{3,10}[X-Z]?" },
                { it.getPrice() > 1000 && it.getItemCount() < 5 }
                //{ new PremiumPurchaseMatcher().matches(it) }
        )
    }
}
