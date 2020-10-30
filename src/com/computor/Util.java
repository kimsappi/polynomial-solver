package com.computor;

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

    /*public static int getMaxExponent(Term[] terms) {
        Number max = 0;

        for (Term term : terms) {
            if (term.getExponent().getValue() > max)
                max = term.getExponent();
        }

        return max;
    }*/
}
