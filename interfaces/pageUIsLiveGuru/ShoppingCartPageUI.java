package pageUIsLiveGuru;


public class ShoppingCartPageUI {
	
	public static final String SHOPPING_CART_PAGE_TITLE = "//h1[contains(text(),'%s')]";
	public static final String QTY_TEXTBOX = "//a[text()='%s']//ancestor::td[@class='product-cart-info']//following-sibling::td[@class='product-cart-actions']/input";
	public static final String QTY_UPDATE_BUTTON = "//a[text()='%s']//ancestor::td[@class='product-cart-info']//following-sibling::td[@class='product-cart-actions']/button";
	public static final String ERROR_MAX_500_QUANTITY_MESSAGE = "//p[contains(text(),'%s')]";
	public static final String IFRAME = "//iframe[contains(@id,'%s')]";
	public static final String IFRAME_CLOSE_BUTTON = "//div[@id='closeBtn']";
	public static final String EMPTY_CART_MESSAGE = "//h1[text()='%s']";
	public static final String NO_ITEM_MESSAGE = "//div[@class='cart-empty']/p[text()='%s']";
	public static final String DISCOUNT_GURU50_TEXT = "//td[contains(text(),'%s')]";
	public static final String DISCOUNT_GURU50_PRICE = "//td[contains(text(),'Discount')]/following-sibling::td/span";
	public static final String DROPDOWN_LIST = "//select[@id='%s']";
	public static final String SHIPPING_COST = "//dt[contains(text(),'Flat Rate')]/following-sibling::dd//span[@class='price']";
	public static final String GRAND_TOTAL_TEXT = "//strong[text()='%s']";
	public static final String GRAND_TOTAL_PRICE = "//strong[text()='Grand Total']/parent::td/following-sibling::td//span";
	public static final String PROCEED_TO_CHECKOUT_BUTTON = "//div[@class='cart-totals']//button[@title='Proceed to Checkout']";
	
}
