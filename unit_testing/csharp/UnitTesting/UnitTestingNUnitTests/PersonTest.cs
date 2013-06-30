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
        public void FailingTestWithDirectConstraint()
        {
            var person = new Person { Age = 12 };
            Assert.That(person, new IsAdultConstraint());
        }

        [Test]
        public void AllValuesAreCopiedFromPersonDtoToNewEntity()
        {
            var personDto = new PersonDTO {
                FirstName = "Adam",
                LastName = "Adamsson",
                Age = 21};

            var expectedPerson = new Person {
                FirstName = "Adam",
                LastName = "Adamsson",
                Age = 21};
            Assert.That(PersonCreator.CreatePersonEntity(personDto), 
                new IsSamePersonConstraint(expectedPerson));
        }
    }
}
