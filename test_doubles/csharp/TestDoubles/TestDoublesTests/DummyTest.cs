using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using TestDoubles.Domain;
using TestDoubles.Logic;

namespace TestDoubles
{
    [TestClass]
    public class DummyTest
    {
        [TestMethod, ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void ShouldFailForTooYoungCustomers()
        {
            int age = 10;
            string ignoredFirstName = "";
            string ignoredLastName = "";
            CustomerVerifier.Verify(age, ignoredFirstName,
                ignoredLastName);
        }
    }
}
