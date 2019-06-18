import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeftRotation {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the rotateLeft function below.
    static int[] rotateLeft(int[] sourceArray, int rotations) {
        /*
           Create  list to hold new array
           Move index to the starting point
           Grab the remainder and store
           Grab whats left and store
           return
         */

        List<Integer> originalList = new ArrayList<>();
        for (int element : sourceArray) {
            originalList.add(element);
        }

        List<Integer> rotatedList = new ArrayList<Integer>();
        //cater for lists of size 1
        if (originalList.size() > 1) {
            rotatedList = originalList.subList(rotations, sourceArray.length - 1);
            rotatedList.add(originalList.get(originalList.size() - 1)); //add the last element (cannot get from sublist)
        }
        List<Integer> remainingChunk = originalList.subList(0, rotations);
        rotatedList.addAll(remainingChunk);

        int[] rotatedListArrayPrimitives = new int[rotatedList.size()];
        for (int i = 0; i < rotatedList.size(); i++) {
            rotatedListArrayPrimitives[i] = rotatedList.get(i);
        }

        return rotatedListArrayPrimitives;
    }


    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotateLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
