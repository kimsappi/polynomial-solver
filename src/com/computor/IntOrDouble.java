package com.computor;

public class IntOrDouble extends Number implements Comparable<IntOrDouble> {
    public static final double nonZeroThreshold = 0.000000001;
    private boolean isInteger = false;
    // I wonder if I could just have a 'private Number value'
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

    public boolean isNonZero() {
        if (this.isInteger)
            return Util.abs(this.integer) > IntOrDouble.nonZeroThreshold;
        else
            return Util.abs(this.dbl) > IntOrDouble.nonZeroThreshold;
    }

    public boolean isPositive() {
        if (this.isInteger)
            return this.integer > 0;
        else
            return this.dbl > 0;
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

    private String getStringFormatString() { return this.isInteger ? "%d" : "%f"; }

    public String toString() {
        return String.format(this.getStringFormatString(), this.getValue());
    }

    public String absValueToString() {
        // Not very elegant, but apparently even the possibility of having a wrong value for the format string is
        // enough to make Java panic
        if (this.isInteger)
            return String.format("%d", Util.abs(this.integer));
        else
            return String.format("%f", Util.abs(this.dbl));
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
