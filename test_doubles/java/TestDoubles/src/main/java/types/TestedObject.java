package types;

public class TestedObject {

    private Collaborator collaborator;

    public TestedObject(Collaborator collaborator) {
        this.collaborator = collaborator;
    }

    public int computeSomething() {
        return 42 * collaborator.computeAndReturnValue();
    }
}
