using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace UnitTestingTests
{
    [TestClass]
    public class TestSnippets
    {
        // Shows the concept of "guard assertion"
        [TestMethod]
        public void DemonstrateGuardAssertion()
        {
            var customerAddress = new Address();
            var orderDetails = new OrderRepository().QueryForOrder(1234567);
            Assert.IsNotNull(orderDetails);
            Assert.AreEqual(customerAddress.StreetName, orderDetails.ShippingAddress.StreetName);
        }
    }

    class OrderRepository
    {
        public OrderDetails QueryForOrder(long orderId)
        {
            return new OrderDetails();
        }
    }

    class OrderDetails
    { 
        public Address ShippingAddress {get; set; }
    }

    class Address
    {
        public string StreetName { get; set; }
    }
}
