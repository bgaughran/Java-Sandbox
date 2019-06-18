import java.util.ArrayList;
import java.util.List;

/**
 * convert to binary
 * search for 1
 * search for next 1
 * add number of 0s to List
 * repeat
 */
public class BinaryGap {

    private static List<Integer> gapCounts;

    public static int solution(int N) {
        gapCounts = new ArrayList<>();
        String binary = toBinary(N);
//        System.out.println("binary="+binary);

        boolean countStart = false;
        int start = 0;
        int end;
        char bit;

        for (int i = 0; i < binary.toCharArray().length; i++) {
            bit = binary.toCharArray()[i];
            if (bit == '1' && !countStart) {
                countStart = true;
                start = i;
                continue;
            }
            if (bit == '0' && !countStart) {
                continue;
            }
            if (bit == '0') {
                continue;
            }
            if (bit == '1') {
                end = i;
                int gap = end-start-1;
//                System.out.println("Adding:"+gap+"for position"+start+"->"+end);
                gapCounts.add(gap);
                start=end;
            }

        }

        int max = 0;
//        System.out.println(gapCounts);
        for (Integer gapCount : gapCounts) {
            if (gapCount > max) {
                max = gapCount;
            }
        }

//TODO                OPTIMISE
//TODO                USE LAMBAS?

        return max;
    }

    static String toBinary(int N) {
        return Integer.toBinaryString(N);
    }

}