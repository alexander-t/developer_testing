using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using UnitTesting;
using System.Collections.Generic;

namespace UnitTestingTests
{
    [TestClass]
    public class NameUtilsTest
    {
        [TestMethod]
        public void CollectFirstNames_ThreePersons_ResultContainsThreeNames()
        {
            var adam = new Person {
                FirstName = "Adam",
                LastName = "Adamsson",
                Age = 21};
            var bertil = new Person {
                FirstName = "Bertil",
                LastName = "Bertilsson",
                Age = 22};
            var cecil = new Person {
                FirstName = "Cecil",
                LastName = "Cecilsson",
                Age = 23};

            var actual = NameUtils.CollectFirstNames(
                new List<Person>() { adam, bertil, cecil });
            var expected = adam.FirstName + "," + bertil.FirstName
                + "," + cecil.FirstName;
            //var expected = "Adam,Bertil,Cecil";
            Assert.AreEqual(expected, actual);
        }
    }
}
