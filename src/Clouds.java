import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Clouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        /*
            iterate thru array
            set counter for number of jumps
            check 2 ahead for bad cloud or end of loop. If ok, jump and increment.
            If not, check if one jump is end of loop. If not, jump one and increment
        */
        int count = 0;
        for (int i = 0; i < c.length; i++) {
            System.out.println("count=" + count);
            System.out.println("i=" + i);

            //stop if at end of loop
            if (i + 1 >= c.length) {
                System.out.println("termimating");
                break;
            }
            if (i + 2 < c.length && c[i + 2] != 1) {
                System.out.println("detected 2 count");
                System.out.println("c[i+2]=" + c[i + 2]);

                //jump and increment
                i = i + 1;
                count++;
                continue;
            }
            if (i + 1 < c.length && c[i + 1] != 1) {
                System.out.println("detected 1 count");
                System.out.println("c[i+1]=" + c[i + 1]);
                //jump and increment
                // i=i+1;
                count++;
            }
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
