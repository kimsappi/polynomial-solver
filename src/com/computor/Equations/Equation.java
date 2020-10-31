package com.computor.Equations;

import java.util.ArrayList;
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
        Object[][] termStrs = new Object[terms.length][2];
        ArrayList<String> finalTermStrs = new ArrayList<>();
        String tmp;
        int i = -1;

        for (com.computor.Term term : this.terms)
            termStrs[++i] = term.toFinalPrintString();

        for (i = 0; i < termStrs.length; ++i) {
            if (termStrs[i] == null)
                continue;
            tmp = "";
            if (i > 0 || !((boolean) termStrs[i][1]))
                tmp += "-";
            else if (i > 0)
                tmp += "+";
            tmp += " " + termStrs[i][0];

            finalTermStrs.add(tmp);
        }

        return String.format("%s = 0", String.join(" ", finalTermStrs));
    }
}
