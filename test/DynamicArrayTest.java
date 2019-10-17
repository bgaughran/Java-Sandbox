import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicArrayTest {

    @BeforeEach
    void setUp(){
        Result.N = 2;
        Result.lastAnswer = 0;
    }

    @Test
    void testCommonCalculation(){
        Result.N = 2;
        Result.lastAnswer = 0;

        assertEquals(0, Result.commonCalculation(0));
        assertEquals(1, Result.commonCalculation(1));

        Result.lastAnswer = 7;
        assertEquals(0, Result.commonCalculation(1));
    }

//    @Test
//    void testQueryCalculation(){
//        assertEquals();
//    }

    @Test
    void simple(){
        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(7);
        expectedList.add(3);

        List<Integer> query1 = new ArrayList<>();
        query1.add(1);
        query1.add(0);
        query1.add(5);
        List<Integer> query2 = new ArrayList<>();
        query2.add(1);
        query2.add(1);
        query2.add(7);
        List<Integer> query3 = new ArrayList<>();
        query3.add(1);
        query3.add(0);
        query3.add(3);
        List<Integer> query4 = new ArrayList<>();
        query4.add(2);
        query4.add(1);
        query4.add(0);
        List<Integer> query5 = new ArrayList<>();
        query5.add(2);
        query5.add(1);
        query5.add(1);
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(query1);
        queries.add(query2);
        queries.add(query3);
        queries.add(query4);
        queries.add(query5);

        assertEquals(expectedList, Result.dynamicArray(2, queries));
    }

//    @Test
//    void boundaryTest1(){
//        assertNull(Result.dynamicArray(0, null));
//    }
}
