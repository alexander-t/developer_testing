using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestDoubles
{
    public class Dependency : IDependency
    {
        public int ComputeAndReturnValue() {

            // Complex computation starts here
            // ...
            // 50 lines of code
            // ...
            // Complex computation ends here
            return 42;
        }
    }
}
