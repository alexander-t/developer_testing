package util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ListWrapperWithFactoryMethodTest {
    @Test
    public void tryTestingTheSizeOfAWrappedList() {
        ListWrapperWithFactoryMethod testedListWrapper = new ControlledListWrapper();
        Assert.assertEquals(5, testedListWrapper.getWrappedListSize());
    }

    static class ControlledListWrapper extends ListWrapperWithFactoryMethod {
        @Override
        protected List<Integer> createWrappedList() {
            return Arrays.asList(1, 2, 3, 4, 5);
        }
    }
}
