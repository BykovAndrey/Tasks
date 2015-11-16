package ru.spbstu.appmath.bykov;

import ru.spbstu.appmath.bykov.Sort;

import java.util.Arrays;
import java.util.Comparator;


public class QuickSort<T> implements Sort<T> {
    public T[] sort(T[] array, Comparator<T> comparator) {
        T[] result = Arrays.copyOf(array, array.length);
        quickSort(result, 0, array.length - 1, comparator);
        return result;
    }

    private static <T> void quickSort(T[] array, int left, int right, Comparator<T> comparator) {
        int i = left;
        int j = right;
        T comp = array[(left + right) / 2];
        do {
            while (comparator.compare(array[i], comp) < 0 && (i < right))
                i++;
            while (comparator.compare(array[j], comp) > 0 && (j > left))
                j--;
            if (i <= j) {
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);
        if (left < j)
            quickSort(array, left, j, comparator);
        if (right > i)
            quickSort(array, i, right, comparator);
    }
}
