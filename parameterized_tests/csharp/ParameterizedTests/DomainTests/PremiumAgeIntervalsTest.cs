using Domain;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DomainTests
{
    class PremiumAgeIntervalsTest
    {
        [TestCase(18, Gender.Male, Result = 1.75)]
        [TestCase(23, Gender.Male, Result = 1.75)]
        [TestCase(24, Gender.Male, Result = 1.0)]
        // ...
        public double VerifyPremiumFactor(int age, Gender gender)
        { 
            return new PremiumRuleEngine().GetPremiumFactor(age, gender);
        }
    }
}
