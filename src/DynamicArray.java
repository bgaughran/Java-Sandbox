import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    static int lastAnswer = 0;
    static int N;
    private static List<List<Integer>> sequences = new ArrayList(new ArrayList<>());;
    private static List<Integer> result = new ArrayList<>();


    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> theQueries) {
        N = n;

        initiialiseSequenceList();

        for (List<Integer> query : theQueries) {
            if (query.get(0) == 1) {
                query1(query.get(1), query.get(2));
            } else if (query.get(0) == 2) {
                query2(query.get(1), query.get(2));
            }
        }

        return result;
    }

    static void initiialiseSequenceList() {
        for(int i = 0 ; i < N; i++){
            sequences.add(new ArrayList<>());
        }
    }

    static int commonCalculation(int x) {
        return (x ^ lastAnswer) % N;
    }

    static void query1(int x, int y) {
        //find the sequence (always has size > 0)
        List<Integer> sequence = sequences.get(commonCalculation(x));
        sequence.add(y);

    }

    static void query2(int x, int y) {
        //find the sequence
        List<Integer> sequence = sequences.get(commonCalculation(x));
        lastAnswer = sequence.get(y%sequence.size());
        System.out.println(lastAnswer);
        result.add(lastAnswer);
    }


}

public class DynamicArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.dynamicArray(n, queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
