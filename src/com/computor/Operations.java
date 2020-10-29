package com.computor;

import java.util.ArrayList;

public class Operations {
    // Using forEach + lambda or Streams or something would have been so much
    // nicer but IntelliJ complains that it doesn't know what forEach is
    // and I don't know how to change the SDK version or whatever...
    private static ArrayList<Integer> getMultiplicationIndices(Object[] formula) {
        ArrayList<Integer> indices = new ArrayList<>();

        for (int i = 0; i < formula.length; ++i) {
            if (formula[i] instanceof Operator) {
                Operator tmp = (Operator) formula[i];
                if (tmp.isMultiplication())
                    indices.add(i);
            }
        }
        return indices;
    }

    public static Object performMultiplication(Object left, Object right) {
        Double coefficient;
        Term term;

        if (left instanceof Double && right instanceof Term) {
            term = (Term) right;
            coefficient = (Double) left;
        } else if (left instanceof Term && right instanceof Double) {
            term = (Term) left;
            coefficient = (Double) right;
        } else {
            throw new IllegalArgumentException("Double*Double or Term*Term not supported yet");
        }
        term.setCoefficient(coefficient);
        return term;
    }

    public static Object[] performMultiplications(Object[] formula) {
        int index = 0;
        ArrayList<Integer> multiplicationIndices = Operations.getMultiplicationIndices(formula);

        for (int i = 0; i < multiplicationIndices.size(); ++i) {
            index = multiplicationIndices.get(i).intValue();
            formula[index] = Operations.performMultiplication(formula[index - 1], formula[index + 1]);
            formula[index - 1] = null;
            formula[index + 1] = null;
        }

        Object[] multiplicationsDone = new Object[formula.length - 2 * multiplicationIndices.size()];

        int j = -1;
        for (int i = 0; i < formula.length; ++i) {
            if (formula[i] == null)
                continue;
            multiplicationsDone[++j] = formula[i];
        }

        return multiplicationsDone;
    }
}
