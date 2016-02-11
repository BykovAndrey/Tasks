/**
 * Created by Андрей on 25.01.2016.
 */
package ru.spbstu.appmath.bykov;

public class Parser {
    public Expression parse(final String s) throws Exception {
        final String trimmed = s.trim();

        int plusPos = findPosOperator(trimmed, '+');
        int minusPos = findPosOperator(trimmed, '-');
        if (plusPos != -1) {
            if (trimmed.substring(0, plusPos).equals("") || trimmed.substring(plusPos + 1).equals(""))
                throw new Exception("Not enough arguments");
            return new Composition(parse(trimmed.substring(0, plusPos)), parse(trimmed.substring(plusPos + 1)), '+');
        } else if (minusPos != -1) {
            if (trimmed.substring(minusPos + 1).equals(""))
                throw new Exception("Not enough arguments");
            return new Composition(parse(trimmed.substring(0, minusPos)), parse(trimmed.substring(minusPos + 1)), '-');
        }

        int multPos = findPosOperator(trimmed, '*');
        if (multPos != -1) {
            if (trimmed.substring(0, multPos).equals("") || trimmed.substring(multPos + 1).equals(""))
                throw new Exception("Not enough arguments");
            return new Composition(parse(trimmed.substring(0, multPos)), parse(trimmed.substring(multPos + 1)), '*');
        }

        int divPos = findPosOperator(trimmed, '/');
        if (divPos != -1) {
            if (trimmed.substring(0, divPos).equals("") || trimmed.substring(divPos + 1).equals(""))
                throw new Exception("Not enough arguments");
            return new Composition(parse(trimmed.substring(0, divPos)), parse(trimmed.substring(divPos + 1)), '/');
        }

        final int openBracketPos = trimmed.indexOf('(');
        final int closeBracketPos = trimmed.lastIndexOf(')');
        if (openBracketPos != -1 && closeBracketPos != -1 && openBracketPos < closeBracketPos) {
            return parse(trimmed.substring(openBracketPos + 1, closeBracketPos));
        }

        if (openBracketPos == -1 && closeBracketPos == -1) {
            if (isNumber(trimmed)) {
                if (trimmed.equals(""))
                    return new Const(0);
                return new Const(Double.parseDouble(trimmed));
            }
            if ("x".equals(trimmed)) {
                return new Var();
            }
            throw new Exception("Unexpected symbol!");
        }
        throw new Exception("Syntax error!");
    }

    private static boolean isNumber(String s) {
        if (s.equals(""))
            return true;
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c) && c != '.')
                return false;
        }
        return true;
    }

    private static int findPosOperator(String trimmed, char op) {
        int index = 0;
        int pos;
        do {
            pos = trimmed.indexOf(op, index);
            index = getIndexLastClose(trimmed, pos);
        } while (inBrackets(trimmed, pos));
        return pos;
    }

    private static boolean inBrackets(String s, int i) {
        if (i != -1) {
            int cOpen = 0;
            int cClose = 0;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == '(')
                    cOpen++;
                if (s.charAt(j) == ')')
                    cClose++;
            }
            return cOpen != cClose;
        } else {
            return false;
        }
    }

    private static int getIndexLastClose(String s, int i) {
        if (i != -1) {
            int cOpen = 0;
            int cClose = 0;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == '(')
                    cOpen++;
                if (s.charAt(j) == ')')
                    cClose++;
            }
            int index = i;
            while (cOpen != cClose) {
                index = s.indexOf(')', index + 1);
                cClose++;
            }
            return index + 1;
        } else
            return 0;
    }

    private static boolean correctBrackets(String s) {
        int bracketsOpen = 0;
        int bracketsClose = 0;
        for (int i = 0; i < s.length(); ++i) {
            switch (s.charAt(i)) {
                case ('('): {
                    bracketsOpen++;
                    break;
                }
                case (')'): {
                    bracketsClose++;
                }
            }
            if (bracketsClose > bracketsOpen)
                return false;
        }
        return (bracketsOpen == bracketsClose);
    }
 }