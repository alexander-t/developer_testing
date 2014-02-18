using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestDoubles
{
    public class TestedObject
    {
        private IDependency dependency;

        public TestedObject(IDependency dependency) 
        {
            this.dependency = dependency;
        }

        public int ComputeSomething() 
        {
            return 42 * dependency.ComputeAndReturnValue();
        }
    }
}
