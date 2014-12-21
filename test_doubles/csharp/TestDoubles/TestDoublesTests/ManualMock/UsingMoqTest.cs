using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using TestDoubles.Domain;
using Moq;

namespace TestDoubles
{
    [TestClass]
    public class UsingMoqTest
    {
        [TestMethod]
        public void UseLenientMock()
        {
            var lenientMock = new Mock<IDiscountLogic>();
            new PurchaseWorkflow(lenientMock.Object)
                .DiscountStep();

            lenientMock.Verify(lm => lm.ApplyDiscount(
                It.IsAny<long>(),
                It.IsAny<string>(), It.IsAny<Purchase>()));
        }

        [TestMethod]
        public void UseAverageMock()
        {
            var averageMock = new Mock<IDiscountLogic>();
            var expectedPurchase = new Purchase();
            expectedPurchase.AddItem(new Item(400));

            var purchaseWorkflow
                = new PurchaseWorkflow(averageMock.Object);
            purchaseWorkflow.AddItemsStep(new Item(400));
            purchaseWorkflow.DiscountStep();

            averageMock.Verify(am => am.ApplyDiscount(
                It.IsInRange(1, long.MaxValue,
                Range.Inclusive),
                "DISCOUNT_123",
                It.Is<Purchase>(p => p.Equals(expectedPurchase))));
        }


        [TestMethod]
        public void UseDemandingMock()
        {
            var demandingMock = new Mock<IDiscountLogic>();
            var expectedPurchase = new Purchase();
            expectedPurchase.AddItem(new Item(400));
            expectedPurchase.AddItem(new Item(650));

            var purchaseWorkflow
                = new PurchaseWorkflow(demandingMock.Object);
            purchaseWorkflow.AddItemsStep(new Item(400),
                new Item(650));
            purchaseWorkflow.DiscountStep();
            purchaseWorkflow.DiscountStep();
            purchaseWorkflow.DiscountStep();

            demandingMock.Verify(am => am.ApplyDiscount(
                It.IsInRange(1000000L, 9999999L, 
                Range.Inclusive),
                It.IsRegex("DISCOUNT_\\d{3,10}[X-Z]?"),
                It.Is<Purchase>(p => IsPremiumPurchase(p))),
                Times.Exactly(3));
        }

        private bool IsPremiumPurchase(Purchase purchase)
        {
            return purchase.Price > 1000
                && purchase.ItemCount < 5;
        }
    }
}
