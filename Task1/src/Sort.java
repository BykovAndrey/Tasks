import static java.lang.System.out;

public class Sort {
    public static void main(String[] args) {
       // double[] dArray = {3.8,3.1,0.56,5,6,8,9,1};
        double[] dInputArr = parseString(args);
        sort(dInputArr);
        printArray(dInputArr);
    }
    public static void sort (double[] arr) {
        int i = 0;
        int j = 0;
        for (i = 1; i < arr.length; i++) {
            double dTmp = arr[i];
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] < dTmp)
                    break;
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
        for (int i = 0; i < arr.length; ++i)
            System.out.printf("%g ", arr[i]);
        System.out.println();
    }
}