package banana;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BananaEqualsTest {
    class Banana {
        public String color = "yellow";
    }

    interface Monkey {
        boolean likes(Banana banana);
    }

    @Ignore(value = "Fails because of missing equals")
    @Test
    public void monkeysLikeBananas() {
        Monkey monkeyStub = mock(Monkey.class);
        when(monkeyStub.likes(new Banana())).thenReturn(true);

        assertTrue(monkeyStub.likes(new Banana()));
    }
}
