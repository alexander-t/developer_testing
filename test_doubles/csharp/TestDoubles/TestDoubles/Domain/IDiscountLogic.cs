using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestDoubles.Domain
{
    public interface IDiscountLogic
    {
        void ApplyDiscount(long customerNumber, string discountCode, Purchase purchase);
    }
}
