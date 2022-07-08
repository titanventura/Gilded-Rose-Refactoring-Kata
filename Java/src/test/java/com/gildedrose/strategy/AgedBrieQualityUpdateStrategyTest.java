package com.gildedrose.strategy;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieQualityUpdateStrategyTest {
    @Test
    void shouldIncreaseQualityWhenItemIsNotPastSellInDate() {
        ItemUpdateStrategy strategy = new AgedBrieQualityUpdateStrategy();
        Item item = new Item("test", 10, 20);

        strategy.applyOn(item);

        assertEquals(21, item.quality);
    }

    @Test
    void shouldNotIncreaseQualityPast50() {
        ItemUpdateStrategy strategy = new AgedBrieQualityUpdateStrategy();
        Item item = new Item("test", 10, 50);

        strategy.applyOn(item);

        assertEquals(50, item.quality);
    }

    @Test
    void shouldIncreaseQualityBy2WhenItemHasExpired() {
        ItemUpdateStrategy strategy = new AgedBrieQualityUpdateStrategy();
        Item item = new Item("test", 0, 20);

        strategy.applyOn(item);

        assertEquals(22, item.quality);
    }
}
