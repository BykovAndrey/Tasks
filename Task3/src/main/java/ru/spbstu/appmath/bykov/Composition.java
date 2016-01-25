package ru.spbstu.appmath.bykov;

/**
 * Created by Андрей on 25.01.2016.
 */
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
        double result_l = this.left.calc(x);
        double result_r = this.right.calc(x);
        double result;
        switch (this.operation) {
            case '+':
                result = result_l + result_r;
                break;
            case '-':
                result = result_l - result_r;
                break;
            case '*':
                result = result_l * result_r;
                break;
            case '/':
                if (result_r == 0)
                    throw new Exception("Calculation error");
                result = result_l / result_r;
                break;
            default:
                result = 0;
        }
        return result;
        }
}
