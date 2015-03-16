package foods.domain;

import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

public class FoodTests {

    @Test
    public void aHamburgerIsnHealthyFood() {
        assertThat(Menu.HAMBURGER.getCalories(), greaterThan(200));
    }
}
