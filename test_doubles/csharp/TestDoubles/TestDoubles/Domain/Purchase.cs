using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace TestDoubles.Domain
{
    public class Purchase
    {
        private List<Item> items = new List<Item>();

        public double Price 
        {
            get { 
                return items.Aggregate(0.0, (total, next) => total += next.Price);
            }
        }

        public int ItemCount { get { return items.Count; } }
        
        public void AddItem(Item item)
        {
            items.Add(item);    
        }

        public override bool Equals(Object o)
        {
            if (o == null || GetType() != o.GetType())
                return false;

            Purchase that = (Purchase)o;
            return items.SequenceEqual(that.items);
        }

        public override int GetHashCode()
        {
            return items.GetHashCode();
        }
    }
}
