package com.gildedrose.strategy;

import com.gildedrose.Item;

public class NegativeSellInUpdateStrategy implements ItemUpdateStrategy {
    @Override
    public void applyOn(Item item) {
        decreaseSellIn(item);
    }

    private void decreaseSellIn(Item item) {
        item.sellIn -= 1;
    }
}
