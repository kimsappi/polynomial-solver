package com.computor.Equations;

import com.computor.IntOrDouble;
import com.computor.Term;
import com.computor.Fraction;

public class LinearEquation implements IEquation {
    private IntOrDouble k, b = new IntOrDouble(0);

    public LinearEquation(Term[] terms) {
        for (Term term : terms) {
            if (term.getExponent().equals(new IntOrDouble(1)))
                this.k = term.getCoefficient();
            else
                this.b = term.getCoefficient();
        }
    }

    public String solve() {
        if (this.k.isInteger() && this.b.isInteger()) {
            return new Fraction(this.b.intValue(), this.k.intValue()).toString();
        }
        else {
            return String.format("%f", this.b.dividedBy(this.k));
        }
    }
}
