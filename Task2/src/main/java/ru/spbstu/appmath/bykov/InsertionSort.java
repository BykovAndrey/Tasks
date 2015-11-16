package ru.spbstu.appmath.bykov;

import java.util.Arrays;
import java.util.Comparator;

public class InsertionSort<T> implements  Sort<T>{
    public T[] sort (T[] array, Comparator<T> comparator) {
        T[] result = Arrays.copyOf(array, array.length);;
        for (int i = 1; i < result.length; i++) {
            T dTmp = result[i];
            for (int j = i - 1; j >= 0; j--) {
                if (comparator.compare(result[i], dTmp) < 0)//(arr[j] < dTmp)
                    break;
                result[j + 1] = result[j];
                result[j] = dTmp;
            }
        }
        return result;
    }
}
