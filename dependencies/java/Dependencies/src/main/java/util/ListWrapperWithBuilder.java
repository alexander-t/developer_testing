package util;

import java.util.List;

public class ListWrapperWithBuilder {
    private List<Integer> wrapped;

    public int getWrappedListSize() {
        return wrapped.size();
    }

    public ListWrapperWithBuilder(IntegerListBuilder listBuilder) {
        wrapped = listBuilder.build();
    }
}