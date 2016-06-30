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
    public class RaffleWithBuilderTest 
    {
        [TestMethod]
        public void RaffleHasFiveTickets()
        {
            var builder = new TicketsBuilder().StartingAt(1).EndingWith(5);
            Raffle testedRaffle = new Raffle(builder);
            Assert.AreEqual(5, testedRaffle.TicketCount);
        }
    }
}
