import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OddOccurrencesInArrayTest {

    @BeforeEach
    void resetList(){
        OddOccurrencesInArray.dataList = new ArrayList<>();
    }

    @Test
    void addToList() {
        assertTrue(OddOccurrencesInArray.dataList.size()<1);
        OddOccurrencesInArray.setList(new int[]{3,4,5});
        List<Integer> expected = new LinkedList<>();
        expected.add(3);
        expected.add(4);
        expected.add(5);
        assertEquals(expected, OddOccurrencesInArray.dataList);
    }
    @Test
    void weHaveUnprocessedData() {
        OddOccurrencesInArray.setList(new int[]{});
        assertTrue(!OddOccurrencesInArray.weHaveUnprocessedData());

        OddOccurrencesInArray.setList(new int[]{3,4,5});
        assertTrue(OddOccurrencesInArray.weHaveUnprocessedData());

    }


    @Test
    void odd() {
        int[] data = new int[]{9, 3, 9, 3, 9, 7, 9};
        assertEquals(7, OddOccurrencesInArray.solution(data));
    }

    @Test
    void oddLarge(){
        int [] data = new int[]{
                9,3,9,3,9,9,
                9,3,9,3,9,9,6,
                9,3,9,3,9,9
        };
        assertEquals(6, OddOccurrencesInArray.solution(data));
    }

    @Test
    void oddLargest(){
        List<Integer> dataList= new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            dataList.add(9);
            dataList.add(8);
        }
        dataList.add(7);
        int[] data = new int[dataList.size()];

        for (int i = 0; i < dataList.size(); i++) {
            data[i]=dataList.get(i);
        }
        assertEquals(7, OddOccurrencesInArray.solution(data));
    }


}
