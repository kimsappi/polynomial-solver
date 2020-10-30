package com.computor;

import java.util.HashMap;

public class Main {

    public static void solve(String equation) {
        String variable;
        Util.EquationTypes eqnType;

        // Creates array of strings, each containing a single term or operator (inc '=')
        String[] splitFormula = Parser.parseFormula(equation);
        // Creates an array consisting or Term and Operator objects
        Object[] formulaTyped = Parser.parseOperandsOperators(splitFormula);
        /*System.out.println("After typing:");
        for (int i = 0; i < formulaTyped.length; ++i) {
            System.out.printf(
                    "value: %s\t type: %s\n",
                    String.valueOf(formulaTyped[i]),
                    formulaTyped[i].getClass().getName()
            );
        }*/
        // Multiplies all terms around multiplication operators together
        // TODO test multiple chained multiplications e.g. '3 * 3 * 3'
        Object[] formulaMultiplied = Operations.performMultiplications(formulaTyped);

/*        System.out.println("After multiplications:");
        for (int i = 0; i < formulaMultiplied.length; ++i) {
            System.out.printf(
                    "value: %s\t type: %s\n",
                    String.valueOf(formulaMultiplied[i]),
                    formulaMultiplied[i].getClass().getName()
            );
        }*/

        // Replaces '-' operators with '+', moving the negation to the following term instead, in place
        Operations.moveMinusesToTerms(formulaMultiplied);

        /*System.out.println("After negations:");
        for (int i = 0; i < formulaMultiplied.length; ++i) {
            System.out.printf(
                    "value: %s\t type: %s\n",
                    String.valueOf(formulaMultiplied[i]),
                    formulaMultiplied[i].getClass().getName()
            );
        }*/

        Term[] leftSide = Operations.moveTermsToLeftSide(formulaMultiplied);

        System.out.println("All on the left");
        for (int i = 0; i < leftSide.length; ++i) {
            System.out.printf(
                    "value: %s\t type: %s\n",
                    String.valueOf(leftSide[i]),
                    leftSide[i].getClass().getName()
            );
        }

        variable = Util.getVariable(leftSide);

        // coefficients should contain the sum of the coefficients indexed by power
        // e.g. 5 * X^0 - 3 * X^1 - 1 * X^2 would be [5, -3, -1]
        HashMap<Number, Number> coefficientsByExponent = Operations.collateTermsWithSameExponent(leftSide);
        eqnType = Util.checkEquationType(coefficientsByExponent);

        for (HashMap.Entry<Number, Number> entry : coefficientsByExponent.entrySet()) {
            System.out.printf("Exponent: %s\tCoefficient: %s\n", entry.getKey(), entry.getValue());
        }

        System.out.printf("Equation type: %s\n", eqnType.name());

        return;
    }

    public static void main(String[] args) {
        System.out.printf("Original formula: %s\n", args[0]);

        if (args.length != 1) {
            System.out.println("Please give a formula as a parameter.");
            return;
        }

        Main.solve(args[0]);
        System.out.printf("Original formula: %s\n", args[0]);
        return;
    }

}