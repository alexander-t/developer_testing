package classic.solver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuadraticEquationSolver {
    public static Roots solve(String equation) {
        double b = parseXmultiplier(equation);
        double c = parseFreeConstant(equation);
        double d = parseConstantAfterEquals(equation);
        return computeByQuadraticFormula(b, c - d);
    }

    private static Roots computeByQuadraticFormula(double b, double c) {
        return new Roots((-b / 2) + Math.sqrt((b * b / 4) - c),
                (-b / 2) - Math.sqrt((b * b / 4) - c));
    }

    private static double parseXmultiplier(String equation) {
        double b = 0;
        Pattern p = Pattern.compile("^.*([\\+\\-]\\d+)x.*=.*$");
        Matcher m = p.matcher(equation);
        if (m.matches()) {
            b = Double.parseDouble(m.group(1));
        }
        return b;
    }

    private static double parseFreeConstant(String equation) {
        double c = 0;
        Pattern p = Pattern.compile("^.*([\\+\\-]\\d+)=.*$");
        Matcher m = p.matcher(equation);
        if (m.matches()) {
            c = Double.parseDouble(m.group(1));
        }
        return c;
    }

    private static double parseConstantAfterEquals(String equation) {
        return Double.parseDouble(equation.split("=")[1]);
    }
}