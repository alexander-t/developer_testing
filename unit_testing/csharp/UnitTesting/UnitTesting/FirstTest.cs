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
            var wc = new WordCounter();
            try
            {
                wc.Add(null);
                Console.WriteLine("Fails for null");
            }
            catch (ArgumentNullException e) { }

            wc = new WordCounter();
            wc.Add(new List<string> { });
            if (!new List<string> { }
                .SequenceEqual(wc.WordCountPairs))
            {
                Console.WriteLine("Fails for empty list");
            }

            wc = new WordCounter();
            wc.Add(new List<string> { "AAA" });
            if (!new List<string> { "AAA:1" }
                .SequenceEqual(wc.WordCountPairs))
            {
                Console.WriteLine("Fails for AAA");
            }

            wc = new WordCounter();
            wc.Add(new List<string> { "AAA", "AAA" });
            if (!new List<string> { "AAA:2" }
                .SequenceEqual(wc.WordCountPairs))
            {
                Console.WriteLine("Fails for AAA AAA");
            }

            wc = new WordCounter();
            wc.Add(new List<string> { "BBB", "AAA", "CCC" });
            if (!new List<string> { "AAA:1", "BBB:1", "CCC:1" }
                .SequenceEqual(wc.WordCountPairs))
            {
                Console.WriteLine("Fails for BBB AAA CCC");
            }

            wc = new WordCounter();
            wc.Add(new List<string> { "CCC", "AAA", 
                "BBB", "AAA" });
            if (!new List<string> { "AAA:2", "BBB:1", "CCC:1" }
                .SequenceEqual(wc.WordCountPairs))
            {
                Console.WriteLine("Fails for CCC AAA BBB AAA");
            }
        }
    }
}
