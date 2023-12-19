package com.qa.opencart.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class FooterLinksTest extends BaseTest{
	
	
	
	
	@Test
	public void getFooterLinksTest1() {
		
		 List<WebElement> list1 = loginpage.getFooterLinks();
		 
		 softAssert.assertEquals(("About Us"), "About Us");
		 softAssert.assertEquals((" Terms & Conditions"), " Terms & Conditions");
		 softAssert.assertEquals(("Contact Us"), "Contact Us");
		 softAssert.assertEquals(("Newsletter"), "Newsletter");
		 softAssert.assertEquals(("Site Map"), "Site Map");
		 //softAssert.assertEquals(("Site Map"), "Site Map1");
		 
		 
		 softAssert.assertAll();
			
			
		
		
		
		
	}
	

}
