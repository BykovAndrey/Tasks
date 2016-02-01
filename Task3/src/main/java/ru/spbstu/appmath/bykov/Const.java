/**
 * Created by Андрей on 25.01.2016.
 */
package ru.spbstu.appmath.bykov;

public class Const implements Expression {
    private double val = 0;
    public Const(double value) {
        this.val = value;
    }

    public double calc(double x) {
        return this.val;
    }
}
