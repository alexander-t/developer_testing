using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UnitTesting
{
    public class WordCounter
    {
        private IDictionary<string, int> counts = new Dictionary<string, int>();

        public void Add(List<string> words)
        {
            if (words == null)
            {
                throw new ArgumentNullException();
            }

            foreach (var word in words) 
            {
                AddWord(word);
            }
        }

        private void AddWord(string word) 
        { 
            int count = 0;
            counts.TryGetValue(word, out count);
            counts[word] = ++count;
        }

        public List<string> WordCountPairs
        {
            get
            {
                return counts.Select(pair => pair.Key + ":" + pair.Value).OrderBy(x => x).ToList(); 
            }
        }
    }
}
