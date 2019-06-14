import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HourGlassTest {

    @Test
    void hourglassSum() {
        int[][] twoDArray = new int[][]{
                { 1, 1, 1, 0, 0, 0},
                { 0, 1, 0, 0, 0, 0},
                { 1, 1, 1, 0, 0, 0},
                { 0, 0, 2, 4, 4, 0},
                { 0, 0, 0, 2, 0, 0},
                { 0, 0, 1, 2, 4, 0}
        };
        assertEquals(19, HourGlass.hourglassSum(twoDArray));
    }

    @Test
    void sumOfHourGlassSums() {
        List<Integer> hourGlassSums = new ArrayList<>();
        hourGlassSums.add(1);
        hourGlassSums.add(-1);
        hourGlassSums.add(999);
        hourGlassSums.add(-99);
        assertEquals(999, HourGlass.maxOfHourGlassSums(hourGlassSums));
    }

    @Test
    void sumOneHourGlass() {
        int[][] twoDArray = new int[][]{
                { 1, 1, 1, 0, 0, 0},
                { 0, 1, 0, 0, 0, 0},
                { 1, 1, 1, 0, 0, 0},
                { 0, 0, 2, 4, 4, 0},
                { 0, 0, 0, 2, 0, 0},
                { 0, 0, 1, 2, 4, 0}
        };

        assertEquals(7, HourGlass.sumOneHourGlass(0, 0 , twoDArray));
        assertEquals(19, HourGlass.sumOneHourGlass(3, 2 , twoDArray));
    }


}
