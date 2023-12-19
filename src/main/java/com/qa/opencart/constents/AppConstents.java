package com.qa.opencart.constents;

import java.util.Arrays;
import java.util.List;

public class AppConstents {
	
	
	
	public static final String LONGIN_PAGE_TITLE = "Account Login";
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final String REGISTRATION_PAGE_TITLE = "Register Account";
	
	public static final String LONGIN_PAGE_URL_FRACTION = "route=account/login";
	public static final String ACCOUNT_PAGE_URL_FRACTION = "route=account/account";
	public static final String REGISTRATION_PAGE_URL_FRACTION = "route=account/register";
	
	public static final int SHORT_DEFAULT_WAIT =5;
	public static final int MEDIUM_DEFAULT_WAIT =10;
	public static final int LONG_DEFAULT_WAIT =20;

	public static final int POLLING_DEFAULT_WAIT =2;
	public static final Object ACCOUNT_PAGE_HEARDS_COUNT = 4;
	
	

	public static final List <String> ACCOUNT_PAGE_HEARDS_LIST =
			Arrays.asList("My Account","My Orders","My Affiliate Account","Newsletter");
	
	public static final String USER_REGISTRATION_SUCCESS_MESSG = "your Account Has Been Created!";
	
	public static final String REGISTER_DATA_SHEET_NAME = "register";
	public static final String PRODUCT_DATA_SHEET_NAME = "product";
	public static final String LOGIN_NAGATIVE_DATA_SHEET_NAME = "loginNagativData";
	
	
	public static final String LOGIN_NAGATIVE_WARNNING_MESSG = " Warning: No match for E-Mail Address and/or Password.!";


}
