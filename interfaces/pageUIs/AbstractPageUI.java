package pageUIs;

public class AbstractPageUI {
	// ---------------------------- BANKGURU project ----------------------------
	// 14 pages UI
	public static final String HOME_PAGE_LINK = "//a[text()='Manager']";
	public static final String NEW_CUSTOMER_LINK = "//a[text()='New Customer']";
	public static final String EDIT_CUSTOMER_LINK = "//a[text()='Edit Customer']";
	public static final String DELETE_CUSTOMER_LINK = "//a[text()='Delete Customer']";
	public static final String NEW_ACCOUNT_LINK = "//a[text()='New Account']";
	public static final String EDIT_ACCOUNT_LINK = "//a[text()='Edit Account']";
	public static final String DELETE_ACCOUNT_LINK = "//a[text()='Delete Account']";
	public static final String DEPOSIT_LINK = "//a[text()='Deposit']";
	public static final String WITHDRAWAL_LINK = "//a[text()='Withdrawal']";
	public static final String FUND_TRANSFER_LINK = "//a[text()='Fund Transfer']";
	public static final String CHANGE_PASSWORD_LINK = "//a[text()='Change Password']";
	public static final String BALANCE_ENQUIRY_LINK = "//a[text()='Balance Enquiry']";
	public static final String MINI_STATEMENT_LINK = "//a[text()='Mini Statement']";
	public static final String CUSTOMISED_STATEMENT_LINK = "//a[text()='Customised Statement']";
	public static final String LOG_OUT_LINK = "//a[text()='Log out']";
	
	// 14 pages link_text
	public static final String HOME_PAGE_TEXT = "Manager";
	public static final String NEW_CUSTOMER_TEXT = "New Customer";
	public static final String EDIT_CUSTOMER_TEXT = "Edit Customer";
	public static final String DELETE_CUSTOMER_TEXT = "Delete Customer";
	public static final String NEW_ACCOUNT_TEXT = "New Account";
	public static final String EDIT_ACCOUNT_TEXT = "Edit Account";
	public static final String DELETE_ACCOUNT_TEXT = "Delete Account";
	public static final String DEPOSIT_TEXT = "Deposit";
	public static final String WITHDRAWAL_TEXT = "Withdrawal";
	public static final String FUND_TRANSFER_TEXT = "Fund Transfer";
	public static final String CHANGE_PASSWORD_TEXT = "Change Password";
	public static final String BALANCE_ENQUIRY_TEXT = "Balance Enquiry";
	public static final String MINI_STATEMENT_TEXT = "Mini Statement";
	public static final String CUSTOMISED_STATEMENT_TEXT = "Customised Statement";
	public static final String LOG_OUT_TEXT = "Log out";
	
	// dynamic page elements
	public static final String DYNAMIC_MENU_LINK = "//a[text()='%s']";
	public static final String DYNAMIC_TEXTBOX = "//input[@name='%s']";
	public static final String DYNAMIC_TEXTAREA = "//textarea[@name='%s']";
	public static final String DYNAMIC_RADIO_BUTTON = "//input[@value='%s']";
	public static final String DYNAMIC_BUTTON = "//input[@value='%s']";
	public static final String DYNAMIC_DROPDOWN = "//select[@name='%s']";
	public static final String DYNAMIC_ERROR_MESSAGE = "//td[text()='%s']/following-sibling::td/label";
	public static final String DYNAMIC_PAGE_NAME_OR_TABLE_HEADER_MESSAGE = "//p[@class='heading3' and text()='%s']";
	public static final String DYNAMIC_DATA_IN_TABLE = "//td[text()='%s']/following-sibling::td";
}
