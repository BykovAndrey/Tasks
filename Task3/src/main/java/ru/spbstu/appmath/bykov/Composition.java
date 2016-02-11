/**
 * Created by Андрей on 25.01.2016.
 */
package ru.spbstu.appmath.bykov;

public class Composition implements Expression {
    private Expression left = null;
    private Expression right = null;
    private char operation = 0;

    public Composition(Expression left, Expression right, char operation) {
        this.left = left;
        this.right = right;
        this.operation = operation;
    }

    public double calc(double x) throws Exception {
        double resultL = this.left.calc(x);
        double resultR = this.right.calc(x);
        double result;
        switch (this.operation) {
            case '+':
                result = resultL + resultR;
                break;
            case '-':
                result = resultL - resultR;
                break;
            case '*':
                result = resultL * resultR;
                break;
            case '/':
                if (resultR == 0)
                    throw new Exception("Calculation error");
                result = resultL / resultR;
                break;
            default:
                result = 0;
        }
        return result;
    }
}
