import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArraysDSTest {

    @Test
    void basic() {
        int[] original = new int[]{1, 2, 3, 4};
        int[] reversed = new int[]{4, 3, 2, 1};
        assertArrayEquals(reversed, ArraysDS.reverseArray(original));
    }

}
