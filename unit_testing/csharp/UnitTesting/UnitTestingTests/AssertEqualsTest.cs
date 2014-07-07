using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using UnitTesting;

namespace UnitTestingTests
{
    [TestClass]
    public class AssertEqualsTest
    {
        [TestMethod]
        public void SimpleEquals()
        {
            Assert.AreEqual("Hello World",
                String.Join(" ", new[] { "Hello", "World" }));
            Assert.AreEqual(3, 1 + 2);
            Assert.AreEqual(3.5, 1.5 + 1.99, 0.01);
        }

        [TestMethod]
        public void TwoPersonsWithIdenticalAttributesAreIdentical()
        {
            var aPerson = new Person {
                FirstName = "Adam",
                LastName = "Adamsson",
                Age = 21};
            var anotherPerson = new Person {
                FirstName = "Adam",
                LastName = "Adamsson",
                Age = 21};
            Assert.AreEqual(aPerson, anotherPerson);
        }

    }
}
