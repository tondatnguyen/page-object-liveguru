package pageUIsLiveGuru;

public class BackEndOrdersPageUI {
	
	public static final String PAGE_TITLE = "//h2[contains(text(),'%s')]";
	public static final String STATUS_DROPDOWN_LIST = "//select[@id='sales_order_grid_filter_status']";
	public static final String FIRST_ORDER_CHECKBOX = "//table[@id='sales_order_grid_table']/tbody/tr[1]//input";
	public static final String ACTIONS_DROPDOWN_LIST = "//select[@id='sales_order_grid_massaction-select']";
	public static final String ERROR_MESSAGE = "//li[@class='error-msg']//span";
	public static final String VIEW_DROPDOWN_LIST = "//select[@name='limit']";
	public static final String PAGINATION = "//table[@id='sales_order_grid_table']/tbody/tr";
	public static final String SELECT_LINK = "//a[text()='Select Visible']";
	public static final String UNSELECT_LINK = "//a[text()='Unselect Visible']";
	public static final String ALL_CHECKBOX = "//input[@class='massaction-checkbox']";
}
