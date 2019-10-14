import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class CyclicRotationTest {

    private CyclicRotation cyclicRotation;

    @BeforeEach
    void beforeEach(){
        cyclicRotation = new CyclicRotation();
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

//    cater for N or K to be 0/1

}
