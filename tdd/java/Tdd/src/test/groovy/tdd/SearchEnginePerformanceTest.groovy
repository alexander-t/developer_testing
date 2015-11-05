package tdd

import org.junit.Test

import java.nio.charset.Charset
import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.SimpleFileVisitor
import java.nio.file.attribute.BasicFileAttributes
import java.util.logging.Logger


class SearchEnginePerformanceTest {

    private static final Logger LOGGER = Logger.getLogger(SearchEnginePerformanceTest.class.getName());

    private SearchEngine searchEngine = new SearchEngine();

    @Test
    public void manualTest_indexABunchOfFilesAndSearchForCommonWords() {

        long t1 = System.currentTimeMillis()
        Files.walkFileTree(Paths.get("d:\\textfiles"), new GetFiles())
        long t2 = System.currentTimeMillis()
        LOGGER.info("Time to build index: " + (t2 - t1))

        t1 = System.currentTimeMillis()
        System.out.println(searchEngine.find("the"))
        System.out.println(searchEngine.find("a"))
        System.out.println(searchEngine.find("you"))
        System.out.println(searchEngine.find("holmes"))
        t2 = System.currentTimeMillis()
        LOGGER.info("Time to perform lookups: " + (t2 - t1))
    }

    class GetFiles extends SimpleFileVisitor<Path> {

        int documentId = 1;

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
            if (attr.isRegularFile() && file.toString().endsWith(".txt")) {
                LOGGER.info("Added " + documentId + ": " + file)
                List<String> lines = Files.readAllLines(file, Charset.defaultCharset())
                searchEngine.addToIndex(documentId++, lines.join(" "))
            }
            return FileVisitResult.CONTINUE;
        }
    }

}
