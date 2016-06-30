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
    public class RaffleWithConstructorInjectionTest
    {
        [TestMethod]
        public void RaffleHasFiveTickets()
        {
            var testedRaffle = new Raffle(new HashSet<int> { 1, 2, 3, 4, 5 });
            Assert.AreEqual(5, testedRaffle.TicketCount);
        }
    }
}
