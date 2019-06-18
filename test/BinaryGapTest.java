import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryGapTest {

    @Test
    void binary1() {
        assertEquals("1000010001", BinaryGap.toBinary(529));

    }
    @Test
    void binary2() {
        assertEquals("10000010001", BinaryGap.toBinary(1041));
    }
    @Test
    void binary3() {
        assertEquals("1111", BinaryGap.toBinary(15));
    }
    @Test
    void binary4() {
        assertEquals("10100", BinaryGap.toBinary(20));
    }
    @Test
    void binary5() {
        assertEquals("100000", BinaryGap.toBinary(32));
    }

    @Test
    void count1(){
        assertEquals(4, BinaryGap.solution(529));
    }

    @Test
    void count2(){
        assertEquals(0, BinaryGap.solution(15));
    }

    @Test
    void count3(){
        assertEquals(1, BinaryGap.solution(20));
    }

    @Test
    void count4(){
        assertEquals(0, BinaryGap.solution(32));
    }

//    largeRun(){
//
//    }

    //todo: add more tests to test performance


}
