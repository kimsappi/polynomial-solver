package com.computor;

public class Operator {
    private static final String[] operators = {"+", "-", "*", "="};
    private char operator;

    public static boolean checkIfOperator(String value) {
        for (int i = 0; i < Operator.operators.length; ++i) {
            if (Operator.operators[i].equals(value))
                return true;
        }
        return false;
    }

    public Operator(String operator) {
        if (!Operator.checkIfOperator(operator))
            throw new IllegalArgumentException("Tried to create new Operator from invalid String.");
        this.operator = operator.charAt(0);
    }

    public boolean isType(char type) {
        return this.operator == type;
    }

    public String toString() {
        return String.valueOf(this.operator);
    }
}
