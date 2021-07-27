package com.gildedrose;

public abstract class ShopItem extends Item {

	protected static final int MIN_QUALITY = 0;

	protected static final int MAX_QUALITY = 50;

	protected final static int DEFAULT_QUALITY_CHANGE = 1;

	protected final static int DEFAULT_QUALITY_CHANGE_AFTER_SELL_DATE = 2;

	public ShopItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	public abstract void update();

	protected void decreaseSellIn() {
		this.sellIn -= 1;
	}

	protected boolean isAfterSellDate() {
		return sellIn < 0;
	}

	protected boolean isQualityUpdatable() {
		return this.quality > MIN_QUALITY && this.quality < MAX_QUALITY;
	}

	protected void checkQualityLessThanMin() {
		if (this.quality < MIN_QUALITY) {
			this.quality = MIN_QUALITY;
		}
	}

	protected void checkQualityGreaterThanMax() {
		if (this.quality > MAX_QUALITY) {
			this.quality = MAX_QUALITY;
		}
	}

}
