package com.computor;

public class Parser {

    public static String[] parseFormula(String formula) {
        return formula.split(" ");
    }

    public static Object[] parseOperandsOperators(String[] formula) {
        Object[] ret = new Object[formula.length];
        for (int i = 0; i < formula.length; ++i) {
            System.out.printf("%d %s\n", i, formula[i]);
            Object term = Parser.parseTerm((formula[i]));
            ret[i] = term;
        }
        return ret;
    }

    static Object parseTerm(String term) {
        try {
            return Double.parseDouble(term);
        } catch(Exception e) {
            if (term.contains("^"))
                return new Term(term);
            else
                return term;
        }
    }

}
