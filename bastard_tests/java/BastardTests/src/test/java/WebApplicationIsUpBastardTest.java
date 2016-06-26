import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
 * This is "fast" test. It's definitively not a unit test. It starts a server, deploys a
 * web application and fetches a page. But... it runs in 2 seconds on a fast machine.
 * Don't get deceived by such tests.
 */
public class WebApplicationIsUpBastardTest {

    private static Server server;

    @BeforeClass
    public static void setUpOnce() throws Exception {
        server = new Server(8080);
        final String pathToWarFile
                = "<war file location>";
        server.setHandler(new WebAppContext(pathToWarFile, "/webapp"));
        server.start();
    }

    @Test
    public void applicationIsUp() throws Exception {
        HtmlPage mainPage = new WebClient()
                .getPage("http://localhost:8080/webapp");

        assertEquals("Fancy application", mainPage.getTitleText());
    }

    @AfterClass
    public static void tearDownOnce() throws Exception {
        server.stop();
    }
}
