using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Dependencies;

namespace DependenciesTests
{
    [TestClass]
    public class ComputerTest
    {
        [TestMethod]
        public void GetTotalPrice_ThisTestKnowsAboutImplementationDetails()
        {
            Assert.AreEqual(new Money(250), 
                new Computer(new Money(55)).GetTotalPrice());
        }
    }
}
