package util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListWrapperWithBuilderTest {
    @Test
    public void tryTestingTheSizeOfAWrappedList() {
        IntegerListBuilder builder
                = new IntegerListBuilder()
                .startingAt(1).endingWith(5);
        ListWrapperWithBuilder testedListWrapper
                = new ListWrapperWithBuilder(builder);
        assertEquals(5,
                testedListWrapper.getWrappedListSize());
    }
}
