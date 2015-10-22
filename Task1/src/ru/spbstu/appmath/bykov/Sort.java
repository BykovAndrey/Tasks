package ru.spbstu.appmath.bykov;

public class Sort {
    public static void main(String[] args) {
        double[] dInputArr = parseString(args);
        sort(dInputArr);
        printArray(dInputArr);
    }

    public static void sort(double[] arr) {
        for (int i = 1; i < arr.length; i++) {
            double dTmp = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < dTmp) {
                    break;
                }
                arr[j + 1] = arr[j];
                arr[j] = dTmp;
            }
        }
    }

    public static double[] parseString(String[] input) {

        double result[] = new double[input.length];
        for (int i = 0; i < input.length; i++)
            result[i] = Double.parseDouble(input[i]);
        return result;
    }

    public static void printArray(double arr[]) {
        for (double elem : arr)
            System.out.printf("%f ", elem);
        System.out.println();
    }
}