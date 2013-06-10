using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UnitTesting
{
    public class NaiveWordCounterTest
    {
        public static void Main(string[] args)
        {
            var wc = new WordCounter();
            wc.Add(new List<string> { "CCC", "AAA", "BBB", "AAA" });
            foreach (var p in wc.WordCountPairs)
            {
                Console.WriteLine(p);
            }
        }
    }
}
