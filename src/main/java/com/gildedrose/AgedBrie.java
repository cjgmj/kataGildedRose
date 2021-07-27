package com.gildedrose;

public final class AgedBrie extends ShopItem {

	public AgedBrie(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void update() {
		this.decreaseSellIn();

		if (this.isQualityUpdatable()) {
			this.quality += this.getDefaultQualityChangeBySellDate();
			this.checkQualityGreaterThanMax();
		}
	}

}
