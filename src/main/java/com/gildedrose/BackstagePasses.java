package com.gildedrose;

public final class BackstagePasses extends ShopItem {

	private final static int FIVE_DAYS_THRESHOLD = 5;
	private final static int QUALITY_UPGRADE_FIVE_DAYS_THRESHOLD = 3;

	private final static int TEN_DAYS_THRESHOLD = 10;
	private final static int QUALITY_UPGRADE_TEN_DAYS_THRESHOLD = 2;

	public BackstagePasses(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void update() {
		if (this.quality < MAX_QUALITY) {
			if (this.isAfterSellDate()) {
				this.quality = MIN_QUALITY;
			} else {
				int updatedQuality = this.quality + this.getQualityUpgradeBySellIn();
				this.quality = updatedQuality > MAX_QUALITY ? MAX_QUALITY : updatedQuality;
			}
		}
	}

	private int getQualityUpgradeBySellIn() {
		if (sellIn <= FIVE_DAYS_THRESHOLD) {
			return QUALITY_UPGRADE_FIVE_DAYS_THRESHOLD;
		} else if (sellIn <= TEN_DAYS_THRESHOLD) {
			return QUALITY_UPGRADE_TEN_DAYS_THRESHOLD;
		} else {
			return DEFAULT_QUALITY_CHANGE;
		}
	}

}
