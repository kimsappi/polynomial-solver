package com.computor;

public class IntOrDouble extends Number implements Comparable<IntOrDouble> {
    private boolean isInteger = false;
    private double dbl;
    private int integer;

    public IntOrDouble(Number x) {
        if (x instanceof Integer) {
            this.isInteger = true;
            this.integer = (int) x;
        }
        else
            this.dbl = (double) x;
    }

    public Number getValue() {
        if (this.isInteger)
            return this.integer;
        else
            return this.dbl;
    }

    public void sum(IntOrDouble other) {
        if (this.isInteger) {
            if (other.isInteger())
                this.integer += (int) other.getValue();
            else {
                this.dbl = (double) this.integer + (double) other.getValue();
                this.isInteger = false;
            }
        } else {
            this.dbl += (double) other.getValue();
        }
    }

    public void multiply(IntOrDouble other) {
        /*System.out.printf("%d\n", this.integer);
        System.out.printf("%f\n", this.dbl);
        System.out.printf("%s\n", String.valueOf(isInteger()));*/
        if (this.isInteger) {
            if (other.isInteger())
                this.integer *= (int) other.getValue();
            else {
                this.dbl = (double) this.integer * (double) other.getValue();
                this.isInteger = false;
            }
        } else {
            this.dbl *= (double) other.getValue();
        }
    }

    public String toString() {
        String format = this.isInteger ? "%d" : "%f";

        return String.format(format, this.getValue());
    }

    public boolean isInteger() {
        return this.isInteger;
    }

    @Override
    public int compareTo(IntOrDouble other) {
        double comparison = this.doubleValue() - other.doubleValue();

        if (comparison > 0)
            return 1;
        else if (comparison < 0)
            return -1;
        else
            return 0;
    }

    public boolean equals(IntOrDouble other) {
        return this.getValue() == other.getValue();
    }

    @Override
    public double doubleValue() {
        return this.isInteger ? (double) this.integer : this.dbl;
    }

    @Override
    public float floatValue() {
        return (float) this.doubleValue();
    }

    @Override
    public long longValue() {
        return (long) this.doubleValue();
    }

    @Override
    public int intValue() {
        return this.integer;
    }
}
