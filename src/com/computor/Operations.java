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

    public static Object[] performMultiplications(Object[] formula) {
        ArrayList<Integer> multiplicationIndices = Operations.getMultiplicationIndices(formula);
        for (int i = 0; i < multiplicationIndices.size(); ++i)
            System.out.printf("* %d\n", multiplicationIndices.get(i).intValue());

        return formula;
    }
}
