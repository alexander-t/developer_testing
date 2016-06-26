using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Moq;

namespace MockingFrameworks.MoqSyntax
{
    // This class doesn't contain any real tests. The code in here is used to verify that
    // the samples compile correctly. 
    [TestClass]
    public class MoqSyntax
    {

        [TestMethod]
        public void DemonstrateTheItClass()
        {
            var dependencyStub = new Mock<IDependency>();
            dependencyStub.Setup(d => d.ComputeAndReturnAnotherValue(It.IsAny<int>())).Returns(10);
            Assert.AreEqual(10, dependencyStub.Object.ComputeAndReturnAnotherValue(22));
        }

        [TestMethod]
        public void DemonstrateImplicitEquals()
        {
            var dependencyStub = new Mock<IDependency>();
            dependencyStub.Setup(d => d.ComputeAndReturnAnotherValue(42)).Returns(10);

            Assert.AreEqual(10, dependencyStub.Object.ComputeAndReturnAnotherValue(42));
            Assert.AreEqual(0, dependencyStub.Object.ComputeAndReturnAnotherValue(43));
        }

        [TestMethod]
        public void DemonstrateConsecutiveStubbing()
        {
            var dependencyStub = new Mock<IDependency>();
            dependencyStub.SetupSequence(d => d.ComputeAndReturnAnotherValue(42)).Returns(10).Returns(99);

            Assert.AreEqual(10, dependencyStub.Object.ComputeAndReturnAnotherValue(42));
            Assert.AreEqual(99, dependencyStub.Object.ComputeAndReturnAnotherValue(42));
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void DemonstrateThrowingAnException()
        {
            var dependencyStub = new Mock<IDependency>();
            dependencyStub.Setup(d => d.ComputeAndReturnAnotherValue(42))
                .Throws(new ArgumentException("42 isn't the answer!"));

            dependencyStub.Object.ComputeAndReturnAnotherValue(42);
        }

        [TestMethod]
        public void VerifyPropertyRead()
        {
            var testedObjectMock = new Mock<ITestedObject>();
            String s = testedObjectMock.Object.Value;
            testedObjectMock.VerifyGet(t => t.Value);
        }
    }

    public interface ITestedObject
    {
        String Value { get; set; }
    }

    public interface IDependency
    {
        int ComputeAndReturnAnotherValue(int arg);
    }
}
