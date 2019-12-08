package pageUIsLiveGuru;

public class DetailPageUI {
	
	public static final String DETAIL_PRODUCT_PAGE_TITLE = "//span[@class='h1']";
	public static final String DYNAMIC_DETAIL_PRODUCT_SPECIAL_PRICE = "//span[text()='%s']/parent::div/following-sibling::div[@class='price-info']//p[@class='special-price']//span[@class='price']";
	public static final String DYNAMIC_DETAIL_PRODUCT_REGULAR_PRICE = "//span[text()='%s']/parent::div/following-sibling::div[@class='price-info']//span[@class='regular-price']/span";
	public static final String ADD_YOUR_REVIEW_LINK = "//a[text()='Add Your Review']";
	public static final String MORE_VIEWS = "//h2[text()='More Views']";
	public static final String REVIEWS_TAB = "//ul[@class='toggle-tabs']//span[text()='Reviews']";
	public static final String SUMMARY = "//div[@id='customer-reviews']//dt[1]";
	public static final String REVIEW_MESSAGE = "//div[@id='customer-reviews']//dd[1]";
	public static final String NICKNAME = "//div[@id='customer-reviews']//dd[1]/span";
}
