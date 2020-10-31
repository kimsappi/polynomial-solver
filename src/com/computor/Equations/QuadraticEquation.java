package com.computor.Equations;

import com.computor.IntOrDouble;

public class QuadraticEquation implements IEquation {
    private com.computor.IntOrDouble a, b, c;

    public QuadraticEquation(com.computor.Term[] terms) {
        this.a = terms[2].getCoefficient();
        this.b = terms[1].getCoefficient();
        this.c = terms[0].getCoefficient();
    }

    // Should probably return IntOrDouble[2] or something
    public IntOrDouble solve() {
        return new IntOrDouble(1);
    }
}
