package com.gildedrose.strategy;

import com.gildedrose.Item;

public interface ItemUpdateStrategy {

    default boolean hasExpired(Item item) {
        return item.sellIn <= 0;
    }

    void applyOn(Item item);
}
