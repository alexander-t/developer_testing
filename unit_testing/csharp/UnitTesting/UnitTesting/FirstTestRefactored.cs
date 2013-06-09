using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UnitTesting
{
    public class FirstTestRefactored
    {
        public static void Main(string[] args)
        {
            var tests = new SpecialCollectionTests();
            tests.SetUp();
            tests.NullArgument();

            tests.SetUp();
            tests.EmptyCollection();

            tests.SetUp();
            tests.OneItem();

            tests.SetUp();
            tests.TwoIdenticalItems();

            tests.SetUp();
            tests.ThreeUnsortedItems();

            tests.SetUp();
            tests.UnsortedAndIdenticalItems();
        }
    }

    class SpecialCollectionTests
    {
        private SpecialCollection sc;
        public void SetUp()
        {
            sc = new SpecialCollection(SortingStrategy.NoDuplicates);
        }

        public void NullArgument()
        {
            try
            {
                sc.Add(null);
                Console.WriteLine("Fails for argument null");
            }
            catch (ArgumentNullException e) { }
        }

        public void EmptyCollection()
        {
            sc.Add(new List<string> { });
            if (!new List<string> { }.SequenceEqual(sc.Sort()))
            {
                Console.WriteLine("Fails for empty list");
            }
        }

        public void OneItem()
        {
            sc.Add(new List<string> { "AAA" });
            if (!new List<string> { "AAA" }.SequenceEqual(sc.Sort()))
            {
                Console.WriteLine("Fails for AAA");
            }
        }

        public void TwoIdenticalItems()
        {
            sc.Add(new List<string> { "AAA", "AAA" });
            if (!new List<string> { "AAA" }.SequenceEqual(sc.Sort()))
            {
                Console.WriteLine("Fails for AAA AAA");
            }
        }

        public void ThreeUnsortedItems()
        {
            sc.Add(new List<string> { "BBB", "AAA", "CCC" });
            if (!new List<string> { "AAA", "BBB", "CCC" }
                .SequenceEqual(sc.Sort()))
            {
                Console.WriteLine("Fails for BBB AAA CCC");
            }
        }

        public void UnsortedAndIdenticalItems()
        {
            sc.Add(new List<string> { "CCC", "AAA", "BBB", "AAA" });
            if (!new List<string> { "AAA", "BBB", "CCC" }
                .SequenceEqual(sc.Sort()))
            {
                Console.WriteLine("Fails for CCC AAA BBB AAA");
            }
        }
    }
}
