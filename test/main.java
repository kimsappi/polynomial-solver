import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static com.computor.Main.solve;

public class main {

    @Test
    public void subjectExamples() {
        String testMethodIdentifier = "Subject example:";
        String equation = "5 * X^0 + 4 * X^1 - 9.3 * X^2 = 1 * X^0";
        assertTrue(
                solve(equation).contains("0.905239") &&
                solve(equation).contains("-0.475131") &&
                solve(equation).contains("degree: 2"),
                String.format("%s %s", testMethodIdentifier, equation)
        );

        equation = "5 * X^0 + 4 * X^1 = 4 * X^0";
        assertTrue(
        solve(equation).contains("1 / 4") &&
                solve(equation).contains("degree: 1"),
                String.format("%s %s", testMethodIdentifier, equation)
        );

        equation = "8 * X^0 - 6 * X^1 + 0 * X^2 - 5.6 * X^3 = 3 * X^0";
        assertTrue(
        solve(equation).contains("range [0..2]") &&
                solve(equation).contains("degree: 3"),
                String.format("%s %s", testMethodIdentifier, equation)
        );
    }

    @Test
    public void basicQuadratic() {
        String testMethodIdentifier = "Basic quadratic:";
        String equation = "X^2 = 0";
        assertTrue(
        solve(equation).contains("single solution") &&
                solve(equation).contains("is:\n0") &&
                solve(equation).contains("degree: 2"),
                String.format("%s %s", testMethodIdentifier, equation)
        );

        equation = "X^2 - X = 5";
        assertTrue(
        solve(equation).contains("-1.79128") &&
                solve(equation).contains("2.79128") &&
                solve(equation).contains("degree: 2"),
                String.format("%s %s", testMethodIdentifier, equation)
        );
    }

    @Test
    public void basicLinear() {
        String testMethodIdentifier = "Basic linear:";
        String equation = "X^2 + 3 * X = -7 + X^2";
        System.out.println(solve(equation));
        assertTrue(
        solve(equation).contains("-7 / 3") &&
                solve(equation).contains("degree: 1"),
                String.format("%s %s", testMethodIdentifier, equation)
        );
    }

}