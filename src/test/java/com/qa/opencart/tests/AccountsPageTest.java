package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constents.AppConstents;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.SearchResultPage;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accSetUp() {

		// acctpage = new AccountsPage(driver);
		acctpage = loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}

	@Test
	public void acctPagetitleTest() {

		Assert.assertEquals(acctpage.getAcctPageTitle(),AppConstents.ACCOUNT_PAGE_TITLE);

	}

	@Test
	public void acctPagetUrlTest() {

		Assert.assertTrue(acctpage.getAcctpageUrl().contains(AppConstents.ACCOUNT_PAGE_URL_FRACTION));

	}

	@Test
	public void isLogoutLinkExitsTest() {

		Assert.assertTrue(acctpage.isLogoutLinkExits());

	}

	@Test
	public void isSearchFieldkExitsTest() {

		Assert.assertTrue(acctpage.isSearchFieldExits());

	}

	@Test
	public void getAcctHeardsListTest() {

		List<String> actAcctHeardsList = acctpage.getAccountsHeaders();
		System.out.println(actAcctHeardsList);
	
		Assert.assertEquals(actAcctHeardsList, AppConstents.ACCOUNT_PAGE_HEARDS_LIST);

	}
	
	@Test
	public void searchTest() {
		
		searchResultPage= acctpage.doSearch("MacBook");
		
		productInfoPage = searchResultPage.selectProduct("MacBook Pro");
		
		String actproductIHeader = productInfoPage.getProductHeaderName();
		Assert.assertEquals(actproductIHeader,"MacBook Pro");
		
		
	}

}
