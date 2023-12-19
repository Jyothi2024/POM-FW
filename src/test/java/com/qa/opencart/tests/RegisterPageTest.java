package com.qa.opencart.tests;

import java.util.UUID;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constents.AppConstents;
import com.qa.opencart.utils.ExceiUtil;

public class RegisterPageTest extends BaseTest {
	
	@BeforeClass
	public void regSetUp() {

		// acctpage = new AccountsPage(driver);
		registerPage = loginpage.navigateToRegisterPage();
		
		
		
	}
	
	public String getRandomEmailID() {
		//Option#1
		return "testautotion"+System.currentTimeMillis()+ "@opencart.com";
		
		//Option#2
		//UUID is Calss genetrate LongNumber
		
		//return "testautotion"+UUID.randomUUID()+ "@opencart.com";
		
	}
	@DataProvider
	public Object[][] getUserRegExcelData() throws InvalidFormatException  {
	
		
		
			Object regData[][] = ExceiUtil.getTestData(AppConstents.REGISTER_DATA_SHEET_NAME);
		
	
	return regData;
	}
	
	
	
	
//	@DataProvider
//	public Object[][] getUserRegData() {
//		
//		return new Object [][] {		
//		{"Hari10", "QAAuto", "123456786","test111@123", "yes"},
//		{"jyothi11", "QAAuto", "jytohi1222@gmail.com11", "123456786","test222@123", "no"},
//		{"Valli", "QAAuto", "jytohi3333@gmail.com11", "123456786","test333@123", "yes"},
//		
//		};
//	
		
	//}
	@Test(dataProvider = "getUserRegExcelData")
	public void userRegFormTest(String firstName, String lastName,  String telephone, String password,String subscribe){
		
		
		
		boolean isRegDone = registerPage.userRegisteration
				(firstName, lastName, getRandomEmailID() , telephone,  password, subscribe);
		
//		//Assert.assertTrue(isRegDone);
//	}
	
	}	
	
}
