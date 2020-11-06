import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static com.computor.Main.solve;

public class main {

    @Test
    public void subjectExamples() {
        String testMethodIdentifier = "Subject example:";
        String equation = "5 * X^0 + 4 * X^1 - 9.3 * X^2 = 1 * X^0", solution = solve(equation);
        assertTrue(
                solution.contains("0.905239") &&
                solution.contains("-0.475131") &&
                solution.contains("degree: 2"),
                String.format("%s %s", testMethodIdentifier, equation)
        );

        equation = "5 * X^0 + 4 * X^1 = 4 * X^0";
        solution = solve(equation);
        assertTrue(
        solution.contains("1 / 4") &&
                solution.contains("degree: 1"),
                String.format("%s %s", testMethodIdentifier, equation)
        );

        equation = "8 * X^0 - 6 * X^1 + 0 * X^2 - 5.6 * X^3 = 3 * X^0";
        solution = solve(equation);
        assertTrue(
        solution.contains("range [0..2]") &&
                solution.contains("degree: 3"),
                String.format("%s %s", testMethodIdentifier, equation)
        );
    }

    @Test
    public void basicQuadratic() {
        String testMethodIdentifier = "Basic quadratic:", degree = "degree: 2";
        String equation = "X^2 = 0", solution = solve(equation);
        assertTrue(
        solution.contains("single solution") &&
                solution.contains("is:\n0") &&
                solution.contains(degree),
                String.format("%s %s", testMethodIdentifier, equation)
        );

        equation = "X^2 - X = 5";
        solution = solve(equation);
        assertTrue(
        solution.contains("-1.79128") &&
                solution.contains("2.79128") &&
                solution.contains(degree),
                String.format("%s %s", testMethodIdentifier, equation)
        );

        equation = "-3.1 * X^2 - X = -55";
        solution = solve(equation);
        assertTrue(
                solution.contains("-4.376") &&
                        solution.contains("4.0539") &&
                        solution.contains(degree),
                String.format("%s %s", testMethodIdentifier, equation)
        );

        // 0 as constant term
        equation = "17.1 * X^2 - X - 0 = 0";
        solution = solve(equation);
        assertTrue(
                solution.contains("-1 * X + 17.100000 * X^2 = 0") &&
                        solution.contains("0.000") &&
                        solution.contains("0.0584") &&
                        solution.contains(degree),
                String.format("%s %s", testMethodIdentifier, equation)
        );
    }

    @Test
    public void complexQuadratic() {
        String testMethodIdentifier = "Complex quadratic:", degree = "degree: 2";
        String equation = "X^2 + X + 1 = 0", solution = solve(equation);
        assertTrue(
                solution.contains("(-1 - 1.732051i) / 2") &&
                        solution.contains("(-1 + 1.732051i) / 2") &&
                        solution.contains(degree),
                String.format("%s %s", testMethodIdentifier, equation)
        );
    }

    @Test
    public void basicLinear() {
        String testMethodIdentifier = "Basic linear:", degree = "degree: 1";
        String equation = "X^2 + 3 * X = -7 + X^2", solution = solve(equation);;
        assertTrue(
        solution.contains("-7 / 3") &&
                solution.contains(degree),
                String.format("%s %s", testMethodIdentifier, equation)
        );
    }

    @Test
    public void basicOther() {
        // Third degree
        String testMethodIdentifier = "Basic other:";
        String equation = "X^2 + 3 * X = -7 + X^3", solution = solve(equation);;
        assertTrue(
                solution.contains("[0..2]") &&
                        solution.contains("degree: 3"),
                String.format("%s %s", testMethodIdentifier, equation)
        );

        // Negative degree
        equation = "X^2 + 3 * X = -7 + X^-1";
        solution = solve(equation);;
        assertTrue(
                solution.contains("[0..2]") &&
                        solution.contains("degree: 2"),
                String.format("%s %s", testMethodIdentifier, equation)
        );

        // Non-integer exponent
        equation = "X^2 + 3 * X = -7 + X^3.1";
        solution = solve(equation);
        assertTrue(
                solution.contains("[0..2]") &&
                        solution.contains("degree: 3.1"),
                String.format("%s %s", testMethodIdentifier, equation)
        );

        // String as variable
        equation = "asd^2 - 3 * asd = -1 + asd";
        solution = solve(equation);
        assertTrue(
                solution.contains("1 - 4 * asd + asd^2 = 0") &&
                        solution.contains("degree: 2") &&
                        solution.contains("0.2679") &&
                        solution.contains("3.7320"),
                String.format("%s %s", testMethodIdentifier, equation)
        );
    }

    @Test
    public void chainedMultiplication() {
        String testMethodIdentifier = "Chained multiplication:", degree = "degree: 2";;
        String equation = "X^2 + 3 * 3 * X = -7 + X",  solution = solve(equation);;
        assertTrue(
                solution.contains("-7") &&
                        solution.contains("-1") &&
                        solution.contains(degree),
                String.format("%s %s", testMethodIdentifier, equation)
        );

        equation = "X^2 * 3 * X^2 * -3 * X^2 + X = 7";
        solution = solve(equation);
        assertTrue(
                solution.contains("-7 + X - 9 * X^6 = 0") &&
                        solution.contains("degree: 6") &&
                        solution.contains("[0..2]"),
                String.format("%s %s", testMethodIdentifier, equation)
        );

    }

}
