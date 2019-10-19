import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OddNumbersTest {
    List<Integer> numbers;
    int left;
    int right;

    @BeforeEach
    void setUp(){
        numbers = new ArrayList<>();
    }

    @Test
    void simpleFind(){
        left = 1;
        right = 4;
        numbers.add(1);
        numbers.add(3);
        assertEquals(numbers, OddNumbers.oddNumbers(left, right));
    }

    @Test
    void simpleFind2(){
        left = 1;
        right = 1;
        numbers.add(1);
        assertEquals(numbers, OddNumbers.oddNumbers(left, right));
    }

    @Test
    void notFound(){
        left = 2;
        right = 2;
        assertEquals(numbers, OddNumbers.oddNumbers(left, right));
    }

}
