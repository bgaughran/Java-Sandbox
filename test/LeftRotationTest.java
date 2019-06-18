import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeftRotationTest {

    @Test
    void hourglassSum() {
        int[] before = new int[]{ 1, 2, 3, 4, 5};
        int[] after = new int[]{ 5, 1, 2, 3, 4};
        assertArrayEquals(after, LeftRotation.rotateLeft(before, 4));

        before = new int[]{ 1};
        after = new int[]{ 1};
        assertArrayEquals(after, LeftRotation.rotateLeft(before, 1));
    }

    //todo: add more tests to test performance


}
