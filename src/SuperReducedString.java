import java.io.*;

import static java.util.stream.Collectors.joining;

public class SuperReducedString {
    static StringBuffer reducedString = null;

    // Complete the superReducedString function below.
    static String superReducedString(String theString) {

        reducedString = new StringBuffer(theString);

        int index = 0;
        int lastIndex = 0;

        do {
            if (foundMatchAtIndex(index)){
                removeFirstTwoCharactersFromIndex(index);
                index=0; //start again
            } else {
                index++;
            }

            lastIndex = reducedString.length() - 1;

        } while (index < lastIndex);

        if(reducedString.length()<1){
            return "Empty String";
        }

        return reducedString.toString();
    }

    static void removeFirstTwoCharactersFromIndex(int index) {
        reducedString.delete(index, index+2);
    }

    static boolean foundMatchAtIndex(int index) {
        return reducedString.substring(index, index+1).equals(reducedString.substring(index+1, index+2));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
