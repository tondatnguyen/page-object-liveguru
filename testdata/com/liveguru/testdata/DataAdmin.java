package com.liveguru.testdata;

	public class DataAdmin {
		
		public static final String USERNAME = "user01";
		public static final String PASSWORD = "guru99com";
		public static final String TYPEOF_FILE = ".pdf";
		public static final String CHROME_DOWNLOAD = ".crdownload";
		public static final String FIREFOX_DOWNLOAD = ".part";
		// realDownloadSeconds = downloadFileTime/2
		public static final int downloadFileTime = 60; 
		
		public class BackEndLoginPage {
			public static final String PAGE_TITLE = "Log in to Admin Panel";
		}
		
		public class BackEndHomePage {
			public static final String PAGE_TITLE = "Manage Customers";
			public static final String ID = "31389";
			public static final String NAME = "Automation FC";
			public static final String EMAIL = "automationfc.vn@gmail.com";
			public static final String TELEPHONE = "0123654789";
			public static final String ZIP = "550000";
			public static final String COUNTRY = "Vietnam";
			public static final String STATE_PROVINCE = "Cam Le";
		}
		
		public class OrdersPage {
			public static final String PAGE_TITLE = "Orders";
			public static final String CANCEL_OPTION = "Canceled";
			public static final String PRINT_INVOICES_OPTION = "Print Invoices";
			public static final String ERROR_MESSAGE = "There are no printable documents related to selected orders.";
			public static final String COMPLETE_OPTION = "Complete";
		}
		
		public class PendingReviewwsPage {
			public static final String PAGE_TITLE = "Pending Reviews";	
		// The review has been saved.
			public static final String SUCCESS_MESSAGE = "The review has been saved.";
		}
		
		public class EditReviewPage {
			public static final String PAGE_TITLE = "Edit Review '" + DataUser.Review.SUMMARY_XPERIA + "'";
			public static final String APPROVED_OPTION = "Approved";
		}
		
		public class InvoicesPage {
			public static final String PAGE_TITLE = "Invoices";
		}
		
	}
	
	

