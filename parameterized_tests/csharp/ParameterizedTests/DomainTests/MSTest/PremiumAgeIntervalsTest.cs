using Domain;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DomainTests.MSTest
{
    [TestClass]
    public class PremiumAgeIntervalsTest
    {
        public TestContext TestContext { get; set; }

        [TestMethod]
        [DeploymentItem("MSTest\\PremiumFactorTestData.xml")]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.XML",
                           "|DataDirectory|\\MSTest\\PremiumFactorTestData.xml",
                           "Row",
                            DataAccessMethod.Sequential)]
        public void VerifyMultiplePremiumFactors()
        {
            int age = int.Parse((string)TestContext.DataRow["Age"]);
            Gender gender = (Gender)Enum.Parse(typeof(Gender), 
                (string)TestContext.DataRow["Gender"]);
            double expected = double.Parse((string)TestContext.DataRow["PremiumFactor"], 
                CultureInfo.InvariantCulture);
            Assert.AreEqual(expected, ComputePremiumFactor(age, gender)); 
        }

        public double ComputePremiumFactor(int age, Gender gender)
        {
            return new PremiumRuleEngine().GetPremiumFactor(age, gender);
        }

        [TestMethod]
        public void Ter() { 
            Assert.IsTrue(new List<int> { 1, 2, 3, 4, 4 }.SequenceEqual(new IntegerListBuilder().StartingAt(1).EndingWith(5).Build()));
        }
    }

    public class ListWrapper
    {
        private IList<int> wrapped;
        public int WrappedListSize
        {
            get { return wrapped.Count; }
        }
        public ListWrapper(IntegerListBuilder builder)
        {
            wrapped = builder.Build();
        }
    }

    public class IntegerListBuilder
    {
        private int startingAt = 0;
        private int endingWith = 10;
        public IntegerListBuilder StartingAt(int startingAt)
        {
            this.startingAt = startingAt;
            return this;
        }
        
        public IntegerListBuilder EndingWith(int endingWith)
        {
            this.endingWith = endingWith;
            return this;
        }
        
        public IList<int> Build()
        { 
            return Enumerable.Range(startingAt, endingWith).ToList();
        }
    }

}
