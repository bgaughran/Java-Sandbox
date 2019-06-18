import java.util.LinkedList;
import java.util.List;

public class OddOccurrencesInArray {
    static List<Integer> dataList = new LinkedList<>();


    /**
     * return the only unpaired element
     * start at 0 and check if it has a pair
     * if not, exit
     * if so, remove them and start at beginning
     */

    public static int solution(int[] data) {

        setList(data);
        int value = 0;

        while (weHaveUnprocessedData()) {

            value =  dataList.get(0);

            if (dataList.size()==1)  {
                break;
            }

            dataList.remove(0);
            int foundIndex = dataList.indexOf(value);//find next
            if (foundIndex != -1) { //found a match, so remove
                dataList.remove(foundIndex);
            } else {
                break;
            }
        }
        return value;

    }

     static boolean weHaveUnprocessedData() {
        return dataList.size() >= 1;
    }

    static void setList(int[] data) {
        dataList.clear();
        for (int i : data) {
            dataList.add(i);
        }
    }

}
