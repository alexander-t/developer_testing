package matchers;

import domain.Person;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public class IsAdult extends BaseMatcher<Person> {

    @Override
    public boolean matches(Object o) {
        if (o instanceof Person) {
            Person person = (Person) o;
            return person.getAge() >= 18 && person.getAge() < 65;
        }
        return false;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a person aged 18 to 65");
    }

    @Override
    public void describeMismatch(Object o, Description description) {
        if (o instanceof Person) {
            description.appendText("got a person of age " + ((Person) o).getAge());
        } else {
            description.appendValue(o);
        }
    }
}