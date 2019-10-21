import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompareTheTripletsTest {

    private List<Integer> a;
    private List<Integer> b;
    private List<Integer> expected;
    private List<Integer> actual;

    @BeforeEach
    void setUp() {
        a = new ArrayList<>();
        b = new ArrayList<>();
        expected = new ArrayList<>();
        actual = new ArrayList<>();
    }

    @Test
    void simpleTest1() {
        a.add(5);
        a.add(6);
        a.add(7);
        b.add(3);
        b.add(6);
        b.add(10);

        expected.add(1);
        expected.add(1);

        actual = CompareTheTriplets.compareTriplets(a, b);

        assertEquals(expected, actual);
    }

    @Test
    void simpleTest2() {
        a.add(17);
        a.add(28);
        a.add(30);

        b.add(99);
        b.add(16);
        b.add(8);

        expected.add(2);
        expected.add(1);

        actual = CompareTheTriplets.compareTriplets(a, b);

        assertEquals(expected, actual);
    }
    @Test
    void noScore() {
        a.add(17);
        a.add(28);
        a.add(30);

        b.add(17);
        b.add(28);
        b.add(30);

        expected.add(0);
        expected.add(0);

        actual = CompareTheTriplets.compareTriplets(a, b);

        assertEquals(expected, actual);
    }

}
