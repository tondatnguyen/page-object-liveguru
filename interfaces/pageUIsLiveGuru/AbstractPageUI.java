package pageUIsLiveGuru;

public class AbstractPageUI {
	// ---------------------------- LIVEGURU project ----------------------------

	// dynamic page elements
	public static final String DYNAMIC_ACCOUNT_MENU_LINK = "//header//a[contains(text(),'%s')]";
	public static final String DYNAMIC_MY_ACCOUNT_MENU_LINK = "//a[text()='%s']";
	public static final String DYNAMIC_PRODUCT_MENU_LINK = "//a[text()='%s']";
	
	public static final String DYNAMIC_LINK_OR_BUTTON = "//button[@title='%s']";
	public static final String DYNAMIC_RADIO_BUTTON = "//input[@id='%s']";
	public static final String DYNAMIC_TEXTBOX = "//input[@id='%s']";
	public static final String DYNAMIC_TEXTAREA = "//textarea[@id='%s']";
	public static final String SUCCESS_MESSAGE = "//li[@class='success-msg']//span";
	public static final String DYNAMIC_TEXTBOX_ERROR_MESSAGE = "//input[@id='%s']/following-sibling::div[@class='validation-advice']";
	public static final String DYNAMIC_TEXTAREA_ERROR_MESSAGE = "//textarea[@id='%s']/following-sibling::div[@class='validation-advice']";
	public static final String DYNAMIC_PRODUCT_SPECIAL_PRICE = "//a[text()='%s']/parent::h2/following-sibling::div[@class='price-box']/p[@class='special-price']//span[@class='price']";
	public static final String DYNAMIC_PRODUCT_REGULAR_PRICE = "//a[text()='%s']/parent::h2/following-sibling::div[@class='price-box']/span[@class='regular-price']/span";
	public static final String DYNAMIC_IMAGE = "//img[contains(@src,'%s')]";
	
	// Account menu >> clickOnAccountMenu
	public static final String ACCOUNT_MENU = "//span[@class='label' and text()='Account']";
	
	// Advanced_search link
	public static final String ADVANCED_SEARCH_LINK = "//a[text()='Advanced Search']";
}
