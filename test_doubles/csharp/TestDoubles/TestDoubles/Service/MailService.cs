using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace TestDoubles.Service
{
    public class MailService
    {
        internal void SendInvoice(Domain.Customer customer, Domain.Invoice invoice)
        {
            throw new NotImplementedException();
        }
    }
}
