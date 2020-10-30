package com.computor;

import java.util.HashMap;

public class Util {
    public static String getVariable(Term[] terms) {
        String variable = null;
        String tmpVariable;

        for (Term term : terms) {
            tmpVariable = term.getVariable();
            if (variable == null)
                variable = tmpVariable;
            else if (tmpVariable != null && !tmpVariable.equals(variable))
                throw new IllegalArgumentException("Multivariate equations not supported");
        }

        return variable;
    }

    public static boolean exponentsIntBetween0And2(HashMap<Number, Number> terms) {
        IntOrDouble exponent;
        IntOrDouble coefficient;
        for (HashMap.Entry<Number, Number> entry : terms.entrySet()) {
            exponent = new IntOrDouble(entry.getKey());
            coefficient = (IntOrDouble) entry.getValue();
            if (!(exponent.isInteger()) || (
                exponent.intValue() >= 0 && exponent.intValue() <= 2 && coefficient.isNonZero()
            ))
                return false;
        }
        return true;
    }

    // Not allowed to use mathematical libraries
    public static double abs(double x) { return x < 0 ? -x : x; }
    public static int abs(int x) { return x < 0 ? -x : x; }

    /*public static int getMaxExponent(Term[] terms) {
        Number max = 0;

        for (Term term : terms) {
            if (term.getExponent().getValue() > max)
                max = term.getExponent();
        }

        return max;
    }*/
}
