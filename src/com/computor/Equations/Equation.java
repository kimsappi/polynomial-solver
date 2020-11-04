package com.computor.Equations;

import com.computor.IntOrDouble;
import com.computor.Util;
import com.computor.Term;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class Equation {
    private com.computor.Util.EquationTypes eqnType;
    private com.computor.Term[] terms;
    private IEquation equation;
    private IntOrDouble degree;

    public Equation(
        HashMap<Number, Number> coefficientsByExponent,
        com.computor.Util.EquationTypes eqnType,
        String variable
    ) {
        this.eqnType = eqnType;
        this.terms = com.computor.Util.coefficientsExponentsToTerm(coefficientsByExponent, variable);
        // Orders terms by ascending degree, as recommended in the subject
        Arrays.sort(this.terms);
        degree = this.terms[this.terms.length - 1].getExponent();

        switch(eqnType) {
            case quadratic:
                this.equation = new QuadraticEquation(this.terms);
                break;
            case linear:
                this.equation = new LinearEquation(this.terms);
                break;
            case constant:
                this.equation = new ConstantEquation(this.terms, variable);
                break;
            default:
                this.equation = new OtherEquation();
                break;
        }
    }

    public String toString() {
        Object[][] termStrs = new Object[terms.length][2];
        ArrayList<String> finalTermStrs = new ArrayList<>();
        String tmp;
        int i = -1, termIndex = 0;

        for (com.computor.Term term : this.terms)
            termStrs[++i] = term.toFinalPrintString();

        for (i = 0; i < termStrs.length; ++i) {
            if (termStrs[i] == null)
                continue;
            tmp = "";
            if (i > 0 && !((boolean) termStrs[i][1]))
                tmp += "-";
            else if (termIndex > 0)
                tmp += "+";
            tmp += " " + termStrs[i][0];
            ++termIndex;

            finalTermStrs.add(tmp);
        }

        return String.format("Reduced form: %s = 0\nPolynomial degree: %s\n%s",
            String.join(" ", finalTermStrs),
            this.degree,
            this.equation.solve()
        );
    }
}
