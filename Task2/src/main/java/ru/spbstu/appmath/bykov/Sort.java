/**
 * Created by Андрей on 17.10.2015.
 */
package ru.spbstu.appmath.bykov;

import java.util.Comparator;

public class Sort<T> implements Sortings<T> {

    public T[] sort (T[] arr, Comparator<T> comparator) {
        int i = 0;
        int j = 0;
        T[] result = arr;
        for (i = 1; i < arr.length; i++) {
            T dTmp = arr[i];
            for (j = i - 1; j >= 0; j--) {
                if (comparator.compare(arr[i], dTmp) < 0)//(arr[j] < dTmp)
                    break;
                arr[j + 1] = arr[j];
                arr[j] = dTmp;
            }
        }
        return result;
    }
    public static double[] parseString(String[] input) {
        double result[] = new double[input.length];
        for (int i = 0; i < input.length; i++)
            result[i] = Double.parseDouble(input[i]);
        return result;
    }
    public static void printArray(double arr[]) {
        for (int i = 0; i < arr.length; ++i)
            System.out.printf("%g ", arr[i]);
        System.out.println();
    }
}
