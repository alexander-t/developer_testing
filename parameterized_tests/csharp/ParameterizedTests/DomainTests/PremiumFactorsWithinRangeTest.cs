using Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;

namespace DomainTests
{
    public class PremiumFactorsWithinRangeTest
    {
        [Datapoints]
        public Gender[] genders
                = new Gender[]{Gender.Female,
                Gender.Male, Gender.Unknown};

        [Datapoints]
        public int[] ages
                = new int[]{17, 18, 19, 23, 24, 25,
            59, 60, 61, 100, 101};

        [Theory]
        public void PremiumFactorsAreBetween0_5and2_0(Gender gender, int age)
        {
            Assume.That(age, Is.GreaterThanOrEqualTo(18));
            Assume.That(age, Is.LessThanOrEqualTo(100));
            Assume.That(gender == Gender.Female || gender == Gender.Male);
            double premiumFactor
                    = new PremiumRuleEngine().GetPremiumFactor(age, gender);
            Assert.That(premiumFactor, Is.InRange(0.5, 2.0));
        }
    }
}
