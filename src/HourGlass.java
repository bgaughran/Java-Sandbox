import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HourGlass {

    private static final Scanner scanner = new Scanner(System.in);

    static int hourglassSum(int[][] arr) {

        List<Integer> hourGlassSums = new ArrayList<>();

        /*
            Background....
                Given a  2D Array, arr
                We define an hourglass in A
                There are 16 hourglasses in A (4*4), and an hourglass sum is the sum of an hourglass' values.

            Algorithm...
                Calculate the hourglass sum for every hourglass in , then return the maximum hourglass sum.
                    Get the elements of the array, sum & store sum
                    Return largest number
         */
        hourGlassSums.add(sumOneHourGlass(0, 0, arr));
        hourGlassSums.add(sumOneHourGlass(0, 1, arr));
        hourGlassSums.add(sumOneHourGlass(0, 2, arr));
        hourGlassSums.add(sumOneHourGlass(0, 3, arr));

        hourGlassSums.add(sumOneHourGlass(1, 0, arr));
        hourGlassSums.add(sumOneHourGlass(1, 1, arr));
        hourGlassSums.add(sumOneHourGlass(1, 2, arr));
        hourGlassSums.add(sumOneHourGlass(1, 3, arr));

        hourGlassSums.add(sumOneHourGlass(2, 0, arr));
        hourGlassSums.add(sumOneHourGlass(2, 1, arr));
        hourGlassSums.add(sumOneHourGlass(2, 2, arr));
        hourGlassSums.add(sumOneHourGlass(2, 3, arr));

        hourGlassSums.add(sumOneHourGlass(3, 0, arr));
        hourGlassSums.add(sumOneHourGlass(3, 1, arr));
        hourGlassSums.add(sumOneHourGlass(3, 2, arr));
        hourGlassSums.add(sumOneHourGlass(3, 3, arr));

        return maxOfHourGlassSums(hourGlassSums);
    }

    static int sumOneHourGlass(int rowStart, int colStart, int[][] arr) {

        int sum = 0;
        sum += arr[rowStart][colStart];
        sum += arr[rowStart][colStart + 1];
        sum += arr[rowStart][colStart + 2];
        sum += arr[rowStart + 1][colStart + 1];
        sum += arr[rowStart + 2][colStart];
        sum += arr[rowStart + 2][colStart + 1];
        sum += arr[rowStart + 2][colStart + 2];


        return sum;
    }

    static int maxOfHourGlassSums(List hourGlassSums) {

        int max = -2147483648;

        for (Object hourGlassSum : hourGlassSums) {

            int nextInt = (Integer) hourGlassSum;
            if (nextInt > max) {
                max = nextInt;
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
