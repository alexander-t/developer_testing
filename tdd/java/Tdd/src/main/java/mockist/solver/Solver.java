package mockist.solver;

import classic.solver.Roots;

public interface Solver {
    Roots evaluate(ParsedQuadraticEquation equation);
}
