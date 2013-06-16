using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dependencies
{
    public class ListWrapper
    {
        private IList<int> wrapped;

        public int WrappedListSize
        {
            get { return wrapped.Count; }
        }

        public ListWrapper()
        {
            wrapped = new List<int> { 1, 2, 3 };
        }

    }
}
