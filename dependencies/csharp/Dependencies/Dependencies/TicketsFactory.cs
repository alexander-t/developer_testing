using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DependenciesTests
{
    public class TicketsFactory
    {
        private int numberOfTickets;

        public TicketsFactory(int numberOfTickets) 
        {
            this.numberOfTickets = numberOfTickets;
        }

        public ISet<int> CreateTickets() {
            return new HashSet<int>(Enumerable.Range(1, numberOfTickets));
        }
    }
}
