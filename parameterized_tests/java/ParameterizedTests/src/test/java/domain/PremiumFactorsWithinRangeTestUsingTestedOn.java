package domain;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;
import util.supplier.AllGenders;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;


/**
 * This test uses both a user-defined parameter supplied
 * and @TestedOn (which is the only supplier that comes with JUnit)
 */
@RunWith(Theories.class)
public class PremiumFactorsWithinRangeTestUsingTestedOn {

    @Theory
    public void premiumFactorsAreBetween0_5and2_0(@AllGenders Gender gender,
                                                  @TestedOn(ints = {17, 18, 19, 23, 24, 25,
                                                          59, 60, 61, 100, 101}) int age) {
        assumeThat(age, greaterThanOrEqualTo(18));
        assumeThat(age, lessThanOrEqualTo(100));
        assumeThat(gender, isOneOf(Gender.FEMALE, Gender.MALE));

        double premiumFactor
                = new PremiumRuleEngine().getPremiumFactor(age, gender);
        assertThat(premiumFactor,
                is(both(greaterThan(0.5)).and(lessThan(2.0))));
    }
}
