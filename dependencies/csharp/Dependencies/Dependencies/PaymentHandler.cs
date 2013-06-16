using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dependencies
{
    public class PaymentHandler
    {
        public void DispatchPayment(Payment payment) 
        {
            var now = DateTime.Now;
            if (now.Date.Equals(payment.DueDate))
            {
                ReceiveOnTimePayment(payment);
            }
            else
            { 
                // Handle late and possibly incorrect payments
                // ...
            }
        }

        private void ReceiveOnTimePayment(Payment payment)
        { 
            // Mark payment as paid, balance accounts, etc
        }
    }

 
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
