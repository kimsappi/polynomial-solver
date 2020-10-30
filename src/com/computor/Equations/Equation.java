package com.computor.Equations;

import java.util.HashMap;

public class Equation {
    private com.computor.Util.EquationTypes eqnType;
    private com.computor.Term[] terms;

    public Equation(
        HashMap<Number, Number> coefficientsByExponent,
        com.computor.Util.EquationTypes eqnType,
        String variable
    ) {
        this.eqnType = eqnType;
        this.terms = com.computor.Util.coefficientsExponentsToTerm(coefficientsByExponent, variable);
    }

    public String toString() {
        String[] termStrs = new String[terms.length];
        int i = -1;
        for (com.computor.Term term : this.terms)
            termStrs[++i] = String.valueOf(term);

        return String.format("%s = 0", String.join(" ", termStrs));
    }
}
