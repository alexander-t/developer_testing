package premiums.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameters;
import static org.junit.runners.Parameterized.Parameter;

@RunWith(Parameterized.class)
public class PremiumAgeIntervalsTestV4 {

    @Parameter(value = 0)
    public double expectedPremiumFactor;

    @Parameter(value = 1)
    public int age;

    @Parameter(value = 2)
    public Gender gender;

    @Parameters(name = "Case {index}: Expected {0} for {1} year old {2}s")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1.75, 18, Gender.MALE},
                {1.75, 23, Gender.MALE},
                {1.0, 24, Gender.MALE},
                {1.0, 59, Gender.MALE},
                {1.353, 60, Gender.MALE},
                {1.575, 18, Gender.FEMALE},
                {1.575, 23, Gender.FEMALE},
                {0.9, 24, Gender.FEMALE},
                {0.9, 59, Gender.FEMALE},
                {1.215, 60, Gender.FEMALE}}
        );
    }

    @Test
    public void verifyPremiumFactor() {
        assertEquals(expectedPremiumFactor,
                new PremiumRuleEngine()
                        .getPremiumFactor(age, gender)
                , 0.0);
    }
}