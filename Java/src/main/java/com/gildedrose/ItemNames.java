package com.gildedrose;

import java.util.Objects;

public enum ItemNames {
    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASS("Backstage passes"),
    SULFURAS("Sulfuras"),
    CONJURED("Conjured");


    private final String text;

    ItemNames(String name) {
        this.text = name;
    }

    public static boolean isAgedBrie(Item item) {
        return Objects.equals(item.name, AGED_BRIE.text());
    }

    public static boolean isSulfuras(Item item) {
        return item.name.startsWith(SULFURAS.text());
    }

    public static boolean isBackStagePass(Item item) {
        return item.name.startsWith(BACKSTAGE_PASS.text());
    }

    public static boolean isConjured(Item item) {
        return item.name.startsWith(CONJURED.text());
    }

    public String text() {
        return text;
    }
}
