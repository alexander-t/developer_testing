package mockist.solver;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegexpParserTest {

    @Test
    public void parseXSquaredEqualsZero() {
        assertEquals(new QuadraticEquation(0, 0, 0),
                new RegexpParser().parse("x^2=0"));
    }

    @Test
    public void parseXSquaredEqualsOne() {
        assertEquals(new QuadraticEquation(0, 0, 1),
                new RegexpParser().parse("x^2=1"));
    }

}
