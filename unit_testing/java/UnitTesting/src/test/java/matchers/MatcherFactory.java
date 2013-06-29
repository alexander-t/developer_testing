package matchers;

public class MatcherFactory {
    public static IsAdult isAdult() {
        return new IsAdult();
    }
}
