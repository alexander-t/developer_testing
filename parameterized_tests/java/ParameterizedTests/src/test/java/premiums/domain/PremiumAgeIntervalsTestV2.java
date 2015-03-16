package premiums.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PremiumAgeIntervalsTestV2 {
    @Test
    public void maleDriversAged18()  {
        verifyPremiumFactor(1.75, 18, Gender.MALE);
    }

    @Test
    public void maleDriversAged23()  {
        verifyPremiumFactor(1.75, 23, Gender.MALE);
    }
    @Test
    public void femaleDriversAged18()  {
        verifyPremiumFactor(1.575, 18, Gender.FEMALE);
    }

    private void verifyPremiumFactor(double expected,
                                     int age,
                                     Gender gender) {
        assertEquals(expected, new PremiumRuleEngine()
                .getPremiumFactor(age, gender), 0.0);
    }

}