package pageUIsLiveGuru;

public class DetailPageUI {
	
	public static final String DETAIL_PRODUCT_PAGE_TITLE = "//span[@class='h1']";
	public static final String DYNAMIC_DETAIL_PRODUCT_SPECIAL_PRICE = "//span[text()='%s']/parent::div/following-sibling::div[@class='price-info']//p[@class='special-price']//span[@class='price']";
	public static final String DYNAMIC_DETAIL_PRODUCT_REGULAR_PRICE = "//span[text()='%s']/parent::div/following-sibling::div[@class='price-info']//span[@class='regular-price']/span";
	public static final String ADD_YOUR_REVIEW_LINK = "//a[text()='Add Your Review']";

}
