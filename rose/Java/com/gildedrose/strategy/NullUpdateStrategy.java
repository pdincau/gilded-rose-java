package com.gildedrose.strategy;

import com.gildedrose.Item;

public class NullUpdateStrategy extends ItemUpdateStrategy {

    @Override
    public void update(Item item) {
    }

    @Override
    protected void decreaseSellIn(Item item) {
    }

    @Override
    protected void updateQuality(Item item) {
    }

}
