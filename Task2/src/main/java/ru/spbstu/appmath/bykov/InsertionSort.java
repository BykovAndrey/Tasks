package ru.spbstu.appmath.bykov;

import java.util.Arrays;
import java.util.Comparator;

public class InsertionSort<T> implements  Sort<T>{
    public T[] sort (T[] array, Comparator<T> comparator) {
        T[] result = Arrays.copyOf(array, array.length);
        insertionSort(result,comparator);
        return result;
    }

    public static <T> void insertionSort(T[] array, Comparator<T> comparator){
        for (int i = 1; i < array.length; i++) {
            T dTmp = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (comparator.compare(array[j], dTmp) < 0)//(arr[j] < dTmp)
                    break;
                array[j + 1] = array[j];
                array[j] = dTmp;
            }
        }
    }
}
