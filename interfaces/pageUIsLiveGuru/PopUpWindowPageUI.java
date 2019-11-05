package pageUIsLiveGuru;


public class PopUpWindowPageUI {
	
	public static final String POPUP_PAGE_TITLE = "//h1[contains(text(),'%s')]";
	public static final String DYNAMIC_PRODUCT_NAME = "//a[text()='%s']";
	public static final String DYNAMIC_PRODUCT_REGULAR_PRICE = "//a[text()='%s']/parent::h2/following-sibling::div[@class='price-box']//span[@class='regular-price']/span";
	public static final String DYNAMIC_PRODUCT_SPECIAL_PRICE = "//a[text()='%s']/parent::h2/following-sibling::div[@class='price-box']/p[@class='special-price']/span[@class='price']";
	public static final String SKU_CODE = "//div[contains(text(),'%s')]";

}
