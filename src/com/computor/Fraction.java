package com.computor;

public class Fraction {
    private int n;
    private int d;

    public Fraction(int numerator, int denominator) {
        this.n = numerator;
        this.d = denominator;

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

    public int[] toArr() {
        return new int[] {this.n, this.d};
    }

    public String toString() {
        if (this.d == 1)
            return String.format("%d", this.n);
        else
            return String.format("%d / %d", this.n, this.d);
    }
}
