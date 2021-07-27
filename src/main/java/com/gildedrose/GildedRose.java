package com.gildedrose;

import java.util.Arrays;

class GildedRose {

	public void updateQuality(ShopItem[] items) {
		Arrays.asList(items).forEach(ShopItem::update);
	}
}