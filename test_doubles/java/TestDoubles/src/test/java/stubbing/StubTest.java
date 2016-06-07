package stubbing;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StubTest {

    @Ignore(value = "Fails because there's no way to know what the collaborator will return")
    @Test
    public void canonicalTest() {
        TestedObject tested = new TestedObject(new ConcreteCollaborator());
        assertEquals(1, tested.computeSomething());
    }

    // This test shows how to use a hand-crafted stub to control a collaborator's indirect input
    @Test
    public void canonicalTestWithStub() {
        TestedObject tested = new TestedObject(new CollaboratorStub());
        assertEquals(420, tested.computeSomething());
    }

    // Hand-crafted stubs can be parameterized
    @Test
    public void canonicalTestWithParameterizedStub() {
        final int knownValue = 2;
        TestedObject tested = new TestedObject(new ParameterizedStub(knownValue));
        assertEquals(knownValue * 42, tested.computeSomething());
    }

}
