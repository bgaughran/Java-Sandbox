import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumSwapsTest {

    @Test
    void minimumSwaps() {
        int[] data = new int[]{ 1, 3, 5, 2, 4, 6, 7};
        assertEquals(3, MinimumSwaps.minimumSwaps(data));

    }


}
