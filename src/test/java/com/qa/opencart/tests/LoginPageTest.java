package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constents.AppConstents;

public class LoginPageTest extends BaseTest {

	@Test(priority =1)
	public void loginpageTitleTest() {

		String acttitle = loginpage.getLoginpageTitle();
		Assert.assertEquals(acttitle, AppConstents.LONGIN_PAGE_TITLE);

	}

	@Test(priority =2)
	public void loginpageUrlTest() {

		String acturl = loginpage.getLoginpageUrl();
		Assert.assertTrue(acturl.contains(AppConstents.LONGIN_PAGE_URL_FRACTION));

	}

	@Test(priority =3)
	public void loginpageForgetPWDTest() {
		Assert.assertTrue(loginpage.isforgotPwdLinkExits());

	}

	@Test(priority =4)
	public void loginpageLOGOTest() {

		Assert.assertTrue(loginpage.isLOGOExits());

	}
	@Test(priority =5)
	public void isNewCusTextExistTest() {

		Assert.assertTrue(loginpage.isNewCusTextExist());

	}
	@Test(priority =6)
	public void isReturnniCusTextExistTest() {

		Assert.assertTrue(loginpage.isReturnningCusTextExist());
	}


	@Test(priority =7)
	public void logineTest() {

		acctpage = loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertTrue(acctpage.isLogoutLinkExits());

	}

}
