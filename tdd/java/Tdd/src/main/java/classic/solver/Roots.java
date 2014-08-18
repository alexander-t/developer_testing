package classic.solver;

public class Roots {
    public final double x1;
    public final double x2;

    public Roots(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Roots that = (Roots) o;

        return ((this.x1 == that.x1
                && this.x2 == that.x2) ||
            (this.x1 == that.x2
                    && this.x2 == that.x1));
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x1);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(x2);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Roots{" +
                "x1=" + x1 +
                ", x2=" + x2 +
                '}';
    }
}
