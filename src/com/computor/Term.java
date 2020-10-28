package com.computor;

public class Term {
    double coefficient;
    String variable;
    int exponent;

    public Term(String term) {
        String[] split = term.split("\\^");
        this.variable = split[0];
        this.exponent = Integer.parseInt(split[1]);
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public String toString() {
        return String.format("%s ^ %d", this.variable, this.exponent);
    }
}
