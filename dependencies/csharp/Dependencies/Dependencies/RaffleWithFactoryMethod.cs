using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dependencies
{
    public class RaffleWithFactoryMethod
    {
        private ISet<int> tickets;

        public int TicketCount
        {
            get { return tickets.Count; }
        }
        
        public RaffleWithFactoryMethod() 
        { 
            tickets = CreateTickets();
        }

        protected virtual ISet<int> CreateTickets() 
        {
            return new HashSet<int> { 1, 2, 3 }; 
        }
    }
}
