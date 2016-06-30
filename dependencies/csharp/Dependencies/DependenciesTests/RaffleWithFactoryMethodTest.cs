using Dependencies;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DependenciesTests
{
    [TestClass]
    public class RaffleWithFactoryMethodTest
    {
        [TestMethod]
        public void RaffleHasFiveTickets()
        {
            var testedRaffle = new FiveTicketRaffle();
            Assert.AreEqual(5, testedRaffle.TicketCount);
        }
    }

    class FiveTicketRaffle : RaffleWithFactoryMethod 
    {
        protected override ISet<int> CreateTickets()
        {
            return new HashSet<int> { 1, 2, 3, 4, 5 };
        }
    }
}
