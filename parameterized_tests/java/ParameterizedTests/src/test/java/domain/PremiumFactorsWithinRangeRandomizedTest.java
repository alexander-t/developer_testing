package domain;

import net.java.quickcheck.Generator;
import net.java.quickcheck.generator.distribution.Distribution;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;

import static net.java.quickcheck.generator.PrimitiveGenerators.enumValues;
import static net.java.quickcheck.generator.PrimitiveGenerators.integers;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class PremiumFactorsWithinRangeRandomizedTest {

    @Test
    public void premiumsFactorsAreBetween0_5and2_0() {
        Generator<Integer> ageGenerator = integers(18, 100, Distribution.INVERTED_NORMAL);
        Generator<Gender> genderGenerator = enumValues(Gender.class);
        for (int i = 0; i < 100; i++) {
            verifyPremiumFactor(genderGenerator.next(), ageGenerator.next());
        }
    }

    private void verifyPremiumFactor(Gender gender, int age) {
        double premiumFactor
                = new PremiumRuleEngine().getPremiumFactor(age, gender);
        assertThat(premiumFactor,
                is(both(greaterThan(0.5)).and(lessThan(2.0))));
    }

}
