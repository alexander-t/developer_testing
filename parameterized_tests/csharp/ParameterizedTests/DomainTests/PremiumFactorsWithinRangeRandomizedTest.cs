using Domain;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DomainTests
{
    class PremiumFactorsWithinRangeRandomizedTest
    {
        [Test]
        public void PremiumFactorsAreBetween0_5and2_0(
            [Values(Gender.Female, Gender.Male)] Gender gender,
            [Random(18, 100, 100)] int age) 
        {
            double premiumFactor
                    = new PremiumRuleEngine().GetPremiumFactor(age, gender);
             Assert.That(premiumFactor, Is.InRange(0.5, 2.0));
        }
    }
}
