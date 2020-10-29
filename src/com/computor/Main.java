package com.computor;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please give a formula as a parameter.");
            return;
        }

        String[] splitFormula = Parser.parseFormula(args[0]);
        Object[] formulaTyped = Parser.parseOperandsOperators(splitFormula);

        for (int i = 0; i < formulaTyped.length; ++i) {
            System.out.printf(
                "value: %s\t type: %s\n",
                String.valueOf(formulaTyped[i]),
                formulaTyped[i].getClass().getName()
            );
        }

        System.out.println("After multiplications:");
        Object[] formulaMultiplied = Operations.performMultiplications(formulaTyped);

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