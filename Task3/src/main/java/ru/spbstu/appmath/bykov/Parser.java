package ru.spbstu.appmath.bykov;

/**
 * Created by Андрей on 25.01.2016.
 */
public class Parser {
    public Parser() {
    }
    public Expression parse(String s) throws Exception{
        String trimStr = s.trim();

        int additionPos = findPosOperator(trimStr, '+');
        int substractionPos = findPosOperator(trimStr, '-');
        if (additionPos != -1 && (substractionPos == -1 || additionPos <  substractionPos)) {
            return new Composition(parse(trimStr.substring(0, additionPos)), parse(trimStr.substring(additionPos + 1)), '+');
        } else if (substractionPos != -1) {
            return new Composition(parse(trimStr.substring(0, substractionPos)), parse(trimStr.substring(substractionPos + 1)), '-');
        }

        int multiplicationPos = findPosOperator(trimStr, '*');
        if (multiplicationPos != -1) {
            return new Composition(parse(trimStr.substring(0,multiplicationPos)), parse(trimStr.substring(multiplicationPos + 1)), '*');
        }

        int divisionPos = findPosOperator(trimStr, '/');
        if (divisionPos != -1) {
            return new Composition(parse(trimStr.substring(0, divisionPos)), parse(trimStr.substring(divisionPos + 1)), '/');
        }

        final int openBracketPos = trimStr.indexOf('(');
        final int closeBracketPos = trimStr.lastIndexOf(')');
        if (openBracketPos != -1 && closeBracketPos != -1 && openBracketPos < closeBracketPos) {
            return parse(trimStr.substring(openBracketPos + 1, closeBracketPos));
        }

        if (openBracketPos == -1 && closeBracketPos == -1) {
            if (isNumber(trimStr)) {
                if (trimStr.equals(""))
                    return new Const(0);
                return new Const(Double.parseDouble(trimStr));
            }
            if ("x".equals(trimStr)) {
                return new Var();
            }
            throw new Exception("Syntax error!");
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

    private int findPosOperator(String trimStr, char op) throws Exception {
        int index = 0;
        int pos;
        do {
            pos = trimStr.indexOf(op, index);
            index = getIndexLastClose(trimStr, pos);
        } while (inBrackets(trimStr, pos));
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

    private static int getIndexLastClose(String s, int i) throws Exception {
        if (i != -1) {
            int cOpen = 0;
            int cClose = 0;
            for (int j = 0; j < i ; j++) {
                if (s.charAt(j) == '(')
                    cOpen++;
                if (s.charAt(j) == ')')
                    cClose++;
            }
            int index = i;
            while (cOpen != cClose) {
                index = s.indexOf(')', index + 1);
                if (index != -1)
                    cClose++;
                else
                    throw new Exception("Syntax error");
            }
            return index + 1;
        }
        else
            return 0;
    }
}