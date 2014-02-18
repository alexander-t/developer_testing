using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TestDoubles.Domain;
using TestDoubles.Repository;

namespace TestDoubles
{
    public class PurchaseService
    {
        private PurchaseRepository purchaseRepository;

        public Invoice MakePurchase(Customer customer, 
            Product product, Discount discount)
        {
            var purchase 
                = purchaseRepository.CreatePurchase(customer);
            purchaseRepository.AddProduct(purchase, product);
            var invoice 
                = purchaseRepository.CreateInvoice(purchase);

            if (discount != null)
            {
                invoice.ApplyDiscount(discount);
            }
            return invoice;
        }
    }
}
