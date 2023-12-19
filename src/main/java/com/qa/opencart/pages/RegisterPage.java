package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constents.AppConstents;
import com.qa.opencart.utils.ElementUtil;

public class RegisterPage {

	private WebDriver driver;

	private  ElementUtil eleUtil;

	

	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");

	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input[@type='radio']");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input[@type='radio']");

	private By agreeCheckBox = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");

	private By successMessg = By.cssSelector("div#content h1");
	private By logoutLink = By.linkText("Logout");
	//private By registerLink = By.linkText("Register");
	private By registerLink = By.linkText("Register");

	public RegisterPage(WebDriver driver) {

		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}
	
	public boolean userRegisteration(String firstName, String lastName, String email, String telephone, String password,
			String subscribe) {

		eleUtil.waitForvisibilityOfElement(this.firstName, AppConstents.MEDIUM_DEFAULT_WAIT).sendKeys(firstName);
		
		eleUtil.doSendkeys(this.lastName, lastName);
		eleUtil.doSendkeys(this.email, email);
		eleUtil.doSendkeys(this.telephone, telephone);
		eleUtil.doSendkeys(this.password, password);
		eleUtil.doSendkeys(this.confirmpassword, password);

		if (subscribe.equalsIgnoreCase("yes")) {
			eleUtil.doClick(subscribeYes);
		} else {
			eleUtil.doClick(subscribeNo);
		}

		eleUtil.doClick(agreeCheckBox);
		eleUtil.doClick(continueButton);

		String successMesg = eleUtil.waitForvisibilityOfElement(successMessg, AppConstents.MEDIUM_DEFAULT_WAIT)
				.getText();
		System.out.println(successMesg);

		if (successMesg.contains(AppConstents.USER_REGISTRATION_SUCCESS_MESSG)) {
				eleUtil.doClick(logoutLink);
				eleUtil.doClick(registerLink);
			return true;
		} else {
			return false;
		}

	}


	
	

	

	public String getRegPageTitle() {
		String title = eleUtil.waitForTitleIs(AppConstents.REGISTRATION_PAGE_URL_FRACTION,
				AppConstents.SHORT_DEFAULT_WAIT);
		System.out.println("login page title : " + title);
		return title;
	}

	public String getRegPageUrl() {

		String url = eleUtil.waitForUrlContains(AppConstents.REGISTRATION_PAGE_URL_FRACTION,
				AppConstents.SHORT_DEFAULT_WAIT);

		System.out.println("login page title : " + url);
		return url;
	}

	

}
