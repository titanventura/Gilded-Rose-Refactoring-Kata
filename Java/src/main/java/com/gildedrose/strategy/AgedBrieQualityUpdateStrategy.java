package com.gildedrose.strategy;

import com.gildedrose.Item;

public class AgedBrieQualityUpdateStrategy implements ItemUpdateStrategy {

    public void increaseQuality(Item item) {
        final int MAX_ITEM_QUALITY = 50;

        if (item.quality < MAX_ITEM_QUALITY)
            item.quality += 1;
    }

    @Override
    public void applyOn(Item item) {
        increaseQuality(item);

        if (hasExpired(item))
            increaseQuality(item);
    }
}
