package util;

import java.util.Arrays;
import java.util.List;

public class ListWrapperWithFactoryMethod {
    private List<Integer> wrapped;

    public int getWrappedListSize() {
        return wrapped.size();
    }

    public ListWrapperWithFactoryMethod() {
        wrapped = createWrappedList();
    }

    protected List<Integer> createWrappedList() {
        return Arrays.asList(1, 2, 3);
    }
}