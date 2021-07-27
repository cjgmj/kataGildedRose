package com.gildedrose;

public abstract class ShopItem extends Item {

	protected static final int MIN_QUALITY = 0;

	protected static final int MAX_QUALITY = 50;

	protected final static int DEFAULT_QUALITY_CHANGE = 1;

	protected final static int DEFAULT_QUALITY_CHANGE_AFTER_SELL_DATE = 2;

	private Item item;

	public ShopItem(Item item) {
		super(item.name, item.sellIn, item.quality);

		this.item = item;
	}

	public abstract void update();

	protected boolean isAfterSellDate() {
		return sellIn < 0;
	}

}
