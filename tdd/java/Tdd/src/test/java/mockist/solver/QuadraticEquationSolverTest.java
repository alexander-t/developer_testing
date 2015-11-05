package mockist.solver;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class QuadraticEquationSolverTest {

    @Test
    public void solvingRequiresParsingAndComputation() {
        Parser parserStub = mock(Parser.class);
        Solver solverMock = mock(Solver.class);

        QuadraticEquationSolver solver
                = new QuadraticEquationSolver(parserStub, solverMock);
        final QuadraticEquation equation
                = new QuadraticEquation(0, 0, 0);
        when(parserStub.parse("x^2=0")).thenReturn(equation);

        solver.solve("x^2=0");
        verify(solverMock).evaluate(equation);
    }
}
