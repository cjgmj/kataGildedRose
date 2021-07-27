package com.gildedrose;

public final class StandardItem extends ShopItem {

	public StandardItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void update() {
		this.decreaseSellIn();

		if (this.isQualityUpdatable()) {
			this.quality -= (this.isAfterSellDate() ? DEFAULT_QUALITY_CHANGE_AFTER_SELL_DATE : DEFAULT_QUALITY_CHANGE);
			this.checkQualityLessThanMin();
		}
	}

}
