package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constents.AppConstents;
import com.qa.opencart.utils.ElementUtil;

public class SearchResultPage  {
	
	
	private WebDriver driver;

	ElementUtil eleUtil;

	
	public SearchResultPage(WebDriver driver) {
		
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
		
	}
	
	
	public ProducInfoPage selectProduct(String productName) {
		
		eleUtil.waitForvisibilityOfElement(By.linkText(productName),AppConstents.MEDIUM_DEFAULT_WAIT).click();
		return new ProducInfoPage(driver);
		
	}
	 
	
}
