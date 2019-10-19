import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CyclicRotationTest {

    private CyclicRotation cyclicRotation;

    @BeforeEach
    void beforeEach(){
        cyclicRotation = new CyclicRotation();
    }

    @Test
    void rotate0(){
        int[] rotated = cyclicRotation.rotate(new int[]{3, 8, 9, 7, 6}, 1);
        assertArrayEquals(new int[]{6, 3, 8, 9, 7}, rotated);
    }

    @Test
    void rotate1(){
        int[] rotated = cyclicRotation.rotate(new int[]{3, 8, 9, 7, 6}, 3);
        assertArrayEquals(new int[]{9, 7, 6, 3, 8}, rotated);
    }

    @Test
    void rotate2(){
        int[] rotated = cyclicRotation.rotate(new int[]{3, 8, 9, 7, 6}, 5);
        assertArrayEquals(new int[]{3, 8, 9, 7, 6}, rotated);
    }

    @Test
    void rotate3(){
        int[] rotated = cyclicRotation.rotate(new int[]{3, 8, 9, 7, 6}, 50);
        assertArrayEquals(new int[]{3, 8, 9, 7, 6}, rotated);
    }

    @Test
    void rotate4(){
        int[] rotated = cyclicRotation.rotate(new int[]{3, 8, 9, 7, 6}, 5);
        assertArrayEquals(new int[]{3, 8, 9, 7, 6}, rotated);
    }

    @Test
    void rotate5(){
        int[] rotated = cyclicRotation.rotate(new int[]{1, 2, 3, 5, 1}, 2);
        assertEquals(5, rotated.length);
        assertArrayEquals(new int[]{5, 1, 1, 2, 3}, rotated);
    }

    @Test
    void rotateZeroTimes(){
        int[] rotated = cyclicRotation.rotate(new int[]{3, 8, 9, 7, 6}, 0);
        assertArrayEquals(new int[]{3, 8, 9, 7, 6}, rotated);
    }

    @Test
    void emptyArray(){
        int[] rotated = cyclicRotation.rotate(new int[]{}, 1);
        assertArrayEquals(new int[]{}, rotated);
    }

}
