package com.computor.Equations;

public class OtherEquation implements IEquation {
    public OtherEquation() {}

    public String solve() {
        return "The polynomial exponents are not integers or are outside the range [0..2], cannot solve.";
    }
}
