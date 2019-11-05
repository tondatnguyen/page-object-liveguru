package pageUIsLiveGuru;


public class ProductPageUI {
	public static final String PRODUCT_PAGE_TITLE = "//h1[text()='%s']";
	public static final String DYNAMIC_PRODUCT_NAME = "//h2[@class='product-name']//a[text()='%s']";
	public static final String DYNAMIC_PRODUCT_ADD_TO_CART_BUTTON = "//a[text()='%s']/parent::h2/following-sibling::div[@class='actions']/button";
	public static final String DYNAMIC_PRODUCT_ADD_TO_WISHLIST_LINK = "//a[text()='%s']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-wishlist']";
	public static final String DYNAMIC_PRODUCT_ADD_TO_COMPARE_LINK = "//a[text()='%s']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']";

}
