package mock;

import java.util.Arrays;

public class TestedObject {

    private Dependency dependency;

    public TestedObject(Dependency dependency) {
        this.dependency = dependency;
    }

    public void invokeDependency() {
        dependency.m("hello", 42, Arrays.asList("a", "b", "c"));
    }


}
