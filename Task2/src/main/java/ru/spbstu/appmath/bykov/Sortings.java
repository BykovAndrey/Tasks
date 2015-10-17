/**
 * Created by Андрей on 17.10.2015.
 */
package ru.spbstu.appmath.bykov;

import java.util.Comparator;


public interface Sortings<T> {
    T[] sort(T[] array, Comparator<T> comparator);
}
