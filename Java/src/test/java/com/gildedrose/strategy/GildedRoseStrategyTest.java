package com.gildedrose.strategy;

import com.gildedrose.Item;
import com.gildedrose.ItemNames;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GildedRoseStrategyTest {
    @Test
    void shouldDecreaseSellInAndQualityBy1WhenNormalItemHasQualityAndIsNotExpired() {
        ItemUpdateStrategy strategy = new GildedRoseStrategy();
        Item item = new Item("Normal", 10, 10);

        strategy.applyOn(item);

        Assertions.assertEquals(9, item.sellIn);
        Assertions.assertEquals(9, item.quality);
    }

    @Test
    void shouldDecreaseQualityBy2AndSellInBy1WhenItemIsNormalAndExpired() {
        ItemUpdateStrategy strategy = new GildedRoseStrategy();
        Item item = new Item("Normal", -1, 10);

        strategy.applyOn(item);

        Assertions.assertEquals(-2, item.sellIn);
        Assertions.assertEquals(8, item.quality);
    }

    @Test
    void shouldIncreaseQualityWhenItemIsAgedBrie() {
        ItemUpdateStrategy strategy = new GildedRoseStrategy();
        Item item = new Item("Aged Brie", 10, 10);

        strategy.applyOn(item);

        Assertions.assertEquals(9, item.sellIn);
        Assertions.assertEquals(11, item.quality);
    }

    @Test
    void shouldNotAlterTheQualityOrSellInWhenItemIsSulfuras() {
        ItemUpdateStrategy strategy = new GildedRoseStrategy();
        Item item = new Item("Sulfuras, the perfect additive for your toothpaste", 10, 80);

        strategy.applyOn(item);

        Assertions.assertEquals(10, item.sellIn);
        Assertions.assertEquals(80, item.quality);
    }

    @Test
    void shouldIncreaseQualityWhenItemIsBackstagePass() {
        ItemUpdateStrategy strategy = new GildedRoseStrategy();
        Item item = new Item("Backstage passes to the northern hemisphere", 11, 30);

        strategy.applyOn(item);

        Assertions.assertEquals(10, item.sellIn);
        Assertions.assertEquals(31, item.quality);
    }

    @Test
    void shouldIncreaseQualityByTwoWhenItemIsBackStagePassAndUnderTenOrLessDaysOfSellIn() {
        ItemUpdateStrategy strategy = new GildedRoseStrategy();
        Item item = new Item("Backstage passes to the northern hemisphere", 10, 30);

        strategy.applyOn(item);

        Assertions.assertEquals(9, item.sellIn);
        Assertions.assertEquals(32, item.quality);
    }

    @Test
    void shouldIncreaseQualityByThreeWhenItemIsBackStagePassAndUnderFiveOrLessDaysOfSellIn() {
        ItemUpdateStrategy strategy = new GildedRoseStrategy();
        Item item = new Item("Backstage passes to the northern hemisphere", 5, 30);

        strategy.applyOn(item);

        Assertions.assertEquals(4, item.sellIn);
        Assertions.assertEquals(33, item.quality);
    }

    @Test
    void shouldDropTheQualityToZeroWhenItemIsBackStagePassAndIsExpired() {
        ItemUpdateStrategy strategy = new GildedRoseStrategy();
        Item item = new Item("Backstage passes to the northern hemisphere", 0, 30);

        strategy.applyOn(item);

        Assertions.assertEquals(-1, item.sellIn);
        Assertions.assertEquals(0, item.quality);
    }

    @Test
    void shouldDecreaseQualityBy2WhenItemIsConjuredButNotExpired() {
        ItemUpdateStrategy strategy = new GildedRoseStrategy();
        Item item = new Item("Conjured Duck", 10, 30);

        strategy.applyOn(item);

        Assertions.assertEquals(9, item.sellIn);
        Assertions.assertEquals(28, item.quality);
    }

    @Test
    void shouldDecreaseQualityBy4WhenItemIsConjuredAndExpired() {
        ItemUpdateStrategy strategy = new GildedRoseStrategy();
        Item item = new Item("Conjured Duck", 0, 30);

        strategy.applyOn(item);

        Assertions.assertEquals(-1, item.sellIn);
        Assertions.assertEquals(26, item.quality);
    }
}
