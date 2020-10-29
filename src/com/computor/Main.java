package com.computor;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please give a formula as a parameter.");
            return;
        }

        // Creates array of strings, each containing a single term or operator (inc '=')
        String[] splitFormula = Parser.parseFormula(args[0]);
        // Creates an array consisting or Term and Operator objects
        Object[] formulaTyped = Parser.parseOperandsOperators(splitFormula);
        // Multiplies all terms around multiplication operators together
        // TODO test multiple chained multiplications e.g. '3 * 3 * 3'
        Object[] formulaMultiplied = Operations.performMultiplications(formulaTyped);

        System.out.println("After multiplications:");
        for (int i = 0; i < formulaMultiplied.length; ++i) {
            System.out.printf(
                    "value: %s\t type: %s\n",
                    String.valueOf(formulaMultiplied[i]),
                    formulaMultiplied[i].getClass().getName()
            );
        }

        // Replaces '-' operators with '+', moving the negation to the following term instead, in place
        Operations.moveMinusesToTerms(formulaMultiplied);

        System.out.println("After negations:");
        for (int i = 0; i < formulaMultiplied.length; ++i) {
            System.out.printf(
                    "value: %s\t type: %s\n",
                    String.valueOf(formulaMultiplied[i]),
                    formulaMultiplied[i].getClass().getName()
            );
        }

        System.out.printf("Original formula: %s", args[0]);
        return;
    }

}