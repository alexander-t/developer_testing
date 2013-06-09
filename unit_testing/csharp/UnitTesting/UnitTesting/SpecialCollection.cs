using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UnitTesting
{
    public class SpecialCollection
    {
        private List<string> container = new List<string>();
        public SpecialCollection(SortingStrategy strategy)
        {
            // Just ignore the argument. The code isn't supposed to work anyway.
        }

        public void Add(List<string> elements)
        {
            if (elements == null)
            {
                throw new ArgumentNullException();
            }
            container.AddRange(elements);
        }

        public List<string> Sort()
        {
            return container.Distinct().OrderBy(x => x).ToList();
        }
    }

    public enum SortingStrategy
    {
        NoDuplicates
    }
}
