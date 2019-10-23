import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SuperReducedStringTest {


    @Test
    void simple1(){
        String theString = "aabc";
        assertEquals("bc", SuperReducedString.superReducedString(theString));
    }

    @Test
    void simple2(){
        String theString = "bcaa";
        assertEquals("bc", SuperReducedString.superReducedString(theString));
    }

    @Test
    void simple3(){
        String theString = "abbcde";
        assertEquals("acde", SuperReducedString.superReducedString(theString));
    }

    @Test
    void complex1(){
        String theString = "aaabccddd";
        assertEquals("abd", SuperReducedString.superReducedString(theString));
    }

    @Test
    void emptyString(){
        String theString = "baab";
        assertEquals("Empty String", SuperReducedString.superReducedString(theString));
    }

    @Test
    void foundMatchAtIndexTrue(){
        SuperReducedString.reducedString =  new StringBuffer("abbcde");
        assertTrue(SuperReducedString.foundMatchAtIndex(1));
    }

    @Test
    void foundMatchAtIndexFalse(){
        SuperReducedString.reducedString =  new StringBuffer("abbcde");
        assertFalse(SuperReducedString.foundMatchAtIndex(4));
    }

    @Test
    void foundMatchAtIndexBoundary(){
        SuperReducedString.reducedString =  new StringBuffer("abbcde");
        Assertions.assertThrows(StringIndexOutOfBoundsException.class, () -> SuperReducedString.foundMatchAtIndex(5));
    }

    @Test
    void removeFirstTwoCharactersFromIndex(){
        SuperReducedString.reducedString =  new StringBuffer("abbcde");
        SuperReducedString.removeFirstTwoCharactersFromIndex(0);
        assertEquals("bcde", SuperReducedString.reducedString.toString());
    }

    //TODO: test Empty String return type
}
