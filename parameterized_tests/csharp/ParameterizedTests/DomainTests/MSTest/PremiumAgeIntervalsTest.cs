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
    }
}
