package util;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListWrapperWithFactoryMethodTest {
    @Test
    public void tryTestingTheSizeOfAWrappedList() {
        ListWrapperWithFactoryMethod testedListWrapper
                = new ListWrapperWithFactoryMethod() {
            protected List<Integer> createWrappedList() {
                return Arrays.asList(1, 2, 3, 4, 5);
            }
        };
        assertEquals(5, testedListWrapper.getWrappedListSize());
    }
}