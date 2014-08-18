package classic.solver;

import classic.solver.QuadraticEquationSolver;
import classic.solver.Roots;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuadraticEquationSolverTest {

    @Test
    public void xSquaredEquals0_RootsAre0_0() {
        assertEquals(new Roots(0, 0),
                QuadraticEquationSolver.solve("x^2=0"));
    }

    @Test
    public void xSquaredEquals1_RootsAre1_minus1() {
        assertEquals(new Roots(1, -1),
                QuadraticEquationSolver.solve("x^2=1"));
    }

    @Test
    public void xSquaredEquals4_RootsAre2_minus2() {
        assertEquals(new Roots(2, -2),
                QuadraticEquationSolver.solve("x^2=4"));
    }

    @Test
    public void xSquaredPlus11Equals20_RootsAre3_minus3() {
        assertEquals(new Roots(3, -3),
                QuadraticEquationSolver.solve("x^2+11=20"));
    }

    @Test
    public void xSquaredMinus1Equals24_RootsAre5_minus5() {
        assertEquals(new Roots(5, -5),
                QuadraticEquationSolver.solve("x^2-1=24"));
    }

    @Test
    public void xSquaredPlus5xEquals0_RootsAre0_minus5() {
        assertEquals(new Roots(0, -5),
                QuadraticEquationSolver.solve("x^2+5x=0"));
    }

    @Test
    public void xSquaredPlus5xPlus6Equals0_RootsAreMinus3_minus2() {
        assertEquals(new Roots(-3, -2),
                QuadraticEquationSolver.solve("x^2+5x+6=0"));
    }
}
