package com.gildedrose.strategy;

import com.gildedrose.Item;

public class BackstagePassQualityUpdateStrategy implements ItemUpdateStrategy {


    AgedBrieQualityUpdateStrategy strategy = new AgedBrieQualityUpdateStrategy();

    @Override
    public void applyOn(Item item) {
        if (hasExpired(item)) {
            item.quality = 0;
            return;
        }

        strategy.increaseQuality(item);

        if (item.sellIn <= 10)
            strategy.increaseQuality(item);

        if (item.sellIn <= 5)
            strategy.increaseQuality(item);
    }
}
