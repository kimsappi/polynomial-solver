package com.computor;

import java.util.ArrayList;

public class Operations {
    // Using forEach + lambda or Streams or something would have been so much
    // nicer but IntelliJ complains that it doesn't know what forEach is
    // and I don't know how to change the SDK version or whatever...
    private static ArrayList<Integer> getOperatorIndices(Object[] formula, char type) {
        ArrayList<Integer> indices = new ArrayList<>();

        for (int i = 0; i < formula.length; ++i) {
            if (formula[i] instanceof Operator) {
                Operator tmp = (Operator) formula[i];
                if (tmp.isType(type))
                    indices.add(i);
            }
        }
        return indices;
    }

    public static Object performMultiplication(Object left, Object right) {
        if (!(left instanceof Term && right instanceof Term))
            throw new IllegalArgumentException("Invalid formula: Operator followed by Operator");

        Term lhs = (Term) left;
        Term rhs = (Term) right;
        lhs.multiplyByTerm(rhs);
        return lhs;
    }

    public static Object[] performMultiplications(Object[] formula) {
        int index;
        ArrayList<Integer> multiplicationIndices = Operations.getOperatorIndices(formula, '*');

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

    public static void moveMinusesToTerms(Object[] formula) {
        int index;
        ArrayList<Integer> minusIndices = Operations.getOperatorIndices(formula, '-');

        for (int i = 0; i < minusIndices.size(); ++i) {
            index = minusIndices.get(i).intValue();
            formula[index] = new Operator("+");
            Term negated = (Term) formula[index + 1];
            negated.flipSign();
            formula[index + 1] = negated;
        }
    }

    public static Term[] moveTermsToLeftSide(Object[] formula) {
        ArrayList<Term> leftSide = new ArrayList<>();
        boolean flipSign = false;
        Term tmp;

        for (Object item : formula) {
            if (item instanceof Operator && ((Operator) item).isType('=')) {
                if (flipSign)
                    throw new IllegalArgumentException("Encountered 2 equality signs, invalid equation");
                else
                    flipSign = true;
            }
            if (!(item instanceof Term))
                continue;

            tmp = (Term) item;
            if (flipSign)
                tmp.flipSign();
            leftSide.add(tmp);
        }

        return leftSide.toArray(new Term[0]);
    }
}
