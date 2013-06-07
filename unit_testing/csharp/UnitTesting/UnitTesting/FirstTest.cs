using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UnitTesting
{
    public class FirstTest
    {
        public static void Main(string[] args)
        {
            SpecialCollection sc = new SpecialCollection(SortingStrategy.RemoveDuplicates);
            try
            {
                sc.Add(null);
                Console.WriteLine("Fails for argument null");
            }
            catch (ArgumentNullException e) { }

            sc = new SpecialCollection(SortingStrategy.RemoveDuplicates);
            sc.Add(new List<string> { });
            if (!new List<string> { }.SequenceEqual(sc.Sort()))
            {
                Console.WriteLine("Fails for empty list");
            }

            sc = new SpecialCollection(SortingStrategy.RemoveDuplicates);
            sc.Add(new List<string> { "AAA" });
            if (!new List<string> { "AAA" }.SequenceEqual(sc.Sort()))
            {
                Console.WriteLine("Fails for AAA");
            }

            sc = new SpecialCollection(SortingStrategy.RemoveDuplicates);
            sc.Add(new List<string> { "AAA", "AAA" });
            if (!new List<string> { "AAA" }.SequenceEqual(sc.Sort()))
            {
                Console.WriteLine("Fails for AAA AAA");
            }

            sc = new SpecialCollection(SortingStrategy.RemoveDuplicates);
            sc.Add(new List<string> { "BBB", "AAA", "CCC" });
            if (!new List<string> { "AAA", "BBB", "CCC" }.SequenceEqual(sc.Sort()))
            {
                Console.WriteLine("Fails for BBB AAA CCC");
            }

            sc = new SpecialCollection(SortingStrategy.RemoveDuplicates);
            sc.Add(new List<string> { "CCC", "AAA", "BBB", "AAA" });
            if (!new List<string> { "AAA", "BBB", "CCC" }.SequenceEqual(sc.Sort()))
            {
                Console.WriteLine("Fails for CCC AAA BBB AAA");
            }
        }
    }
}
