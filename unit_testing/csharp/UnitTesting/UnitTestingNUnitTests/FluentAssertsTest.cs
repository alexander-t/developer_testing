using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UnitTestingNUnitTests
{
    [TestFixture]
    public class FluentAssertsTest
    {
        [Test]
        public void StandardEquality()
        {
            int quantity = 10;
            Assert.AreEqual(10, quantity);
        }

        [Test]
        public void FluentEquality()
        {
            int quantity = 10;
            Assert.That(quantity, Is.EqualTo(10));
        }

        [Test]
        public void StandardStringContaining()
        {
            Assert.IsTrue("Hello World!".Contains("Worlds"));
        }

        [Test]
        public void FluentStringContaining()
        {
            Assert.That("Hello World!", Is.StringContaining("Worlds"));
        }

    }
}
