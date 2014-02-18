using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using TestDoubles.Domain;

namespace TestDoubles.Repository
{
    public class PurchaseRepository
    {
        public Purchase CreatePurchase(Customer customer)
        {
            // Here a new purchase would be created in the database
            return new Purchase();
        }

        public void AddProduct(Purchase purchase, Product product)
        {
            
        }

        public Invoice CreateInvoice(Purchase purchase)
        {
            return new Invoice();
        }

        public Invoice CreateInvoice(Customer customer, IList<Product> products)
        {
            throw new NotImplementedException();
        }
    }
}
