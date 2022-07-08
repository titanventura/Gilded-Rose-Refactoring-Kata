package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemNamesTest {

    @Test
    void shouldCheckSulfuras() {
        Item item = new Item("Sulfuras, something something", 100, 80);

        boolean isSulfuras = ItemNames.isSulfuras(item);

        assertTrue(isSulfuras);
    }

    @Test
    void shouldCheckAgedBrie() {
        Item item = new Item("Aged Brie", 100, 80);

        boolean isAgedBrie = ItemNames.isAgedBrie(item);

        assertTrue(isAgedBrie);
    }

    @Test
    void shouldCheckBackstagePass() {
        Item item = new Item("Backstage passes to Ed-Sheeran's concert", 100, 80);

        boolean isAgedBrie = ItemNames.isBackStagePass(item);

        assertTrue(isAgedBrie);
    }

    @Test
    void shouldCheckConjuredItems() {
        Item item = new Item("Conjured shrimp", 20, 40);

        boolean isConjured = ItemNames.isConjured(item);

        assertTrue(isConjured);
    }
}
