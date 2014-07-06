using NUnit.Framework.Constraints;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UnitTesting;

namespace UnitTestingNUnitTests.CustomConstraints
{
    public class IsSamePersonConstraint : Constraint
    {
        private Person expected;
        public IsSamePersonConstraint(Person expected)
        {
            this.expected = expected;
        }

        public override void WriteDescriptionTo(MessageWriter writer)
        {
            writer.Write(describePerson(expected));
        }

        public override void WriteActualValueTo(MessageWriter writer)
        {
            if (actual is Person)
            {
                writer.Write(describePerson((Person)actual));
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
                return expected.FirstName == person.FirstName
                    && expected.LastName == person.LastName
                    && expected.Age == person.Age;
            }
            return false;
        }

        private string describePerson(Person p)
        {
            return p.FirstName + " " + p.LastName 
                + ", age: " + p.Age;
        }
    }

}
