using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dependencies
{
    public class PaymentHandlerWithTimeSource
    {
        public ITimeSource TimeSource { get; set; }

        public void DispatchPayment(Payment payment) 
        {
            var now = TimeSource.Now;
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

    public interface ITimeSource
    {
        DateTime Now {
            get;
        }
    }
}
