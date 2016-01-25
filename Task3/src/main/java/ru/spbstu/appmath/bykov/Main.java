/**
 * Created by Андрей on 25.01.2016.
 */
package ru.spbstu.appmath.bykov;

public class Main {
public void main(String[] args) {
    double var;
    if(args.length == 2) {
        var = Double.parseDouble(args[1]);
    }else if (args.length == 1) {
        var = 0;
    }else {
        System.out.println("Argiments Error");
        return;
    }
}
}
