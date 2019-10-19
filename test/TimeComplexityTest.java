import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeComplexityTest {

    private int jumpSize;
    private int end;
    private int start;
    private TimeComplexity timeComplexity;

    @BeforeEach
    void setUp() {
        timeComplexity = new TimeComplexity();
    }

    @Test
    void jumpBiggerThanEnd() {
        jumpSize=2;
        end = 1;
        start = 1;
        assertEquals(0, timeComplexity.solution(start, end, jumpSize));
    }

    @Test
    void startSameAsEnd() {
        jumpSize=2;
        end = 10;
        start = 10;
        assertEquals(0, timeComplexity.solution(start, end, jumpSize));
    }

    @Test
    void jumpSizeOfOne() {
        jumpSize=1;
        end = 10;
        start = 1;
        assertEquals(9, timeComplexity.solution(start, end, jumpSize));
    }

}
