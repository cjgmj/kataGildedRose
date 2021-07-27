package com.gildedrose;

public final class Conjured extends ShopItem {

	private static final int CONJURED_QUALITY_DEGRADE = 2;

	public Conjured(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void update() {
		this.decreaseSellIn();

		if (this.isQualityUpdatable()) {
			this.quality -= (this.isAfterSellDate() ? DEFAULT_QUALITY_CHANGE_AFTER_SELL_DATE : DEFAULT_QUALITY_CHANGE)
					* CONJURED_QUALITY_DEGRADE;
			this.checkQualityLessThanMin();
		}
	}

}
