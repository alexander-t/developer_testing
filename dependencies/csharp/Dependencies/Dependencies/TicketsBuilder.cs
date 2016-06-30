using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dependencies
{
    public class TicketsBuilder
    {
        private int start = 100;
        private int end = 199;

        public TicketsBuilder StartingAt(int start)
        {
            this.start = start;
            return this;
        }

        public TicketsBuilder EndingWith(int end)
        {
            this.end = end;
            return this;
        }

        public ISet<int> Build()
        {
            return new HashSet<int>(Enumerable.Range(1, end - start + 1));
        }
    }
}
