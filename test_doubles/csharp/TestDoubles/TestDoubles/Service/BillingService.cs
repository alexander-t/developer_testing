using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TestDoubles.Domain;
using TestDoubles.Repository;

namespace TestDoubles.Service
{
    public class BillingService
    {
        private CustomerRepository customerRepository;
        private PurchaseRepository purchaseRepository;
        private MailService mailService;

        public void ChargeCustomer(CustomerId customerId,
                               IList<Product> products)
        {
            var customer
                    = customerRepository.GetCustomer(customerId);
            var invoice
                    = purchaseRepository.CreateInvoice(customer, products);
            mailService.SendInvoice(customer, invoice);
        }
    }
}
