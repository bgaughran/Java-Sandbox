import java.io.*;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


class MaximiseProfitFromStocksResult {

    static List<Integer> prices;

    /*
     * Complete the 'maximumProfit' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY price as parameter.
     *
     * The trading strategy algorithm is as follows:
     * 1    - scan for first occurrence of the highest number until a subsequent dip is detected
     * 2    - calculate potential profit of this trade
     * 3(a) - if profitable, buy the shares & bank the profit and repeat steps 1 & 2 at the detected dip
     * 3(b) - else, repeat step 1 at the detected dip
     * 5    - return profits accumulated
     */

    public static long maximumProfit(List<Integer> thePrices) {
        long profit = 0;

        //simplify helper methods by avoiding passing around the array into utility methods
        prices = thePrices;

        //ignore single entry array
        if (prices.size() < 2) {
            return 0;
        }

        for (int i = 0; i < prices.size(); i++) {
            int nextHighestBeforeDip = findIndexOfHighestOccuringIntegerBeforeADipOccurs(i);
            long profitUntilNextDip = calculateProfitForRange(i, nextHighestBeforeDip);
            profit += profitUntilNextDip;
            i = nextHighestBeforeDip;//progress the index
        }

        return profit;
    }

    static long calculateProfitForRange(int start, int nextIndexHighestBeforeDip) {
        long profit = 0;
        long purchasePrice = 0;
        long salesPrice = prices.get(nextIndexHighestBeforeDip) * (nextIndexHighestBeforeDip - start);

        for (int i = start; i < nextIndexHighestBeforeDip; i++) { //ignoring the first highest price
            purchasePrice += prices.get(i);
        }

        //only return a positive profit
        profit = (salesPrice - purchasePrice);
        if (profit > 0) {
            return profit;
        }

        return 0;
    }

    static int findIndexOfHighestOccuringIntegerBeforeADipOccurs(int startIndex) {

        int firstHighestIndexUntilDip = 0;
        long firstHighestPriceUntilDip = 0;

        for (int index = startIndex; index < prices.size(); index++) {
            int current = prices.get(index);

            //break - nothing to compare on the very first price
            if (index < 1) {
                firstHighestPriceUntilDip = current;
                continue;
            }

            if (current > firstHighestPriceUntilDip) {
                firstHighestIndexUntilDip = index;
                firstHighestPriceUntilDip = current;
            } else {
                break; //dip detected after a high
            }

        }
        return firstHighestIndexUntilDip;
    }

}

public class MaximiseProfitFromStocks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> price = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                long profit = MaximiseProfitFromStocksResult.maximumProfit(price);

                bufferedWriter.write(String.valueOf(profit));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
