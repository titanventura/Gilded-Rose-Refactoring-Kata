package com.gildedrose.strategy;

import com.gildedrose.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NegativeSellInUpdateStrategyTest {
    @Test
    void shouldDecreaseSellInByOneWhenExecuteIsCalled() {
        ItemUpdateStrategy strategy = new NegativeSellInUpdateStrategy();
        Item item = new Item("test", 10, 10);

        strategy.applyOn(item);

        Assertions.assertEquals(9, item.sellIn);
    }
}
