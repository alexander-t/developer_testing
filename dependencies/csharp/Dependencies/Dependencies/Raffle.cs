using DependenciesTests;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dependencies
{
    public class Raffle
    {
        private ISet<int> tickets;

        public int TicketCount
        {
            get { return tickets.Count; }
        }

        public Raffle()
        {
            tickets = new HashSet<int> { 3, 10, 6 };
        }

        // Used to demonstrate constructor injection
        public Raffle(ISet<int> tickets)
        {
            this.tickets = new HashSet<int>(tickets);
        }

        // Used to demonstrate factory
        public Raffle(TicketsFactory ticketsFactory)
        {
            this.tickets = ticketsFactory.CreateTickets();
        }

        // Used to demonstrate the builder
        public Raffle(TicketsBuilder ticketsBuilder)
        {
            this.tickets = ticketsBuilder.Build();
        }
    }
}
