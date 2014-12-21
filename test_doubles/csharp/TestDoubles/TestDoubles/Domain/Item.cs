using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestDoubles.Domain
{
    public class Item
    {
        private double price;
        public double Price { get { return price; } }

        public Item(double price)
        {
            this.price = price;
        }

        public override bool Equals(Object o)
        {
            if (o == null || GetType() != o.GetType())
                return false;

            Item that = (Item) o;
            return (price == that.price);
        }

        public override int GetHashCode()
        {
            return price.GetHashCode();
        }
    }
}
