package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constents.AppConstents;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {

	private WebDriver driver;

	private ElementUtil eleUtil;

	private By logooutLink = By.linkText("Logout");
	private By search = By.name("search");
	private By accHeadersList = By.xpath("//div[@id='content']//h2");
	private By searchIcon = By.xpath("//button[@type='button' and @class='btn btn-default btn-lg']");

	public AccountsPage(WebDriver driver) {

		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}

	// Page Actions

	public String getAcctPageTitle() {

		String title = eleUtil.waitForTitleIs(AppConstents.ACCOUNT_PAGE_TITLE,AppConstents.SHORT_DEFAULT_WAIT);
		System.out.println("login page title : " + title);
		return title;
	}
	public String getAcctpageUrl() {

		String url = eleUtil.waitForUrlContains(AppConstents.ACCOUNT_PAGE_URL_FRACTION,AppConstents.SHORT_DEFAULT_WAIT);

		System.out.println("login page title : " + url);
		return url;
	}
	public boolean isLogoutLinkExits() {

		return eleUtil.waitForvisibilityOfElement(logooutLink, AppConstents.SHORT_DEFAULT_WAIT).isDisplayed();
	}

	public void logout() {

		if (isLogoutLinkExits()) {
			eleUtil.doClick(logooutLink);
		}

	}

	public boolean isSearchFieldExits() {

		return eleUtil.waitForvisibilityOfElement(search,AppConstents.SHORT_DEFAULT_WAIT).isDisplayed();
	}

	public List<String> getAccountsHeaders() {

		List<WebElement> list = eleUtil.waitForvisibilityOfElements(accHeadersList, AppConstents.MEDIUM_DEFAULT_WAIT);
		
		List<String> addList = new ArrayList<String>();
		for (WebElement e : list) {
			String text = e.getText();
			addList.add(text);
		}

		return addList;
	}
	
	
	public SearchResultPage doSearch(String searchkey) {
		
	//	eleUtil.waitForvisibilityOfElement(accHeadersList, 0)
		
		eleUtil.waitForvisibilityOfElement(search, AppConstents.MEDIUM_DEFAULT_WAIT).clear();
		eleUtil.waitForvisibilityOfElement(search, AppConstents.MEDIUM_DEFAULT_WAIT).sendKeys(searchkey);
		eleUtil.doClick(searchIcon);
		return new SearchResultPage(driver);//TDD Aproch
		
		
		
	}






}


















