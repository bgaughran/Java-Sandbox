import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximiseProfitFromStocksTest {

    List<Integer> price;

    @BeforeEach
    void setUp(){
        price = new ArrayList<>();
    }

    @Test
    void findIndexOfHighestOccuringIntegerBeforeADipOccurs1(){
        price.add(5);
        price.add(3);
        price.add(2);
        MaximiseProfitFromStocksResult.prices = price;
        assertEquals(0, MaximiseProfitFromStocksResult.findIndexOfHighestOccuringIntegerBeforeADipOccurs(0));
    }

    @Test
    void findIndexOfHighestOccuringIntegerBeforeADipOccurs2(){
        price.add(2);
        price.add(3);
        price.add(4);
        MaximiseProfitFromStocksResult.prices = price;
        assertEquals(2, MaximiseProfitFromStocksResult.findIndexOfHighestOccuringIntegerBeforeADipOccurs(0));
    }

    @Test
    void findIndexOfHighestOccuringIntegerBeforeADipOccurs3(){
        price.add(2);
        price.add(3);
        price.add(2);
        MaximiseProfitFromStocksResult.prices = price;
        assertEquals(1, MaximiseProfitFromStocksResult.findIndexOfHighestOccuringIntegerBeforeADipOccurs(0));
    }

    @Test
    void findIndexOfHighestOccuringIntegerBeforeADipOccurs4(){
        price.add(2);
        price.add(3);
        price.add(2);
        price.add(40);
        price.add(4);
        MaximiseProfitFromStocksResult.prices = price;
        assertEquals(1, MaximiseProfitFromStocksResult.findIndexOfHighestOccuringIntegerBeforeADipOccurs(0));
    }

    @Test
    void calculateProfitForRange1(){
        price.add(2);
        price.add(3);
        price.add(2);
        price.add(40);
        price.add(4);
        MaximiseProfitFromStocksResult.prices = price;
        assertEquals(1, MaximiseProfitFromStocksResult.calculateProfitForRange(0, 1));
    }

    @Test
    void calculateProfitForRange2(){
        price.add(2);
        price.add(3);
        price.add(4);
        price.add(40);
        price.add(4);
        MaximiseProfitFromStocksResult.prices = price;
        assertEquals(111, MaximiseProfitFromStocksResult.calculateProfitForRange(0, 3));
    }

    @Test
    void calculateProfitForRange3(){
        price.add(2);
        price.add(3);
        price.add(4);
        price.add(40);
        price.add(4);
        MaximiseProfitFromStocksResult.prices = price;
        assertEquals(36, MaximiseProfitFromStocksResult.calculateProfitForRange(2, 3));
    }

    @Test
    void calculateProfitForRange4(){
        price.add(2);
        price.add(3);
        price.add(4);
        price.add(40);
        price.add(4);
        MaximiseProfitFromStocksResult.prices = price;
        assertEquals(0, MaximiseProfitFromStocksResult.calculateProfitForRange(3, 3));
    }

    @Test
    void maximumProfitSimple1(){
        price.add(5);
        price.add(3);
        price.add(2);
        assertEquals(0, MaximiseProfitFromStocksResult.maximumProfit(price));
    }

    @Test
    void maximumProfitSimple2(){
        price.add(1);
        price.add(2);
        price.add(100);
        assertEquals(197, MaximiseProfitFromStocksResult.maximumProfit(price));
    }

    @Test
    void maximumProfitSimple3(){
        price.add(1);
        price.add(2);
        price.add(100);
        price.add(1);
        assertEquals(197, MaximiseProfitFromStocksResult.maximumProfit(price));
    }

    @Test
    void maximumProfitSimple4(){
        price.add(1);
        price.add(3);
        price.add(1);
        price.add(2);
        assertEquals(3, MaximiseProfitFromStocksResult.maximumProfit(price));
    }

    @Test
    void maximumProfitSimple5(){
        price.add(3);
        price.add(4);
        price.add(5);
        price.add(3);
        price.add(5);
        price.add(2);
        assertEquals(5, MaximiseProfitFromStocksResult.maximumProfit(price));
    }

    @Test
    void onePrice(){
        price.add(2);
        assertEquals(0, MaximiseProfitFromStocksResult.maximumProfit(price));
    }

    @Test
    void twoPricesUpdwards(){
        price.add(2);
        price.add(3);
        assertEquals(1, MaximiseProfitFromStocksResult.maximumProfit(price));
    }

    @Test
    void twoPricesDownwards(){
        price.add(3);
        price.add(2);
        assertEquals(0, MaximiseProfitFromStocksResult.maximumProfit(price));
    }



}
