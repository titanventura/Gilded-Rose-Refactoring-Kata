package com.gildedrose.strategy;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NegativeQualityUpdateStrategyTest {
    @Test
    void shouldDecreaseTheQualityByOneWhenItemIsNotPastSellInDate() {
        ItemUpdateStrategy strategy = new NegativeQualityUpdateStrategy(1);
        Item item = new Item("test item", 20, 20);

        strategy.applyOn(item);

        assertEquals(19, item.quality);
    }

    @Test
    void shouldDecreaseTheQualityByTwoWhenItemIsPastSellInDate() {
        ItemUpdateStrategy strategy = new NegativeQualityUpdateStrategy(1);
        Item item = new Item("test item", -1, 20);

        strategy.applyOn(item);

        assertEquals(18, item.quality);
    }

    @Test
    void shouldNotDecreaseTheQualityOfTheItemBeyondZero() {
        ItemUpdateStrategy strategy = new NegativeQualityUpdateStrategy(1);
        Item item = new Item("test item", -1, 0);

        strategy.applyOn(item);

        assertEquals(0, item.quality);
    }

    @Test
    void shouldDecreaseTheQualityOfTheItemBy2WhenRateIs2() {
        ItemUpdateStrategy strategy = new NegativeQualityUpdateStrategy(2);
        Item item = new Item("test item", 5, 10);

        strategy.applyOn(item);

        assertEquals(8, item.quality);
    }

    @Test
    void shouldNotDecreaseTheQualityOfTheItemBeyondZeroIfQualityIsLessThanRate() {
        ItemUpdateStrategy strategy = new NegativeQualityUpdateStrategy(4);
        Item item = new Item("test item", 5, 2);

        strategy.applyOn(item);

        assertEquals(0, item.quality);
    }
}
