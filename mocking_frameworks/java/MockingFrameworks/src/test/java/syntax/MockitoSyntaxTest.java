package syntax;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// This class just provides syntactically correct code that uses Mockito
public class MockitoSyntaxTest {

    @Test
    public void demonstrateBasicMatcher() {
        Dependency dependencyStub = mock(Dependency.class);
        when(dependencyStub.computeAndReturnValue(anyInt())).thenReturn(10);
    }

    @Test
    public void demonstrateImplicitEquals() {
        Dependency dependencyStub = mock(Dependency.class);
        when(dependencyStub.computeAndReturnValue(42)).thenReturn(10);

        assertEquals(10, dependencyStub.computeAndReturnValue(42));
        assertEquals(0, dependencyStub.computeAndReturnValue(43));
    }

    @Test
    public void demonstrateConsecutiveStubbing() {
        Dependency dependencyStub = mock(Dependency.class);
        when(dependencyStub.computeAndReturnValue(42))
                .thenReturn(10).thenReturn(99);

        assertEquals(10, dependencyStub.computeAndReturnValue(42));
        assertEquals(99, dependencyStub.computeAndReturnValue(42));
    }

    @Test(expected = IllegalArgumentException.class)
    public void demonstrateThrowingExceptions() {
        Dependency dependencyStub
                = when(mock(Dependency.class).computeAndReturnValue(42))
                .thenThrow(new IllegalArgumentException("42 isn't the answer!"))
                .getMock();
        dependencyStub.computeAndReturnValue(42);
    }
}