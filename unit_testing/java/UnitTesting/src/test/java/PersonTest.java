import domain.Person;
import org.junit.Test;

import static matchers.MatcherFactory.isAdult;
import static org.junit.Assert.assertThat;

public class PersonTest {

    @Test
    public void failsBecauseOfInvalidAge() {
        Person person = new Person("Cecil", "Child", 12);
        assertThat(person, isAdult());
    }
}
