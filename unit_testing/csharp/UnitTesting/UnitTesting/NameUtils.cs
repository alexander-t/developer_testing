using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UnitTesting
{
    public class NameUtils
    {

        private const int maxNameLength = 10;

        public static string CollectFirstNames(List<Person> persons)
        {
            persons.ForEach(p => p.FirstName 
                = p.FirstName.ToUpper());
            return string.Join(",", persons.Select(p => p.FirstName));
        }
    }
}
