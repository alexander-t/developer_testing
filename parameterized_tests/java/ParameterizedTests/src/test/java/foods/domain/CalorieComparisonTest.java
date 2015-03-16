package foods.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalorieComparisonTest {

    public static List<Main> foods() {
        return Arrays.asList(Menu.FISH_BURGER,
                Menu.GIGANTIC_BURGER_WITH_BACON, Menu.CHICKEN_SANDWICH,
                Menu.HOTDOG);
    }

    @Test
    public void hamburgersContainTheLeastAmountOfCaloriesAmongFastFoods() {
        for (FastFood food : foods())
            assertThat(Menu.HAMBURGER.getCalories(),
                    is(lessThan(food.getCalories())));
    }
}
