package com.computor;

import java.util.HashMap;

public class Util {
    public enum EquationTypes {
        constant,
        linear,
        quadratic,
        other
    }

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

    public static Util.EquationTypes checkEquationType(HashMap<Number, Number> terms) {
        IntOrDouble exponent, coefficient;
        int maxExponent = 0;

        for (HashMap.Entry<Number, Number> entry : terms.entrySet()) {
            exponent = new IntOrDouble(entry.getKey());
            coefficient = (IntOrDouble) entry.getValue();
            if (!(exponent.isInteger()) ||
                ((exponent.intValue() < 0 || exponent.intValue() > 2) && coefficient.isNonZero())
            )
                return Util.EquationTypes.other;
            else
                maxExponent = exponent.intValue() > maxExponent && coefficient.isNonZero() ?
                    exponent.intValue() : maxExponent;
        }
        switch(maxExponent) {
            case(0):
                return Util.EquationTypes.constant;
            case(1):
                return Util.EquationTypes.linear;
            case(2):
                return Util.EquationTypes.quadratic;
            default:
                throw new IllegalStateException("Couldn't recognise equation type");
        }
    }

    public static Term[] coefficientsExponentsToTerm(HashMap<Number, Number> coefficientsByExponent, String variable) {
        Term[] terms = new Term[coefficientsByExponent.size()];
        int i = -1;

        for (HashMap.Entry<Number, Number> entry : coefficientsByExponent.entrySet()) {
            terms[++i] = new Term((IntOrDouble) entry.getValue(), variable, new IntOrDouble(entry.getKey()));
        }

        return terms;
    }

    // Not allowed to use mathematical libraries
    public static double abs(double x) { return x < 0 ? -x : x; }
    public static int abs(int x) { return x < 0 ? -x : x; }

    public static IntOrDouble sqrt(IntOrDouble x) {
        return new IntOrDouble(1);
    };

    /*public static int getMaxExponent(Term[] terms) {
        Number max = 0;

        for (Term term : terms) {
            if (term.getExponent().getValue() > max)
                max = term.getExponent();
        }

        return max;
    }*/
}
