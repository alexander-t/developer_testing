package mockist.solver;

import classic.solver.Roots;

import static java.lang.Math.*;

public class QuadraticFormula implements Solver {

    public Roots evaluate(QuadraticEquation equation) {
        final double c = equation.c - equation.d;
        return new Roots((-equation.b / 2)
                + sqrt((equation.b * equation.b / 4) - c),
                (-equation.b / 2)
                - sqrt((equation.b * equation.b / 4) - c));
    }
}
