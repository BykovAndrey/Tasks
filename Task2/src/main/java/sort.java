/**
 * Created by Андрей on 03.10.2015.
 */
public class sort {

    public static void main(String[] args) {

        double[] dArray = {3.8,3.1,0.56,5,6,8,9,1};
        int i = 0;
        int j = 0;
        double dTmp;

        for (i = 1; i < dArray.length; i++)
        {
            dTmp = dArray[i];
            for (j = i - 1; j >= 0; j--)
            {
                if (dArray[j] < dTmp)
                    break;
                dArray[j + 1] = dArray[j];
                dArray[j] = dTmp;
            }
        }
    }
    private static double[] parseString(String[] input) {
        double result[] = new double[input.length];
        for (int i = 0; i < input.length; i++)
            result[i] = Double.parseDouble(input[i]);
        return result;
    }

    public static void printArray(double arr[]) {
        for (int i = 0; i < arr.length; ++i)
            out.printf("%g ", arr[i]);
        out.println();
    }
}
