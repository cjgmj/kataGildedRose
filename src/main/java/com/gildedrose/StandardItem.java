package com.gildedrose;

public final class StandardItem extends ShopItem {

	public StandardItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void update() {
		this.decreaseSellIn();

		if (this.isQualityUpdatable()) {
			this.quality -= this.getDefaultQualityChangeBySellDate();
			this.checkQualityLessThanMin();
		}
	}

}
