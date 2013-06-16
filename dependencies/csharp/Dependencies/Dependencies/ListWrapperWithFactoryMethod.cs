using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dependencies
{
    public class ListWrapperWithFactoryMethod
    {
        private IList<int> wrapped;

        public int WrappedListSize
        {
            get { return wrapped.Count; }
        }
        
        public ListWrapperWithFactoryMethod() 
        { 
            wrapped = CreateWrappedList();
        }

        protected virtual IList<int> CreateWrappedList() 
        {
            return new List<int> { 1, 2, 3 }; 
        }
    }
}
