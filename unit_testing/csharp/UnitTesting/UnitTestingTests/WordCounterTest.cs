using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using UnitTesting;
using System.Collections.Generic;

namespace UnitTestingTests
{
    [TestClass]
    public class WordCounterTest
    {
        [TestMethod]
        public void TwoIdenticalAndTwoDifferentWords_ThreeDistinctWords()
        {
            // Arrange
            var wc  = new WordCounter();
            
            // Act
            wc.Add(new List<string> { "CCC", "AAA", 
                "BBB", "AAA" });
            var countedWords = wc.WordCountPairs.Count;
            
            // Assert
            Assert.AreEqual(3, countedWords);
        }
    }
}
