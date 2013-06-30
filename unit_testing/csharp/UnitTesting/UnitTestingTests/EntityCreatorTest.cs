using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using UnitTesting;

namespace UnitTestingTests
{
    [TestClass]
    public class EntityCreatorTest
    {
        [TestMethod]
        public void CreateEntity_ValidEntity_FieldsAreCopiedAndDefaultsAreSet()
        {
            var dto = new EntityDTO { Attribute1 = "v1", Attribute2 = 10 };
            var createdEntity = EntityCreator.CreateEntity(dto);
            Assert.IsNotNull(createdEntity.Id);
            Assert.AreEqual("v1", createdEntity.Attribute1);
            Assert.AreEqual(10, createdEntity.Attribute2);
            Assert.AreEqual(DateTime.Now.ToShortDateString(), 
                createdEntity.Created.ToShortDateString());
        }
    }
}
