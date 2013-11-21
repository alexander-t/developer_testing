package domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PremiumAgeIntervalsTestV3 {

    double expectedPremiumFactor;
    int age;
    Gender gender;

    public PremiumAgeIntervalsTestV3(double epf,
                                     int age,
                                     Gender gender) {
        this.expectedPremiumFactor = epf;
        this.age = age;
        this.gender = gender;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1.75, 18, Gender.MALE},
                {1.75, 23, Gender.MALE},
                {1.0, 24, Gender.MALE},
                {1.0, 59, Gender.MALE},
                {1.35, 60, Gender.MALE},
                {1.575, 18, Gender.FEMALE},
                {1.575, 23, Gender.FEMALE},
                {0.9, 24, Gender.FEMALE},
                {0.9, 59, Gender.FEMALE},
                {1.215, 60, Gender.FEMALE}}
        );
    }

    @Test
    public void verifyPremiumFactor() {
        assertEquals(expectedPremiumFactor, new PremiumRuleEngine()
                .getPremiumFactor(age, gender), 0.0);
    }
}