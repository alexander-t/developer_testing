using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestDoubles.Domain
{
    public class PurchaseWorkflow
    {
        private IDiscountLogic discountLogic;
        private Purchase purchase = new Purchase();

        public PurchaseWorkflow(IDiscountLogic discountLogic)
        {
            this.discountLogic = discountLogic;
        }

        public void AddItemsStep(params Item[] items)
        {
            foreach (Item item in items)
            {
                purchase.AddItem(item);
            }
        }

        public void DiscountStep()
        {
            discountLogic.ApplyDiscount(1254098L, "DISCOUNT_123", purchase);
        }
    }
}
