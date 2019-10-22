import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MakingAnagramsTest {

    @Test
    void simpleAnagram1() {
        int deletions = 4;
        String string1 = "cde";
        String string2 = "abc";
        assertEquals(deletions, MakingAnagrams.makeAnagram(string1, string2));
    }

    @Test
    void simpleAnagram11() {
        int deletions = 19;
        String string1 = "absdjkvuahdakejfnfauhdsaavasdlkj";
        String string2 = "djfladfhiawasdkjvalskufhafablsdkashlahdfa";
        assertEquals(deletions, MakingAnagrams.makeAnagram(string1, string2));
    }


    @Test
    void simpleAnagram111() {
        int deletions = 4;
        String string1 = "aaabcd";
        String string2 = "abbbcd";
        assertEquals(deletions, MakingAnagrams.makeAnagram(string1, string2));
    }


    @Test
    void simpleAnagram2() {
        int deletions = 30;
        String string1 = "fcrxzwscanmligyxyvym";
        String string2 = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        assertEquals(deletions, MakingAnagrams.makeAnagram(string1, string2));
    }

    @Test
    void simpleAnagram3() {
        int deletions = 6;
        String string1 = "aabab";
        String string2 = "baaaeaaae";
        assertEquals(deletions, MakingAnagrams.makeAnagram(string1, string2));
    }

    @Test
    void firstStringBigger() {
        int deletions = 5;
        String string1 = "ef";
        String string2 = "abcde";
        assertEquals(deletions, MakingAnagrams.makeAnagram(string1, string2));
    }

    @Test
    void secondStringBigger() {
        int deletions = 5;
        String string1 = "abcde";
        String string2 = "ef";
        assertEquals(deletions, MakingAnagrams.makeAnagram(string1, string2));
    }

    @Test
    void boundary1() {
        int deletions = 0;
        String string1 = "a";
        String string2 = "a";
        assertEquals(deletions, MakingAnagrams.makeAnagram(string1, string2));
    }

    @Test
    void boundary2() {
        int deletions = 0;
        String string1 = "a";
        String string2 = "b";
        assertEquals(deletions, MakingAnagrams.makeAnagram(string1, string2));
    }

}
