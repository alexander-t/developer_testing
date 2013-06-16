using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Dependencies;

namespace DependenciesTests
{
    [TestClass]
    public class ListWrapperTest
    {
        [TestMethod]
        public void TryTestingTheSizeOfAWrappedList()
        {
            var testedListWrapper = new ListWrapper();

            // Fail :(
            Assert.AreEqual(3, testedListWrapper.WrappedListSize);
        }
    }
}
