import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SockMerchant {

    // Complete the sockMerchant function below.
    private static int sockMerchant(int arraySize, int[] ar) {

        //todo: why pass n? We can determine from size of the array

        int pairCount = 0;
        List<Integer> indexesOfMatchesToIgnore = new ArrayList<>();

        /*
            for every entry, scan the array for a match
                if a match found
                    increment 'matchCount'
                    log the array index to ignore
                    then start again at the start
                if no match found, start at next item until reach the end
        */
        for (int referenceIndex = 0; referenceIndex < arraySize; referenceIndex++) {

            int colourToMatch = ar[referenceIndex];

            // System.out.println("colourToMatch: " + colourToMatch);
            // System.out.println("arrayIndexNotToMatch: " + i);


            for (int j = 0; j < arraySize; j++) {

                //skip if not a colour match
                if (colourToMatch != ar[j]) {
                    continue;
                }
                //skip if we are looking at ourselves!
                if (j == referenceIndex) {
                    continue;
                }
                //skip if this is already referring to indexes of a matching pair
                if (indexesOfMatchesToIgnore.contains(referenceIndex)) {
                    continue;
                }
                if (indexesOfMatchesToIgnore.contains(j)) {
                    continue;
                }

                System.out.println("match found: " + ar[j]
                        + " at indexes: "
                        + referenceIndex
                        + ","
                        + j);

                //add match indexes
                indexesOfMatchesToIgnore.add(referenceIndex);
                indexesOfMatchesToIgnore.add(j);

                System.out.println(indexesOfMatchesToIgnore);

                pairCount++;
                break;
            }

        }
        return pairCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
