package com.computor.Equations;

import com.computor.IntOrDouble;
import com.computor.Term;

public class ConstantEquation implements IEquation {
    private IntOrDouble value;
    private String variable;

    public ConstantEquation(Term[] terms, String variable) {
        this.variable = variable;
        for (Term term : terms) {
            if (term.getExponent().equals(new IntOrDouble(0)))
                this.value = term.getCoefficient();
        }
    }

    public String solve() {
        if (this.value != null && this.value.isNonZero())
            return "The equation is false";
        else
            return String.format("The equation is true with all values of '%s'", this.variable);
    }
}
