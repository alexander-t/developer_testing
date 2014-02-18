using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace TestDoubles
{
    [TestClass]
    public class GenericTest
    {
        [TestMethod]
        public void CanonicalTest()
        {
            var testObject 
                = new TestedObject(new Dependency());
            Assert.AreEqual(10, testObject.ComputeSomething());
        }
      
        [TestMethod]
        public void CanonicalTestWithStub()
        {
            var testObject
                = new TestedObject(new DependencyStub());
            Assert.AreEqual(70, testObject.ComputeSomething());
        }

        [TestMethod]
        public void CanonicalTestWithParameterizedStub()
        {
            var testObject
                = new TestedObject(new ParameterizedDependencyStub(7));
            Assert.AreEqual(49, testObject.ComputeSomething());
        }
    }

    class DependencyStub : IDependency
    {
        public int ComputeAndReturnValue()
        {
            return 10;
        }
    }

    class ParameterizedDependencyStub : IDependency
    {
        private int value;
        public ParameterizedDependencyStub(int value)
        {
            this.value = value;
        }

        public int ComputeAndReturnValue()
        {
            return value;
        }
    }


    class ParameterizedDependencyStubV2 : IDependency
    {
        private int value;
        public ParameterizedDependencyStubV2(int value)
        {
            this.value = value;
        }

        public int ComputeAndReturnValue()
        {
            if (value < 10)
            {
                throw new InvalidOperationException();
            }
            return value;
        }
    }
}
