package premiums.domain;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;


@RunWith(Theories.class)
public class PremiumFactorsWithinRangeTest {

    @DataPoints
    public static Gender genders[]
            = new Gender[]{Gender.FEMALE,
            Gender.MALE, Gender.UNKNOWN};

    @DataPoints
    public static int ages[]
            = new int[]{17, 18, 19, 23, 24, 25,
            59, 60, 61, 100, 101};

    @Theory
    public void premiumFactorsAreBetween0_5and2_0(Gender gender, int age) {
        assumeThat(age, greaterThanOrEqualTo(18));
        assumeThat(age, lessThanOrEqualTo(100));
        assumeThat(gender, isOneOf(Gender.FEMALE, Gender.MALE));

        double premiumFactor
                = new PremiumRuleEngine().getPremiumFactor(age, gender);
        assertThat(premiumFactor,
                is(both(greaterThan(0.5)).and(lessThan(2.0))));
    }
}
