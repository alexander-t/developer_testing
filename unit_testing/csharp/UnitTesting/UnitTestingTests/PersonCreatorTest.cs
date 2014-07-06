using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using UnitTesting;

namespace UnitTestingTests
{
    [TestClass]
    public class PersonCreatorTest
    {
        [TestMethod]
        public void CreatePerson_ValidEntity_FieldsAreCopiedDefaultsAreSet()
        {
            var dto = new PersonDTO { 
                FirstName = "Adam", 
                LastName = "Adamsson", 
                Age = 21 };
            var newEntity 
                = PersonCreator.CreatePersonEntity(dto);
            Assert.IsNotNull(newEntity.Id);
            Assert.AreEqual("Adam", newEntity.FirstName);
            Assert.AreEqual("Adamsson", newEntity.LastName);
            Assert.AreEqual(21, newEntity.Age);
            Assert.AreEqual(DateTime.Now.ToShortDateString(), 
                newEntity.Created.ToShortDateString());
        }
    }
}
