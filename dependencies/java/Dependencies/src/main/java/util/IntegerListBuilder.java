package util;

import java.util.ArrayList;
import java.util.List;

public class IntegerListBuilder {

    private int start = 0;
    private int end = 10;
    private int step = 1;

    public IntegerListBuilder startingAt(int start) {
        this.start = start;
        return this;
    }

    public IntegerListBuilder endingWith(int end) {
        this.end = end;
        return this;
    }

    public List<Integer> build() {
        List<Integer> ints = new ArrayList<Integer>();
        for (int i = start; i <= end; i+= step) {
            ints.add(i);
        }
        return ints;
    }

    // ... More builder methods would go here
}
