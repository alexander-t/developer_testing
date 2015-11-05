package tdd

import org.junit.Before
import org.junit.Test

class SearchEngineTest {
    private SearchEngine searchEngine;

    @Before
    void setUp() {
        searchEngine = new SearchEngine()
    }

    @Test
    void searchingWhenNoDocumentsAreIndexedGivesNothing() {
        assert [] == searchEngine.find("fox")
    }

    @Test
    void searchingForAWordInADocumentContainingOnlyThatWordGivesThatDocumentsId() {
        searchEngine.addToIndex(1, "fox")
        assert [1] == searchEngine.find("fox")
    }

    @Test
    void searchingForAWordThatMatchesOneOutOfTwoDocumentsGivesTheMatchingDocumentsId() {
        searchEngine.addToIndex(1, "fox")
        searchEngine.addToIndex(2, "dog")
        assert [2] == searchEngine.find("dog")
    }

    @Test
    public void documentsMayContainMoreThanOneWord() {
        searchEngine.addToIndex(1, "the quick brown fox")
        searchEngine.addToIndex(2, "jumped over the lazy dog")
        assert [1] == searchEngine.find("fox")
        assert [2] == searchEngine.find("dog")
    }

    @Test
    void searchingForAWordThatMatchesTwoDocumentsGivesBothDocumentsIds() {
        searchEngine.addToIndex(1, "fox")
        searchEngine.addToIndex(2, "fox")
        assert [1, 2] == searchEngine.find("fox")
    }

    @Test
    public void searchingForWordThatOccursMultipleTimesInADocumentGivesThatDocumentIdOnce() {
        searchEngine.addToIndex(1, "the quick brown fox jumped over the lazy dog")
        assert [1] == searchEngine.find("the")
    }

    @Test
    public void documentsAreSortedByWordFrequency() {
        searchEngine.addToIndex(1, "fox fox dog")
        searchEngine.addToIndex(2, "fox fox fox")
        searchEngine.addToIndex(3, "dog fox dog")
        assert [2, 1, 3] == searchEngine.find("fox")
        assert [3, 1] == searchEngine.find("dog")
    }

    @Test
    public void caseDoesNotMatter() {
        searchEngine.addToIndex(1, "FOX fox FoX");
        searchEngine.addToIndex(2, "foX FOx");
        searchEngine.addToIndex(3, "FoX");
        assert [1, 2, 3] == searchEngine.find("fox")
        assert [1, 2, 3] == searchEngine.find("FOX")
    }

    @Test
    public void punctuationMarksAreIgnored() {
        searchEngine.addToIndex(1, "quick, brown: fox.");
        searchEngine.addToIndex(2, "(quick) [brown] \"fox\" 'dog'");
        searchEngine.addToIndex(3, "quick; -brown fox? dog!");
        assert [1, 2, 3] == searchEngine.find("quick").sort()
        assert [1, 2, 3] == searchEngine.find("brown").sort()
        assert [1, 2, 3] == searchEngine.find("fox").sort()
        assert [2, 3] == searchEngine.find("dog").sort()
    }
}