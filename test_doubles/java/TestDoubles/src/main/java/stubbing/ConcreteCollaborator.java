package stubbing;

import java.time.LocalTime;

public class ConcreteCollaborator implements Collaborator {

    @Override
    public int computeAndReturnValue() {

        // Arbitrary return value that's hard to predict
        return LocalTime.now().getHour() * 60;
    }
}
