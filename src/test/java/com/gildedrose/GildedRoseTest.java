package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

	private ShopItem[] arrayWith(ShopItem item) {
		return new ShopItem[] { item };
	}

	@Test
	public void testThatSellInValueIsDecreased() {
		ShopItem whateverItem = new StandardItem("whatever", 10, 0);

		GildedRose gildedRose = new GildedRose();
		gildedRose.updateQuality(arrayWith(whateverItem));

		assertEquals(whateverItem.sellIn, 9);
	}

	@Test
	public void testThatQualityValueIsDecreased() {
		ShopItem whateverItem = new StandardItem("whatever", 1, 10);

		GildedRose gildedRose = new GildedRose();
		gildedRose.updateQuality(arrayWith(whateverItem));

		assertEquals(whateverItem.quality, 9);
	}

	@Test
	public void testThatQualityDecreasesTwiceAsMuchWhenSellByIsPassed() {
		ShopItem whateverItem = new StandardItem("whatever", 0, 10);

		GildedRose gildedRose = new GildedRose();
		gildedRose.updateQuality(arrayWith(whateverItem));

		assertEquals(whateverItem.quality, 8);
	}

	@Test
	public void testThatQualityIsNeverNegative() {
		ShopItem whateverItem = new StandardItem("whatever", 0, 0);

		GildedRose gildedRose = new GildedRose();
		gildedRose.updateQuality(arrayWith(whateverItem));

		assertEquals(whateverItem.quality, 0);
	}

	@Test
	public void testAgedBrieIncreasesQualityWithAge() {
		ShopItem agedBrie = new AgedBrie("Aged Brie", 5, 1);

		GildedRose gildedRose = new GildedRose();
		gildedRose.updateQuality(arrayWith(agedBrie));

		assertEquals(agedBrie.quality, 2);
	}

	@Test
	public void testQualityNeverIncreasesPastFifty() {
		ShopItem agedBrie = new AgedBrie("Aged Brie", 5, 50);

		GildedRose gildedRose = new GildedRose();
		gildedRose.updateQuality(arrayWith(agedBrie));

		assertEquals(agedBrie.quality, 50);
	}

	@Test
	public void testSulfurasNeverChanges() {
		ShopItem sulfuras = new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 25);

		GildedRose gildedRose = new GildedRose();
		gildedRose.updateQuality(arrayWith(sulfuras));

		assertEquals(sulfuras.quality, 25);
		assertEquals(sulfuras.sellIn, 0);
	}

	@Test
	public void testBackstagePassIncreasesQualityByOneIfSellByGreaterThenTen() {
		ShopItem backstagePasses = new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 11, 20);

		GildedRose gildedRose = new GildedRose();
		gildedRose.updateQuality(arrayWith(backstagePasses));

		assertEquals(backstagePasses.quality, 21);
	}

	@Test
	public void testBackstagePassIncreasesQualityByTwoIfSellBySmallerThanTen() {
		ShopItem backstagePasses = new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 6, 20);

		GildedRose gildedRose = new GildedRose();
		gildedRose.updateQuality(arrayWith(backstagePasses));

		assertEquals(backstagePasses.quality, 22);
	}

	@Test
	public void testBackstagePassIncreasesQualityByThreeIfSellBySmallerThanFive() {
		ShopItem backstagePasses = new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 5, 20);

		GildedRose gildedRose = new GildedRose();
		gildedRose.updateQuality(arrayWith(backstagePasses));

		assertEquals(backstagePasses.quality, 23);
	}

	@Test
	public void testBackstagePassLosesValueAfterSellByPasses() {
		ShopItem backstagePasses = new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 0, 20);

		GildedRose gildedRose = new GildedRose();
		gildedRose.updateQuality(arrayWith(backstagePasses));

		assertEquals(backstagePasses.quality, 0);
	}

}
