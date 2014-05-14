package thirdparty;

public class GcdFinder {
    private int a;
    private int b;

    public void initialize(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int gcdPositive() {
        if (a == 0) {
            return b;
        } else if (b == 0) {
            return a;
        }

        final int aTwos = Integer.numberOfTrailingZeros(a);
        a >>= aTwos;
        final int bTwos = Integer.numberOfTrailingZeros(b);
        b >>= bTwos;
        final int shift = Math.min(aTwos, bTwos);

        while (a != b) {
            final int delta = a - b;
            b = Math.min(a, b);
            a = Math.abs(delta);
            a >>= Integer.numberOfTrailingZeros(a);
        }
        return a << shift;
    }
}
