using NUnit.Framework.Constraints;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UnitTesting;
using UnitTestingNUnitTests.CustomConstraints;
using NUnit.Framework;

namespace UnitTestingNUnitTests
{
    [TestFixture]
    public class PersonTest
    {
        [Test]
        public void PersonAged45_IsAnAdult()
        {
            var person = new Person { Age = 45 };
            Assert.That(person, Aged.Adult);
        }

        [Test]
        public void FailingTest()
        {
            var person = new Person { Age = 12 };
            Assert.That(person, Aged.Adult);
        }

        [Test]
        public void FailingTestWithDirectConstrint()
        {
            var person = new Person { Age = 12};
            Assert.That(person, new IsAdultConstraint());
        }

    }
}
