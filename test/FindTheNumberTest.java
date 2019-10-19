import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindTheNumberTest {
    List<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new ArrayList<>();
    }

    @Test
    void simpleFind(){
        numbers.add(2);
        assertEquals("YES", FindTheNumber.findNumber(numbers, 2));
    }

    @Test
    void moreComplexFind(){
        numbers.add(1);
        numbers.add(12);
        numbers.add(4);
        numbers.add(2);
        numbers.add(77);
        numbers.add(5);
        assertEquals("YES", FindTheNumber.findNumber(numbers, 77));
    }

    @Test
    void notFoundTest(){
        numbers.add(1);
        assertEquals("NO", FindTheNumber.findNumber(numbers, 0));
    }

    @Test
    void nullOrEmptyList(){
        assertEquals("NO", FindTheNumber.findNumber(null, 0));
        assertEquals("NO", FindTheNumber.findNumber(numbers, 0));
    }


    @Test
    void largeNumberToFindWithNegative(){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(234452355);
        assertEquals("NO", FindTheNumber.findNumber(numbers, -9));
    }


}
