package com.gildedrose.strategy;

import com.gildedrose.Item;

public class NegativeQualityUpdateStrategy implements ItemUpdateStrategy {

    private final int rate;

    public NegativeQualityUpdateStrategy(int rate) {
        this.rate = rate;
    }

    private boolean hasNoQuality(Item item) {
        return item.quality <= 0;
    }

    private void decreaseQuality(Item item) {
        if (hasNoQuality(item))
            return;

        item.quality -= Math.min(rate, item.quality);
    }

    @Override
    public void applyOn(Item item) {
        decreaseQuality(item);

        if (hasExpired(item))
            decreaseQuality(item);
    }
}
