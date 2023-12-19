package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constents.AppConstents;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;

	ElementUtil eleUtil;

	// By locators : OR Page Factory

	private By userName = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By logo = By.xpath("//img[@title='naveenopencart']");
	private By newCustomerText = By.xpath("//h2[1]");
	private By returnningCustomerText = By.xpath("//h2[normalize-space()='Returning Customer']");

	private By warnningText = By.xpath("//div[contains(@class,'alert alert-danger')]");

	// Registation Page Link
	private By registerLink = By.linkText("Register");

	// Footer Page Link
	private By footerLinks1 = By.xpath("//div[@class='container']//div[@class='col-sm-3']/ul/li");

	// h2[normalize-space()='Returning Customer']
	// div[@class='collapse navbar-collapse navbar-ex1-collapse']

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}

	// page action/ methods
	public String getLoginpageTitle() {

		String title = eleUtil.waitForTitleIs(AppConstents.LONGIN_PAGE_TITLE, AppConstents.SHORT_DEFAULT_WAIT);
		System.out.println("login page title : " + title);
		return title;
	}

	public String getLoginpageUrl() {

		String url = eleUtil.waitForUrlContains(AppConstents.LONGIN_PAGE_URL_FRACTION, AppConstents.SHORT_DEFAULT_WAIT);

		System.out.println("login page title : " + url);
		return url;
	}

	public boolean isforgotPwdLinkExits() {

		return eleUtil.waitForvisibilityOfElement(forgotPwdLink, AppConstents.SHORT_DEFAULT_WAIT).isDisplayed();

	}

	public boolean isLOGOExits() {

		return eleUtil.waitForvisibilityOfElement(logo, AppConstents.SHORT_DEFAULT_WAIT).isDisplayed();

	}

	public boolean isNewCusTextExist() {

		return eleUtil.waitForvisibilityOfElement(newCustomerText, AppConstents.SHORT_DEFAULT_WAIT).isDisplayed();

	}

	public boolean isReturnningCusTextExist() {

		return eleUtil.waitForvisibilityOfElement(returnningCustomerText, AppConstents.SHORT_DEFAULT_WAIT)
				.isDisplayed();

	}

	public AccountsPage doLogin(String username, String Pwd) {
		
		System.out.println("Crediantails are : "+ username +" : "+ Pwd);

		eleUtil.waitForvisibilityOfElement(userName, AppConstents.SHORT_DEFAULT_WAIT).sendKeys(username);
		eleUtil.doSendkeys(password, Pwd);
		eleUtil.doClick(loginBtn);

		return new AccountsPage(driver);

	}

	public RegisterPage navigateToRegisterPage() {
		eleUtil.waitForvisibilityOfElement(registerLink, 10).click();
		return new RegisterPage(driver);
	}

	public List<WebElement> getFooterLinks() {

		List<WebElement> footerList1 = eleUtil.waitForvisibilityOfElements(footerLinks1, 5);

		for (WebElement e : footerList1) {

			String text = e.getText();

			System.out.println("FooterLinkList : " + text);

		}
		return null;

	}

	public boolean getWarnnigText() {
		
		

		String text = eleUtil.doElementGetText(warnningText);
		
		if(text.contains(AppConstents.LOGIN_NAGATIVE_WARNNING_MESSG))
				{
			return true;
		
		
				}return false;
		
		
	}

}
