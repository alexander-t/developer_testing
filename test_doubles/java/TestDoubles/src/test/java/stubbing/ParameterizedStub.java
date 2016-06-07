package stubbing;

public class ParameterizedStub implements Collaborator {

    private int value;

    public ParameterizedStub(int value) {
        this.value = value;
    }

    @Override
    public int computeAndReturnValue() {
        return value;
    }
}
