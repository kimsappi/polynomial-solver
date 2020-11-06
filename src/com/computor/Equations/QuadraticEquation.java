package com.computor.Equations;

import com.computor.IntOrDouble;
import com.computor.Fraction;
import com.computor.Term;

public class QuadraticEquation implements IEquation {
    private IntOrDouble a, b = new IntOrDouble(0), c = new IntOrDouble(0), discriminant, iCoefficient;

    public QuadraticEquation(Term[] terms) {
        for (Term term : terms) {
            if (term.getExponent().equals(new IntOrDouble(2)))
                this.a = term.getCoefficient();
            else if (term.getExponent().equals(new IntOrDouble(1)))
                this.b = term.getCoefficient();
            else
                this.c = term.getCoefficient();
        }

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

    private String zeroDiscriminantBeautifulSolve(int numerator, int denominator) {
        Fraction fraction = new Fraction(numerator, denominator);
        int[] ints = fraction.toArr();
        IntOrDouble[] intsOrDoubles = new IntOrDouble[2];
        intsOrDoubles[0] = new IntOrDouble(ints[0]);
        intsOrDoubles[1] = new IntOrDouble(ints[1]);

        return fraction.toString();
        //return intsOrDoubles;
    }

    private Object zeroDiscriminantSolve() {
        IntOrDouble tmpB = new IntOrDouble(this.b), tmpA = new IntOrDouble(this.a);

        tmpB.multiply(new IntOrDouble(-1));
        tmpA.multiply(new IntOrDouble(2));

        if (this.b.isInteger() && this.a.isInteger())
            return zeroDiscriminantBeautifulSolve(tmpB.intValue(), tmpA.intValue());
        else {
            return new IntOrDouble(tmpB.dividedBy(tmpA));
        }
    }

    private String solveComplexRoot(boolean positive) {
        IntOrDouble denominator = new IntOrDouble(this.a), b = new IntOrDouble(this.b);
        denominator.multiply(new IntOrDouble(2));
        b.multiply(new IntOrDouble(-1));
        return String.format("(%s %s %si) / %s",
                b,
                positive ? "+" : "-",
                this.iCoefficient,
                denominator
        );
    }

    private String solveComplexRoots() {
        this.discriminant.multiply(new IntOrDouble(-1));
        this.iCoefficient = IntOrDouble.sqrt(this.discriminant);
        return String.format("%s\n%s", solveComplexRoot(false), solveComplexRoot(true));
    }

    // Returning a string here will enable fractional output and other fancy stuff without too much extra work
    public String solve() {
        if (this.discriminant.doubleValue() > 0.0) {
            return String.format("Discriminant is strictly positive, the two solutions are:\n%f\n%f",
                this.positiveDiscriminantSolveOnce(false),
                this.positiveDiscriminantSolveOnce(true)
            );
        } else if (!this.discriminant.isNonZero()) {
            Object solution = this.zeroDiscriminantSolve();
            String solutionStr;
            if (solution instanceof String)
                solutionStr = (String) solution;
            else
                solutionStr = String.format("%s", (IntOrDouble) solution);
//            String solutionStr = solutions.length == 2 ?
//                String.format("%s / %s", solutions[0], solutions[1]) :
//                String.format("%s", solutions[0]);

            return String.format("The discriminant is 0, the single solution is:\n%s", solutionStr);
        } else
            return String.format("Discriminant is strictly negative, the two complex solutions are:\n%s",
                this.solveComplexRoots()
            );
    }
}
