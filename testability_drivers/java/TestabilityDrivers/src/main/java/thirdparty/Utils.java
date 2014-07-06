package thirdparty;

public class Utils {
    // Method borrowed from Apache Commons Math 3.3.2.
    // Minor modifications made to keep it "pure Java" and formatted for book width.
    static int gcdPositive(int a, int b){
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

    public void signup(String firstname, String lastname, int age, ... ) {
        if (age < 1 || age >= 120) {
            throw new IllegalArgumentException("Invalid age");
        } else if (age <= 18) {
            throw new UnderAgedException();
        }

        // Code that performs the signup
    }
}
