package com.gildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GildedRoseTest {

    private static final int QUALITY = 80;
    private static final int LOWEST_QUALITY = 0;

    private static final int SELL_IN = 1;

    @Test
    public void conjured_quality_degrades_by_one_before_sell_in() {
        Item[] items = new Item[] { new Item("Conjured", SELL_IN, QUALITY) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(QUALITY - 2, app.items[0].quality);
    }

    @Test
    public void conjured_quality_degrades_by_two_after_sell_in() {
        Item[] items = new Item[] { new Item("Conjured", 0, QUALITY) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(QUALITY - 4, app.items[0].quality);
    }

    @Test
    public void conjured_quality_never_goes_below_0() {
        Item[] items = new Item[] { new Item("Conjured", 0, LOWEST_QUALITY) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(LOWEST_QUALITY, app.items[0].quality);
    }

    @Test
    public void conjured_sell_in_goes_down_of_1_after_update() {
        Item[] items = new Item[] { new Item("Conjured", SELL_IN, QUALITY) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(SELL_IN - 1, app.items[0].sellIn);
    }

    @Test
    public void sulfuras_quality_is_always_80() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", SELL_IN, QUALITY) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(QUALITY, app.items[0].quality);
    }

    @Test
    public void sulfuras_sell_in_never_decreases() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", SELL_IN, QUALITY) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(SELL_IN, app.items[0].sellIn);
    }

    @Test
    public void aged_brie_quality_icreases_by_one_before_sell_in() throws Exception {
        Item[] items = new Item[] { new Item("Aged Brie", SELL_IN, 49) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void aged_brie_quality_icreases_by_two_after_sell_in() throws Exception {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 48) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void aged_brie_maximum_quality_is_50() throws Exception {
        Item[] items = new Item[] { new Item("Aged Brie", SELL_IN, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void aged_brie_sell_in_goes_down_of_1_after_update() throws Exception {
        Item[] items = new Item[] { new Item("Aged Brie", SELL_IN, 49) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(SELL_IN - 1, app.items[0].sellIn);
    }
}
