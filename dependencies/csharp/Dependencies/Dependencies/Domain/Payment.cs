using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dependencies.Domain
{
    // The implementation details of this class are not interesting
    // All that matters is that it has a date.
    public class Payment
    {
        public DateTime DueDate
        {
            get;
            private set;
        }
    }
}
