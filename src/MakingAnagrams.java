import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MakingAnagrams {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the makeAnagram function below.
    static int makeAnagram(String string1, String string2) {

        int deletions = 0;
        if (string1.length() == 1 & string2.length() == 1) {
            return 0;
        }

        deletions += calculateDeletions(string1, string2);
        deletions += calculateDeletions(string2, string1);

        return deletions;

    }

    private static int calculateDeletions(String stringBuilder1, String stringBuilder2) {
        int deletions = 0;
        for (int i = 0; i < stringBuilder1.length(); i++) {
            boolean matchFound = false;
            for (int j = 0; j < stringBuilder2.length(); j++) {

                if (stringBuilder1.charAt(i) == stringBuilder2.charAt(j)) {
                    matchFound = true;
                    break;//found a match, no need to delete
                }
            }
            if (!matchFound) {
                deletions++;
            }
        }
        return deletions;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
