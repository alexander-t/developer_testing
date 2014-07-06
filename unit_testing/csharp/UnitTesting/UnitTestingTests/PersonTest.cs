using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using UnitTesting;

namespace UnitTestingTests
{
    [TestClass]
    public class PersonTest
    {
        [TestMethod]
        public void PersonAged45_IsAnAdult()
        {
            var person = new Person { Age = 45 };
            Assert.IsTrue(person.Age >= 18 
                && person.Age < 65);
        }
    }
}
