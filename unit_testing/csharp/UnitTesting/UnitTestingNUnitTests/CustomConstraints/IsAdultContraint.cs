using NUnit.Framework.Constraints;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UnitTesting;

namespace UnitTestingNUnitTests.CustomConstraints
{
    public class IsAdultConstraint : Constraint
    {
        public override void WriteDescriptionTo(MessageWriter writer)
        {
            writer.Write("a person of age 18 to 65");
        }

        public override void WriteActualValueTo(MessageWriter writer)
        {
            if (actual is Person)
            {
                writer.Write("a person aged " 
                    + ((Person)actual).Age);
            }
            else
            {
                base.WriteActualValueTo(writer);
            }
        }

        public override bool Matches(object actual)
        {
            base.actual = actual;
            if (actual is Person)
            {
                var person = (Person)actual;
                return person.Age >= 18 
                    && person.Age < 65;
            }
            return false;
        }
    }
}
