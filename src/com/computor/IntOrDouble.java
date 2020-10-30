package com.computor;

public class IntOrDouble extends Number {
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
        System.out.printf("%d\n", this.integer);
        System.out.printf("%f\n", this.dbl);
        System.out.printf("%s\n", String.valueOf(isInteger()));
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

    /*public String toString() {
        if (this.isInteger)
            return String.format("%d", this.integer);
        else
            return String.format("%f", this.dbl);
    }*/

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
        return (int) this.longValue();
    }
}