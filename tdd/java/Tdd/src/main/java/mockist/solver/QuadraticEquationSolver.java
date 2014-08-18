package mockist.solver;

import classic.solver.Roots;

public class QuadraticEquationSolver {

    private Parser parser;
    private Solver solver;

    public QuadraticEquationSolver(Parser parser, Solver solver) {
        this.parser = parser;
        this.solver = solver;
    }

    public Roots solve(String equation) {
        return solver.evaluate(parser.parse(equation));
    }
}
