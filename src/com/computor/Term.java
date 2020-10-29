package com.computor;

public class Term {
    double coefficient;
    String variable;
    int exponent;

    public Term(String term) {
        String[] split = term.split("\\^");
        if (split.length > 2)
            throw new IllegalArgumentException("Illegal term with 2 carets.");
        this.variable = split[0];
        if (split.length == 2)
            this.exponent = Integer.parseInt(split[1]);
        else
            this.exponent = 1;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public String toString() {
        return String.format("%s ^ %d", this.variable, this.exponent);
    }
}
