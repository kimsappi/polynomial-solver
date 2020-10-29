package com.computor;

public class Term {
    private double coefficient = 1;
    private String variable;
    private IntOrDouble exponent;

    public Term(String term) {
        try {
            this.coefficient = Double.parseDouble(term);
            this.variable = null;
            this.exponent = new IntOrDouble(0);
        } catch(Exception e) {
            String[] split = term.split("\\^");
            if (split.length > 2)
                throw new IllegalArgumentException("Illegal term with 2 carets.");
            this.variable = split[0];
            if (split.length == 2)
                this.exponent = new IntOrDouble(Integer.parseInt(split[1]));
            else
                this.exponent = new IntOrDouble(1);
        }
    }

    public void multiplyByTerm(Term other) {
        if (this.variable != null && other.variable != null && !this.variable.equals(other.variable))
            throw new IllegalArgumentException("Cannot multiply Term by Operator");
        else if (this.variable == null)
            this.variable = other.variable;
        this.coefficient *= other.coefficient;
        this.exponent.sum(other.exponent);
    }

    public void flipSign() {
        this.coefficient *= -1;
    }

    public String toString() {
        return String.format("%f * %s ^ %d", this.coefficient, this.variable, this.exponent);
    }

    public String getVariable() {
        return this.variable;
    }

    public Number getExponent() {
        return this.exponent.getValue();
    }

    public double getCoefficient() {
        return this.coefficient;
    }
}
