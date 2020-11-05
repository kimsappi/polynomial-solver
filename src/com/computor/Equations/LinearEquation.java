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
            else if (term.getExponent().equals(new IntOrDouble(0)))
                this.b = term.getCoefficient();
        }
        // kx + b = 0 => x = -b/k
        this.k.multiply(new IntOrDouble(-1));
    }

    public String solve() {
        String solution;
        if (this.k.isInteger() && this.b.isInteger())
            solution = new Fraction(this.b.intValue(), this.k.intValue()).toString();
        else
            solution = String.format("%f", this.b.dividedBy(this.k));

        return String.format("The single solution is: %s", solution);
    }
}
