import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CompareTheTriplets {

    private static List<Integer> score;

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> alice, List<Integer> bob) {
        initialiseScore();

        for (int i = 0; i < alice.size(); i++) {
            if (alice.get(i) > bob.get(i)) {
                int currentAliceScore = score.get(0);
                score.set(0, currentAliceScore + 1);
            }
            if (alice.get(i) < bob.get(i)) {
                int currentBobScore = score.get(1);
                score.set(1, currentBobScore + 1);
            }
        }

        return score;

    }

    private static void initialiseScore() {
        score = new ArrayList<>();
        score.add(0);
        score.add(0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
