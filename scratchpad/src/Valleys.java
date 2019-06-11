import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Valleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int count = 0;
        boolean inAValley = false;
        int altitude = 0;

        /*
            Pseudo code solution:
            loop through all steps
            keep count of valleys indicated by the number of times
                1 - go below sea level
                2 - another valley found when return to sea level followed by step 1
        */
        for (int i=0; i<n; i++){

            char currentChar = s.charAt(i);
            System.out.println("currentChar:"+currentChar);
            System.out.println("altitude:"+altitude);

            altitude = adjustAltitude(currentChar, altitude);
            System.out.println("adjustedAltitude:"+altitude);

            System.out.println("inAValley before:"+inAValley);
            System.out.println("count before:"+count);

            if (altitude < 0 && !inAValley){
                count++;
                inAValley = true;
            }
            if (altitude >= 0 ){
                inAValley = false;
            }
            System.out.println("inAValley after:"+inAValley);
            System.out.println("count after:"+count);
            System.out.println();

        }

        return count;
    }

    private static int adjustAltitude (char step, int altitude){
        if (step=='U'){
            altitude++;
        }
        if (step=='D'){
            altitude--;
        }
        return altitude;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
