import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SparseArraysTest {

    @Test
    void simpleMatch1(){
        String[] strings = new String[]{"def","de","fgh"};
        String[] queries = new String[]{"de","lmn","fgh"};
        int[] expected = new int[]{1,0,1};
        assertArrayEquals(expected, SparseArrays.matchingStrings(strings,  queries));
    }

    @Test
    void simpleMatch2(){
        String[] strings = new String[]{"aba","baba","aba","xzxb"};
        String[] queries = new String[]{"aba","xzxb","ab"};
        int[] expected = new int[]{2,1,0};
        assertArrayEquals(expected, SparseArrays.matchingStrings(strings,  queries));
    }

}
