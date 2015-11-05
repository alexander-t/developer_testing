package tdd

class SearchEngine {
    Map<String, List<WordFrequency>> index = [:]

    void addToIndex(int documentId, String contents) {
        preProcessDocument(contents).split(" ").each { word ->
            bumpWordFrequencyForDocument(index.get(word, []), documentId)
        }
        resortIndexOnWordFrequency()
    }

    private String preProcessDocument(String contents) {
        return contents.replaceAll("[\\.,!\\?:;\\(\\)\\[\\]\\-\"']", "").toUpperCase()
    }

    private void bumpWordFrequencyForDocument(List<WordFrequency> frequencies, int documentId) {
        def wordFrequency = frequencies.find { wf -> wf.documentId == documentId }
        if (!wordFrequency) {
            frequencies << (wordFrequency = new WordFrequency(documentId))
        }
        wordFrequency.count++
    }

    private resortIndexOnWordFrequency() {
        index.each { k, wfs -> wfs.sort { wf1, wf2 -> wf2.count <=> wf1.count } }
    }

    List<Integer> find(String word) {
        return index.get(word.toUpperCase(), [])
                .collect { wf -> wf.documentId }
    }
}

class WordFrequency {
    int documentId
    int count

    WordFrequency(int documentId) {
        this.documentId = documentId
    }
}

