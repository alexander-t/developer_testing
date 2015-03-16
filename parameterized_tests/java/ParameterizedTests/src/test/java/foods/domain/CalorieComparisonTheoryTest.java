package foods.domain;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Theories.class)
public class CalorieComparisonTheoryTest {

    @DataPoints
    public static List<Main> foods() {
        return Arrays.asList(Menu.FISH_BURGER,
                Menu.GIGANTIC_BURGER_WITH_BACON, Menu.CHICKEN_SANDWICH,
                Menu.HOTDOG);
    }

    @Theory
    public void hamburgersContainTheLeastAmountOfCaloriesAmongFastFoods(FastFood food) {
        assertThat(food.getCalories(),
                is(greaterThan(Menu.HAMBURGER.getCalories())));
    }
}
