using NUnit.Framework;
using NUnit.Framework.Constraints;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UnitTesting;

namespace UnitTestingNUnitTests.CustomConstraints
{
    public static class Aged
    {
        public static IsAdultConstraint Adult
        {
            get { return new IsAdultConstraint(); }
        }
    }
}
