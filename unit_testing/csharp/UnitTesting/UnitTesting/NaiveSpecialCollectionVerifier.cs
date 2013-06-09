using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UnitTesting
{
    public class NaiveSpecialCollectionVerifier
    {
        public static void Main(string[] args)
        {
            var sc = new SpecialCollection(SortingStrategy.NoDuplicates);
            sc.Add(new List<string> { "CCC", "AAA", "BBB", "AAA" });
            foreach (var s in sc.Sort())
            {
                Console.WriteLine(s);
            }
        }
    }
}
