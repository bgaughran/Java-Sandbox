import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryGap2Test {
    BinaryGap2 binaryGap2;

    @BeforeEach
    void setUp(){
        binaryGap2 = new BinaryGap2();
    }

    @Test
    void binary() {
        assertEquals(0, binaryGap2.solution(32));
        assertEquals(2, binaryGap2.solution(9));
        assertEquals(4, binaryGap2.solution(529));
        assertEquals(1, binaryGap2.solution(20));
        assertEquals(0, binaryGap2.solution(15));
        assertEquals(0, binaryGap2.solution(32));

    }    @Test
    void binaryTrailingZeros() {
        assertEquals(2, binaryGap2.solution(328));
        assertEquals(3, binaryGap2.solution(1162));
        assertEquals(2, binaryGap2.solution(51712));

    }

    @Test
    void large() {
        assertEquals(28, binaryGap2.solution(1610612737));
    }


}
