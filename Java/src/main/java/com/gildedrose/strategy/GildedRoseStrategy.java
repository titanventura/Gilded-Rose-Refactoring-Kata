package com.gildedrose.strategy;

import com.gildedrose.Item;
import com.gildedrose.ItemNames;

public class GildedRoseStrategy implements ItemUpdateStrategy {

    @Override
    public void applyOn(Item item) {
        if (ItemNames.isSulfuras(item))
            return;

        ItemUpdateStrategy qualityUpdateStrategy;

        if (ItemNames.isAgedBrie(item)) {
            qualityUpdateStrategy = new AgedBrieQualityUpdateStrategy();
        } else if (ItemNames.isBackStagePass(item)) {
            qualityUpdateStrategy = new BackstagePassQualityUpdateStrategy();
        } else if (ItemNames.isConjured(item)) {
            qualityUpdateStrategy = new NegativeQualityUpdateStrategy(2);
        } else {
            qualityUpdateStrategy = new NegativeQualityUpdateStrategy(1);
        }

        qualityUpdateStrategy.applyOn(item);

        ItemUpdateStrategy sellInUpdateStrategy = new NegativeSellInUpdateStrategy();
        sellInUpdateStrategy.applyOn(item);
    }
}
