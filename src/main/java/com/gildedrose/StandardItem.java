package com.gildedrose;

public final class StandardItem extends ShopItem {

	public StandardItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void update() {
		if (this.quality > MIN_QUALITY) {
			int updatedQuality = this.quality
					- (this.isAfterSellDate() ? DEFAULT_QUALITY_CHANGE_AFTER_SELL_DATE : DEFAULT_QUALITY_CHANGE);
			this.quality = updatedQuality < MIN_QUALITY ? MIN_QUALITY : updatedQuality;
		}
	}

}
