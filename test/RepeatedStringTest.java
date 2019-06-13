import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepeatedStringTest {

    @Test
    void testRepeatedString() {
        assertEquals(0, RepeatedStringWithStringBuilder.repeatedString("s", 3));
        assertEquals(7, RepeatedStringWithStringBuilder.repeatedString("aba", 10));
        assertEquals(2, RepeatedStringWithStringBuilder.repeatedString("a", 2));
        assertEquals(Long.valueOf(1000000L), RepeatedStringWithStringBuilder.repeatedString("a", 1000000L));
        assertEquals(Long.valueOf(100000000L), RepeatedStringWithStringBuilder.repeatedString("a", 100000000L));

//TODO: implement RepeatedStringWithPrimitives and uncomment
//        assertEquals(Long.valueOf(1000000000000L), RepeatedStringWithPrimitives.repeatedString("a", 1000000000000L));
    }
}
