package ru.spbstu.appmath.bykov;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.lang.String;

@RunWith(Parameterized.class)
public class SortTest <T> {
    private static final InsertionSort INSERTION_SORT = new InsertionSort();
    private static final QuickSort QUICK_SORT = new QuickSort();

    private static final Comparator<Double> DOUBLE_COMPARATOR_FIRST = new Comparator<Double>() {
        public int compare(final Double o1, final Double o2) {
            return o1.compareTo(o2);
        }
    };
    private static final Comparator<Double> DOUBLE_COMPARATOR_SECOND = new Comparator<Double>() {
        public int compare(final Double o1, final Double o2) {
            return o2.compareTo(o1);
        }
    };
    private static final Comparator<Human> HUMAN_COMPARATOR_NAME = new Comparator<Human>() {
        public int compare(final Human h1, final Human h2) {
            String tmp = h1.getName();
            return tmp.compareTo(h2.getName());
        }
    };

    private static final Comparator<Human> HUMAN_COMPARATOR_AGE = new Comparator<Human>() {
        public int compare(final Human o1, final Human o2) {
            Integer tmp = o1.getAge();
            return tmp.compareTo(o2.getAge());
        }
    };

    private static <T> boolean testAscendingOrder(T[] array, Comparator<T> comparator) {
        for (int i = 0; i < array.length - 1; i++) {
            if (comparator.compare(array[i],array[i + 1]) >= 0)
                return false;
        }
        return true;
    }

    private static <T> boolean hasEachElementOf(T[] input, T[] result) {
        for (T element : input) {
            for (int j = 0; j < result.length; j++) {
                if (result[j] == element)
                    break;
                if (j == result.length - 1)
                    return false;
            }
        }
        return true;
    }

//    private static <T> boolean hasEachElementOf(T[] input, T[] result) {
//        for (T element : input) {
//            boolean IsRes = false;
//            boolean IsInp = false;
//            for (int j = 0; j < result.length; j++) {
//                if (element.equals(result[j])) {
//                    IsRes = true;
//                }
//                if (element.equals(input[j])) {
//                    IsInp = true;
//                }
//            }
//            if(!IsOk)
//                return false;
//        }
//        return true;
//    }
    private static final Object[][] TEST_DATA = {
            {QUICK_SORT, new Double[]{1.1234, 0.123455, 3.0},DOUBLE_COMPARATOR_FIRST},//0
            {INSERTION_SORT, new Double[]{3.0, 2.0, 1.0},DOUBLE_COMPARATOR_FIRST},//1
            {INSERTION_SORT, new Double[]{33.0, 11.0, 111.0},DOUBLE_COMPARATOR_FIRST},//2
            {INSERTION_SORT, new Double[]{131.4, 224.0, 23.0, 352.5},DOUBLE_COMPARATOR_FIRST},//3
            {INSERTION_SORT, new Human[]{new Human("Andrey",19), new Human ("Alexander",24), new Human ("Leonid",14),//4
                    new Human ("Ivankov",103)},HUMAN_COMPARATOR_AGE},
            {INSERTION_SORT, new Human[]{new Human("Vasiliy",3), new Human ("Alexander",1), new Human ("Nikolay",2),//5
                    new Human ("Ivankov",103)},HUMAN_COMPARATOR_AGE},
            {INSERTION_SORT, new Human[]{new Human("Viktoria",32), new Human ("Vera",24), new Human ("Michael",14),//6
                    new Human ("Ivankov",103)},HUMAN_COMPARATOR_NAME}
    };

    private Sort<T> sort;
    private T[] input;
    private final Comparator<T> comparator;

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(TEST_DATA);
    }

    public SortTest(Sort<T> sort, T[] input, Comparator<T> comparator) {
        this.sort = sort;
        this.input = input;
        this.comparator = comparator;
    }

    @Test
    public void test() {
        T[] result = sort.sort(input, (Comparator<T>) comparator);
        Assert.assertTrue(testAscendingOrder(result,comparator));
        Assert.assertEquals("Result array length should be equal to original", input.length, result.length);
        Assert.assertTrue(hasEachElementOf(input, result));
    }
}
