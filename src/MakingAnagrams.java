import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

        return deletions;

    }

    private static int calculateDeletions(String string1, String string2) {
        int string1Deletions = 0;
        List<Integer> string2MatchIndexes = new ArrayList<>();

        for (int i = 0; i < string1.length(); i++) {
            boolean matchFound = false;
            for (int j = 0; j < string2.length(); j++) {

                if (string1.charAt(i) == string2.charAt(j)
                    && !string2MatchIndexes.contains(j)) {
                    matchFound = true;
                    string2MatchIndexes.add(j);
                    break;//found a match, no need to delete
                }
            }
            if (!matchFound) {
                string1Deletions++;
            }
        }
        return string1Deletions + string2.length() - string2MatchIndexes.size();
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
