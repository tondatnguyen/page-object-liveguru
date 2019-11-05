package com.liveguru.testdata;

	public class DataUser {
		
		public class HomePage {
			public static final String HOMEPAGE_TITLE = "THIS IS DEMO SITE FOR";
			public static final String HOMEPAGE_TITLE_LOCATOR = "This is demo site for";
			public static final String HOMEPAGE_IMG = "logo.png";
			public static final String HOMEPAGE_IMG_LOCATOR = "logo.png";
		}
		
		public class Register {
			public static final String REGISTER_PAGE_TITLE = "CREATE AN ACCOUNT";
			public static final String REGISTER_PAGE_TITLE_LOCATOR = "Create an Account";
			public static final String FIRSTNAME = "Auto";
			public static final String LASTNAME = "Test";
			public static final String EMAIL = "Automated";
			public static final String PASSWORD = "123123";
			public static final String CONFIRM_PASSWORD = "123123";	
			public static final String REGISTERED_SUCCESS_MESSAGE = "Thank you for registering with Main Website Store.";
			public static final String ACCOUNT_DASHBOARD_PAGE_TITLE = "MY DASHBOARD";
			public static final String ACCOUNT_DASHBOARD_PAGE_TITLE_LOCATOR = "My Dashboard"; 
			public static final String ACCOUNT_INFO_PAGE_TITLE = "EDIT ACCOUNT INFORMATION";
			public static final String ACCOUNT_INFO_PAGE_TITLE_LOCATOR = "Edit Account Information";
		}
		
		public class Product {
			public class Mobile {
				public static final String MOBILE_PAGE_TITLE = "MOBILE";
				public static final String MOBILE_PAGE_TITLE_LOCATOR = "Mobile"; 

				// Sony Xperia
				public static final String XPERIA_NAME = "SONY XPERIA";
				//public static final String XPERIA_NAME_IN_LOCATOR = "Sony Xperia";
				public static final String XPERIA_NAME_IN_MESSAGE = "Sony Xperia";
				public static final String XPERIA_PRICE = "$100.00";
				public static final String XPERIA_COMPARED_MESSAGE = "The product " + XPERIA_NAME_IN_MESSAGE + " has been added to comparison list.";
				public static final String XPERIA_IMAGE = "xperia.jpg";
				public static final String XPERIA_SKU = "MOB001";
				
				// IPhone
				public static final String IPHONE_NAME = "IPHONE";
				public static final String IPHONE_NAME_IN_LOCATOR = "IPhone";
				public static final String IPHONE_NAME_IN_MESSAGE = "IPhone";
				public static final String IPHONE_PRICE = "$500.00";
				public static final String IPHONE_COMPARED_MESSAGE = "The product " + IPHONE_NAME_IN_MESSAGE + " has been added to comparison list.";
				public static final String IPHONE_IMAGE = "iphone.png";
				public static final String IPHONE_SKU = "MOB0002";
			}
			public class TV {
				public static final String TV_PAGE_TITLE = "TV";
				public static final String TV_PAGE_TITLE_LOCATOR = "TV"; 
				
				// LG LCD
				public static final String LG_NAME = "LG LCD";
				public static final String LG_NAME_LOCATOR = "LG LCD";
				
				//SAMSUNG LCD
				public static final String SAMSUNG_NAME = "SAMSUNG LCD";
				public static final String SAMSUNG_NAME_LOCATOR = "Samsung LCD";
			}			
		}
		
		public class ShipCheckOut {
			public static final String SHOPPING_CART_PAGE_TITLE = "SHOPPING CART";  
			public static final String SHOPPING_CART_PAGE_TITLE_LOCATOR = "Shopping Cart"; 
			public static final String ADDED_TO_CART_MESSAGE = " was added to your shopping cart.";
			public static final String IPHONE_ADDED_TO_CART_MESSAGE = Product.Mobile.XPERIA_NAME_IN_MESSAGE + ADDED_TO_CART_MESSAGE;
			public static final String XPERIA_ADDED_TO_CART_MESSAGE = Product.Mobile.XPERIA_NAME_IN_MESSAGE + ADDED_TO_CART_MESSAGE;
			public static final String COUPON_CODE = "GURU50";
			public static final String COUPON_CODE_MESSAGE = "Coupon code " + COUPON_CODE + " was applied.";
			public static final String DISCOUNT_TEXT = "Discount (GURU50)";
			public static final String DISCOUNT_IPHONE_PRICE = "-$25.00";
			public static final String GRAND_TOTAL_TEXT = "GRAND TOTAL";
			public static final String GRAND_TOTAL_TEXT_LOCATOR = "Grand Total";
			public static final String GRAND_TOTAL_IPHONE_PRICE = "$475.00";
			public static final String QTY_VALUE = "501";
			public static final String ERROR_MAX_500_QUANTITY_MESSAGE = "* The maximum quantity allowed for purchase is 500.";
			public static final String ERROR_MAX_500_QUANTITY_MESSAGE_LOCATOR = "* The maximum quantity allowed for purchase is 500.";
			public static final String EMPTY_CART_MESSAGE = "SHOPPING CART IS EMPTY";
			public static final String EMPTY_CART_MESSAGE_LOCATOR = "Shopping Cart is Empty";
			public static final String NO_ITEMS_MESSAGE = "You have no items in your shopping cart.";
			public static final String NO_ITEMS_MESSAGE_LOCATOR = "You have no items in your shopping cart.";
			public static final String COUNTRY = "United States";
			public static final String STATE = "New York";
			public static final String CITY = "New York";
			public static final String ZIP = "543432";
			public static final String ADDRESS = "ABC";
			public static final String TELEPHONE = "1234567890";	
			public static final String SHIPPING_COST = "$5.00";
			public static final String GRAND_TOTAL_LG_LCD_PRICE = "$620.00";
			public static final String SUCCESS_ORDER_PAGE_TITLE = "YOUR ORDER HAS BEEN RECEIVED.";
			public static final String SUCCESS_ORDER_PAGE_TITLE_LOCATOR = "Your order has been received.";
		}
		
		public class PopUp {
			public static final String POPUP_BROWSER_PAGE_TITLE = "Products Comparison List - Magento Commerce";
			public static final String POPUP_HEADER_PAGE_TITLE = "COMPARE PRODUCTS";
			public static final String POPUP_HEADER_PAGE_TITLE_LOCATOR = "Compare Products";
			
			// IPhone
			public static final String IPHONE_NAME = "IPHONE";
			public static final String IPHONE_NAME_LOCATOR = "IPhone";
			public static final String IPHONE_PRICE = "$500.00";
			public static final String IPHONE_IMAGE = "iphone.png";
			public static final String IPHONE_IMAGE_LOCATOR = "iphone.png";
			public static final String IPHONE_SKU = "MOB0002";
			public static final String IPHONE_SKU_LOCATOR = "MOB0002";
			
			// Xperia
			public static final String XPERIA_NAME = "SONY XPERIA";
			public static final String XPERIA_NAME_LOCATOR = "Sony Xperia";
			public static final String XPERIA_PRICE = "$100.00";
			public static final String XPERIA_IMAGE = "xperia.jpg";
			public static final String XPERIA_IMAGE_LOCATOR = "xperia.jpg";
			public static final String XPERIA_SKU = "MOB001";
			public static final String XPERIA_SKU_LOCATOR = "MOB001";
		}

		public class WishList {
			public static final String MY_WISHLIST_PAGE_TITLE = "MY WISHLIST";
			public static final String MY_WISHLIST_PAGE_TITLE_LOCATOR = "My Wishlist";
			public static final String LG_ADDED_TO_WISHLIST_MESSAGE = Product.TV.LG_NAME + " has been added to your wishlist. Click here to continue shopping.";
			public static final String WISHLIST_SHARING_PAGE_TITLE = "SHARE YOUR WISHLIST";
			public static final String WISHLIST_SHARING_PAGE_TITLE_LOCATOR = "Share Your Wishlist";
			public static final String MESSAGE = "1234567890";
			public static final String SHARED_WISHLIST_MESSAGE = "Your Wishlist has been shared.";
			public static final String AMOUNT_PRODUCTS = "1"; 
		}
		
		public class Review {
			public static final String REVIEW_PAGE_TITLE = "PRODUCT REVIEWS";
			public static final String SUCCESS_REVIEW_MESSAGE = "Your review has been accepted for moderation.";
			//SAMSUNG LCD
			public static final String SAMSUNG_NAME = "SAMSUNG LCD";
			public static final String SAMSUNG_NAME_LOCATOR = "Samsung LCD";
			public static final String EMPTY_MESSAGE = "";
			public static final String ERROR_MESSAGE = "THIS IS A REQUIRED FIELD.";
			public static final String THOUGHS_MESSAGE = "THOUGHS Samsung LCD";
			public static final String REVIEW_MESSAGE = "REVIEW Samsung LCD";
			public static final String NICKNAME = "Nickname_" + Register.EMAIL;
		}
		
		public class AdvanceSearch {
			public static final String SETTINGS_TITLE = "SEARCH SETTINGS";
			public static final String SETTINGS_TITLE_LOCATOR = "Search Settings";
			public static final String START_PRICE_01 = "0";
			public static final String END_PRICE_01 = "150";
			public static final String START_PRICE_02 = "151";
			public static final String END_PRICE_02 = "1000";
			public static final String RESULT_TEXT = "RESULTS";
		}
		
	}
	
	

