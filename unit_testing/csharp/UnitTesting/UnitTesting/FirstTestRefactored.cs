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
            var tests = new WordCounterTests();
            tests.SetUp();
            tests.NullArgument();

            tests.SetUp();
            tests.NoWords();

            tests.SetUp();
            tests.OneWord();

            tests.SetUp();
            tests.TwoIdenticalWords();

            tests.SetUp();
            tests.ThreeDifferentWords();

            tests.SetUp();
            tests.TwoIdenticalAndTwoDifferentWords();
        }
    }

    class WordCounterTests
    {
        private WordCounter wc;
        public void SetUp()
        {
            wc = new WordCounter();
        }

        public void NullArgument()
        {
            try
            {
                wc.Add(null);
                Console.WriteLine("Fails for argument null");
            }
            catch (ArgumentNullException e) { }
        }

        public void NoWords()
        {
            wc.Add(new List<string> { });
            if (!new List<string> { }
                .SequenceEqual(wc.WordCountPairs))
            {
                Console.WriteLine("Fails for empty list");
            }
        }

        public void OneWord()
        {
            wc.Add(new List<string> { "AAA" });
            if (!new List<string> { "AAA:1" }
                .SequenceEqual(wc.WordCountPairs))
            {
                Console.WriteLine("Fails for AAA");
            }
        }

        public void TwoIdenticalWords()
        {
            wc.Add(new List<string> { "AAA", "AAA" });
            if (!new List<string> { "AAA:2" }
                .SequenceEqual(wc.WordCountPairs))
            {
                Console.WriteLine("Fails for AAA AAA");
            }
        }

        public void ThreeDifferentWords()
        {
            wc.Add(new List<string> { "BBB", "AAA", "CCC" });
            if (!new List<string> { "AAA:1", "BBB:1", "CCC:1" }
                .SequenceEqual(wc.WordCountPairs))
            {
                Console.WriteLine("Fails for BBB AAA CCC");
            }
        }

        public void TwoIdenticalAndTwoDifferentWords()
        {
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
