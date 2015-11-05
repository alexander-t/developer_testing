package mockist.solver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpParser implements Parser {

    public QuadraticEquation parse(String equation) {
        Pattern p = Pattern.compile("^.*=(\\d+)$");
        Matcher m = p.matcher(equation);
        m.matches();
        return new QuadraticEquation(0, 0,
                Double.parseDouble(m.group(1)));
    }
}

