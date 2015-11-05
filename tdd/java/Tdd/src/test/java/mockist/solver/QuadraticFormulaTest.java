package mockist.solver;

import classic.solver.Roots;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class QuadraticFormulaTest {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new Roots(0, 0),
                        new QuadraticEquation(0, 0, 0) },
                { new Roots(-1, 1),
                        new QuadraticEquation(0, 0, 1) },
                { new Roots(-2, 2),
                        new QuadraticEquation(0, 0, 4) },
                { new Roots(-3, 3),
                        new QuadraticEquation(0, 11, 20) },
                { new Roots(-5, 5),
                        new QuadraticEquation(0, -1, 24) },
                { new Roots(0, -5),
                        new QuadraticEquation(5, 0, 0) }
        });
    }

    @Parameter
    public Roots expectedRoots;
    @Parameter(value = 1)
    public QuadraticEquation equation;

    @Test
    public void solveByQuadraticFormula() {
        assertEquals(expectedRoots,
                new QuadraticFormula().evaluate(equation));
    }
}
