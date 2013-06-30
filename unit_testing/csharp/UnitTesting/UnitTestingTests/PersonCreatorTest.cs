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
            var createdEntity = PersonCreator.CreatePersonEntity(dto);
            Assert.IsNotNull(createdEntity.Id);
            Assert.AreEqual("Adam", createdEntity.FirstName);
            Assert.AreEqual("Adamsson", createdEntity.LastName);
            Assert.AreEqual(21, createdEntity.Age);
            Assert.AreEqual(DateTime.Now.ToShortDateString(), 
                createdEntity.Created.ToShortDateString());
        }
    }
}
