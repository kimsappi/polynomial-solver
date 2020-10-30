package com.computor;

public class Parser {

    public static String[] parseFormula(String formula) {
        return formula.split(" ");
    }

    public static Object[] parseOperandsOperators(String[] formula) {
        Object[] ret = new Object[formula.length];
        for (int i = 0; i < formula.length; ++i) {
            Object term = Parser.parseTerm((formula[i]));
            ret[i] = term;
        }
        return ret;
    }

    static Object parseTerm(String term) {
        if (Operator.checkIfOperator(term))
            return new Operator(term);
        else
            return new Term(term);
    }

    static IntOrDouble parseIntOrDouble(String str) {
        try {
            return new IntOrDouble(Integer.parseInt(str));
        } catch (Exception e) {
            return new IntOrDouble(Double.parseDouble(str));
        }
    }

}
