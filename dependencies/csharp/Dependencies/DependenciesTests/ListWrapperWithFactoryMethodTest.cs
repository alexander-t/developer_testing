using Dependencies;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DependenciesTests
{
    [TestClass]
    public class ListWrapperWithFactoryMethodTest
    {
        [TestMethod]
        public void TryTestingTheSizeOfAWrappedList()
        {
            var testedListWrapper = new ControlledListWrapper();
            Assert.AreEqual(5, testedListWrapper.WrappedListSize);
        }
    }

    class ControlledListWrapper : ListWrapperWithFactoryMethod 
    {
        protected override IList<int> CreateWrappedList()
        {
            return new List<int> { 1, 2, 3, 4, 5 };
        }
    }
}
