package com.gildedrose.strategy;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackstagePassQualityUpdateStrategyTest {
    @Test
    void shouldIncreaseQualityBy1WhenMoreThan10DaysOfSellIn() {
        ItemUpdateStrategy strategy = new BackstagePassQualityUpdateStrategy();
        Item item = new Item("Backstage Passes to the northern hemisphere", 11, 20);

        strategy.applyOn(item);

        assertEquals(21, item.quality);
    }

    @Test
    void shouldIncreaseQualityBy2When10OrLessDaysOfSellIn() {
        ItemUpdateStrategy strategy = new BackstagePassQualityUpdateStrategy();
        Item item = new Item("Backstage Passes to the nothern hemisphere", 10, 20);

        strategy.applyOn(item);

        assertEquals(22, item.quality);
    }

    @Test
    void shouldIncreaseQualityBy3When5OrLessDaysOfSellIn() {
        ItemUpdateStrategy strategy = new BackstagePassQualityUpdateStrategy();
        Item item = new Item("Backstage Passes to the nothern hemisphere", 5, 20);

        strategy.applyOn(item);

        assertEquals(23, item.quality);
    }

    @Test
    void shouldDropQualityToZeroWhenItemIsExpired() {
        ItemUpdateStrategy strategy = new BackstagePassQualityUpdateStrategy();
        Item item = new Item("Backstage Passes to the nothern hemisphere", 0, 20);

        strategy.applyOn(item);

        assertEquals(0, item.quality);
    }
}
