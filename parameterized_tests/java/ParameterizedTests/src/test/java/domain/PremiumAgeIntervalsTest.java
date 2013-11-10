package domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PremiumAgeIntervalsTest {
    @Test
    public void maleDriversAged18()  {
        assertEquals(1.75, new PremiumRuleEngine().getPremiumFactor(18, Gender.MALE), 0.0);
    }

}
