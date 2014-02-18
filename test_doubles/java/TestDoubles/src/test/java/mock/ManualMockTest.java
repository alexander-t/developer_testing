package mock;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ManualMockTest {

    @Test
    public void useLenientMock() {
        LenientMock lenientMock = new LenientMock();
        new TestedObject(lenientMock).invokeDependency();
        lenientMock.verify();
    }

    @Test
    public void useAverageMock() {
        AverageMock averageMock = new AverageMock(Arrays.asList("a", "b", "c"));
        new TestedObject(averageMock).invokeDependency();
        averageMock.verify();
    }

    @Test
    public void useDemandingMock() {
        DemandingMock demandingMock = new DemandingMock();
        TestedObject testedObject = new TestedObject(demandingMock);
        testedObject.invokeDependency();
        testedObject.invokeDependency();
        testedObject.invokeDependency();
        demandingMock.verify();
    }


    private class LenientMock implements Dependency {

        private boolean wasInvoked;

        @Override
        public void m(String s, long l, Object o) {
            wasInvoked = true;
        }

        public void verify() {
            Assert.assertTrue(wasInvoked);
        }
    }

    private class AverageMock implements Dependency {

        private Object expectedObject;
        private boolean wasInvoked;

        private AverageMock(Object expectedObject) {
            this.expectedObject = expectedObject;
        }

        @Override
        public void m(String s, long l, Object o) {
            Assert.assertEquals("hello", s);
            Assert.assertTrue(l > 0);
            Assert.assertEquals(expectedObject, o);
            wasInvoked = true;
        }

        public void verify() {
            Assert.assertTrue(wasInvoked);
        }
    }

    private class DemandingMock implements Dependency {

        private int timesInvoked;

        @Override
        public void m(String s, long l, Object o) {
            Assert.assertEquals("hello", s);
            Assert.assertEquals(42, l);
            Assert.assertThat(o, new FancyMatcher());
            timesInvoked++;
        }

        public void verify() {
            Assert.assertEquals(3, timesInvoked);
        }
    }

    // This matcher is weird on purpose, but is possibly over-complicated because of the casts
    private class FancyMatcher extends TypeSafeMatcher<Object> {
        @Override
        protected boolean matchesSafely(Object o) {
            if (o instanceof List) {
                for (Object i : (List) o) {
                    if (!(i instanceof String)) {
                        return false;
                    }
                    if (((String) i).length() != 1) {
                        return false;
                    }
                }
                return true;
            }
            return false;

        }

        @Override
        public void describeTo(Description description) {
            description.appendText("A list of strings where each string is one character");
        }
    }

}


