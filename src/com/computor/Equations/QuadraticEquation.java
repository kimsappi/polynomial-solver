package com.computor.Equations;

import com.computor.IntOrDouble;
import com.computor.Fraction;

public class QuadraticEquation implements IEquation {
    private IntOrDouble a, b, c, discriminant;

    public QuadraticEquation(com.computor.Term[] terms) {
        this.a = terms[2].getCoefficient();
        this.b = terms[1].getCoefficient();
        this.c = terms[0].getCoefficient();

        IntOrDouble tempA = new IntOrDouble(this.a);
        IntOrDouble tempB = new IntOrDouble(this.b);

        tempB.multiply(tempB);
        tempA.multiply(this.c);
        tempA.multiply(new IntOrDouble(-4));
        tempB.sum(tempA);

        this.discriminant = tempB;

//        System.out.printf("a b c disc: %s %s %s %s\n", this.a, this.b, this.c, this.discriminant);
    }

    private double positiveDiscriminantSolveOnce(boolean plus) {
        IntOrDouble numerator = new IntOrDouble(this.b),
                denominator = new IntOrDouble(this.a),
                discriminant = new IntOrDouble(IntOrDouble.sqrt(this.discriminant));

//        System.out.printf("numer: %s denom: %s disc: %s\n", numerator, denominator, discriminant);
        numerator.multiply(new IntOrDouble(-1));
        if (!plus)
            discriminant.multiply(new IntOrDouble(-1));
        numerator.sum(discriminant);
        denominator.multiply(new IntOrDouble(2));

//        System.out.printf("numer: %s denom: %s disc: %s\n", numerator, denominator, discriminant);

        return numerator.dividedBy(denominator);
    }

    private IntOrDouble[] zeroDiscriminantBeautifulSolve(int numerator, int denominator) {
        Fraction fraction = new Fraction(numerator, denominator);
        int[] ints = fraction.toArr();
        IntOrDouble[] intsOrDoubles = new IntOrDouble[2];
        intsOrDoubles[0] = new IntOrDouble(ints[0]);
        intsOrDoubles[1] = new IntOrDouble(ints[1]);

        return intsOrDoubles;
    }

    private IntOrDouble[] zeroDiscriminantSolve() {
        IntOrDouble tmpB = new IntOrDouble(this.b), tmpA = new IntOrDouble(this.a);

        tmpB.multiply(new IntOrDouble(-1));
        tmpA.multiply(new IntOrDouble(2));

        if (this.b.isInteger() && this.a.isInteger())
            return zeroDiscriminantBeautifulSolve(tmpB.intValue(), tmpA.intValue());
        else {
            return new IntOrDouble[] {new IntOrDouble(tmpB.dividedBy(tmpA))};
        }
    }

    // Returning a string here will enable fractional output and other fancy stuff without too much extra work
    public String solve() {
        if (this.discriminant.doubleValue() > 0.0) {
            return String.format("2 solutions: %f, %f",
                positiveDiscriminantSolveOnce(false),
                positiveDiscriminantSolveOnce(true)
            );
        }
        return "couldn't solve equation, temp (QuadraticEquation.solve())";
    }
}
