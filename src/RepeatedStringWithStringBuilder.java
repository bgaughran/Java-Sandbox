import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RepeatedStringWithStringBuilder {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        /*
            Generate the string
                stop if n=generated
                check is n > generated
                    if so, repeat
                if n < generated, cut to size of n
            Loop through string to find number of 'a' chars
        */
        int count = 0;
        StringBuilder built = new StringBuilder();
        int repeatedStringLength = s.length();

        while (built.length() < n) {
            //check if I need to append a substring
            if (repeatedStringLength + built.length() > n) {
                //check substring size required
                Long subSize = repeatedStringLength + built.length() - n;
                String sub = built.substring(0, subSize.intValue());
                built.append(sub);

            } else {
                built.append(s);
            }
//            System.out.print(built.length() + ",");

        }
//        System.out.println(built);

        String builtString = built.toString();
        for (int i = 0; i < builtString.length(); i++) {
            if (builtString.charAt(i) == 'a') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
