package com.computor;

public class Fraction {
    private int n, d;
    private int signMultiplier = 1;

    public Fraction(int numerator, int denominator) {
        this.n = Util.abs(numerator);
        this.d = Util.abs(denominator);

        if (numerator * denominator < 0)
            this.signMultiplier = -1;

        this.reduce();
    }

    private void reduce() {
        int gcd = gcd(this.n, this.d);

        this.n /= gcd;
        this.d /= gcd;
    }

    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public int[] toArr() { return new int[] {this.signMultiplier * this.n, this.d}; }

    public String toString() {
        if (this.d == 1)
            return String.format("%d", this.n);
        else
            return String.format("%d / %d", this.signMultiplier * this.n, this.d);
    }
}
