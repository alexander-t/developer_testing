using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Dependencies;

namespace DependenciesTests
{
    [TestClass]
    public class RaffleTest
    {
        [TestMethod]
        public void TryObtainingTheNumberOfTicketsInTheRaffle()
        {
            var testedRaffle = new Raffle();

            // Fail :(
            Assert.AreEqual(3, testedRaffle.TicketCount);
        }
    }
}
