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
import static org.junit.Assume.assumeThat;

@RunWith(Theories.class)
public class FastFoodMealTheoryTest {

    @DataPoints
    public static List<Main> mainCourses() {
        return Arrays.asList(Menu.HAMBURGER, Menu.FISH_BURGER,
                Menu.GIGANTIC_BURGER_WITH_BACON, Menu.CHICKEN_SANDWICH,
                Menu.HOTDOG);
    }

    @DataPoints
    public static List<SideOrder> sideOrders() {
        return Arrays.asList(Menu.SMALL_FRENCH_FRIES, Menu.LARGE_FRENCH_FRIES,
                Menu.APPLE_PIE, Menu.SMALL_CHOCOLATE_MILKSHAKE);
    }

    @DataPoints
    public static List<Beverage> bevereges() {
        return Arrays.asList(Menu.MEDIUM_COKE, Menu.LARGE_DIET_COKE,
                Menu.MEDIUM_LATTE, Menu.LARGE_LATTE);
    }

    @Theory
    public void noFastFoodMealContainsLessThan500calories(Main main,
                                                          SideOrder sideOrder, Beverage beverage) {
        assumeThat(beverage.isDiet(), is(false));
        System.err.println(main + " " + sideOrder + " " + beverage);
        assertThat(main.getCalories() + sideOrder.getCalories() + beverage.getCalories(),
                is(greaterThan(500)));
    }
}
