package domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PremiumAgeIntervalsTest {
    @Test
    public void maleDriversAged18() {
        assertEquals(1.75, new PremiumRuleEngine()
                .getPremiumFactor(18, Gender.MALE), 0.0);
    }

    @Test
    public void maleDriversAged23() {
        assertEquals(1.75, new PremiumRuleEngine()
                .getPremiumFactor(23, Gender.MALE), 0.0);
    }

    // Demonstrates a possibility for bug chaining. What happens if the premium factor for the age of 18 changes?
    // We can't know
    @Test
    public void maleDriversAged23HaveTheSameFactorAsMaleDriversAged18() {
        PremiumRuleEngine prl = new PremiumRuleEngine();
        assertEquals(prl.getPremiumFactor(18,
                Gender.MALE),
                prl.getPremiumFactor(23,
                        Gender.MALE), 0.0);
    }

    // Starts feeling uneasy...
    @Test
    public void femaleDriversAged18() {
        assertEquals(1.575, new PremiumRuleEngine()
                .getPremiumFactor(18, Gender.FEMALE), 0.0);
    }

    // Let's violate the "one assert per test" guideline to keep the number of tests down
    @Test
    public void driversAged18() {
        PremiumRuleEngine prl = new PremiumRuleEngine();
        assertEquals(1.75, prl.getPremiumFactor(18,
                Gender.MALE), 0.0);
        assertEquals(1.575, prl.getPremiumFactor(18,
                Gender.FEMALE), 0.0);
    }
}