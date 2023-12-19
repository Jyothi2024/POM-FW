package com.qa.opencart.tests;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constents.AppConstents;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.utils.ExceiUtil;

public class Login_Nagative_Test extends BaseTest{

	
	
	
	@DataProvider
	public Object[][] getLoginNagativeExcelData() throws InvalidFormatException {

		Object regData[][] = ExceiUtil.getTestData(AppConstents.LOGIN_NAGATIVE_DATA_SHEET_NAME);

		return regData;
	}

	
	
//	@Test(dataProvider = "getLoginNagativeExcelData")
//	public void loginNagativeTest(String username,String password) {
//		
//		loginpage.doLogin(username, password);
//		
//		String text =loginpage.getWarnnigText();
//		
//		Assert.assertEquals(text ,AppConstents.LOGIN_NAGATIVE_WARNNING_MESSG);
//
//	}

}
