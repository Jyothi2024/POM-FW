package com.qa.opencart.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.exceptions.FrameWorkException;
import com.qa.opencart.factory.DriverFactory;

public class ElementUtil {

	private static WebDriver driver;
	
	private JavaScriptUtil jsUtil;

	// Constractor
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		jsUtil = new JavaScriptUtil (driver);
	}
	
	private void isHighlight(WebElement element) {
		if(Boolean.parseBoolean (DriverFactory.highlight)) {
			jsUtil.flash(element);
			
		}
	}
		

	// By Util

	public By getBy(String locatorType, String locatorValue) {

		By by = null;

		switch (locatorType.toLowerCase().trim()) {
		case "id":
			by = By.id(locatorValue);

			break;
		case "name":
			by = By.name(locatorValue);
			break;
		case "className":
			by = By.className(locatorValue);
			break;
		case "xpath":
			by = By.xpath(locatorValue);
			break;
		case "css":
			by = By.cssSelector(locatorValue);
			break;

		case "linkText":
			by = By.linkText(locatorValue);
			break;

		case "partailLinkText":
			by = By.partialLinkText(locatorValue);
			break;
		case "TagName":
			by = By.tagName(locatorValue);
			break;

		default:
			System.out.println("Wrong Locator type is Passed ...." + locatorType);
			throw new FrameWorkException ("WRONG LOCATOR TYPE .... ");

		}

		return by;

	}

	// Util Methods
	public void clickOnElement(By locator, String text) {

		List<WebElement> regList = getElements(locator);

		System.out.println(regList.size());

		for (WebElement e : regList) {

			String val = e.getText();

			System.out.println(val);
			if (val.contains(text)) {

				e.click();
				break;
			}
		}

	}

	// WAF : Capture the text of all the page links and return list<String>.
	public List<String> getElementText(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for (WebElement e : eleList) {

			String text = e.getText();
			if (text.length() != 0) {
				eleTextList.add(text);
			}

		}
		return eleTextList;

	}
	// WAF Capture the Specific Attibute from list :

	public List<String> getElementAttributeList(By locator, String attName) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleAtttList = new ArrayList<String>();
		for (WebElement e : eleList) {

			String attValue = e.getAttribute(attName);
			if (attValue.length() != 0) {
				eleAtttList.add(attValue);
			}
		}
		return eleAtttList;
	}

	public int getSize(By locator) {
		return getElements(locator).size();
	}

	public List<WebElement> getElements(By locator) {

		return driver.findElements(locator);

	}

	// GET ATTRIBUTE :
	public String doGetAttibute(By locator, String attrName) {

		return getElement(locator).getAttribute(attrName);

	}

	public void doSendKeys(String locatorType, String locatorValue, String value) {
		getElement(getBy(locatorType, locatorValue));
	}

	// SENDKEYS BY LOCATOR
	public void doSendkeys(By locator, String value) {

		getElement(locator).sendKeys(value);

	}

	// GET TEXT BY LOCATOR
	public String doElementGetText(By locator) {

		return getElement(locator).getText();

	}

	// GET TEXT STRING LOCATOR
	public String doElementGetTextString(String locatorType, String locatorValue) {

		return getElement(locatorType, locatorValue).getText();

	}

	// DOCLICK STRING LOCATOR
	public void doClick(String locatorType, String locatorValue) {

		getElement(locatorType, locatorValue).click();

	}

	// DOCLICK BY LOCATOR
	public void doClick(By locator) {

		getElement(locator).click();

	}

	// GET ELEMENT BY STRING LOCATOR
	
	public WebElement getElement(String locatorType, String locatoeValue) {

		WebElement element =   driver.findElement(getBy(locatorType, locatoeValue));
		
	isHighlight(element);
		return element;
	}

	// GET ELEMENT BY LOCATOR
	public WebElement getElement(By locator) {

		WebElement element =  driver.findElement(locator);
		if(Boolean.parseBoolean (DriverFactory.highlight)) {
			jsUtil.flash(element);
			
		}return element;

	}

	// *****************************************//SELECT CALSS UTILS //
	// **************************************
	// GET ELEMENT IS PRESENT OR NOT //
	public boolean checkSingleElementPresent(By locator) {

		return driver.findElements(locator).size() == 1 ? true : false;

	}

	public boolean checkElementPresent(By locator) {

		return driver.findElements(locator).size() >= 1 ? true : false;

	}

	public boolean checkElementPresent(By locator, int totalElements) {

		return driver.findElements(locator).size() >= totalElements ? true : false;

	}

	public void doSelectDrpDownByIndex(By locator, int index) {

		Select select = new Select(getElement(locator));

		select.selectByIndex(index);

	}

	public void doSelectDrpDownByVisibleText(By locator, String visibleText) {

		Select select = new Select(getElement(locator));

		select.selectByVisibleText(visibleText);
	}

	public void doSelectDrpDownByValue(By locator, String value) {

		Select select = new Select(getElement(locator));

		select.selectByValue(value);

	}

	private Select createSelect(By locator) {
		Select select = new Select(getElement(locator));
		return select;
	}

	public int getOptionsSize(By locator) {

		Select select = new Select(getElement(locator));
		return select.getOptions().size();

	}

	public List<String> PrinttSlectDropDownOptions(By locator) {

		Select select = new Select(getElement(locator));

		List<WebElement> Country_option = select.getOptions();

		List<String> get_List = new ArrayList<String>();

		for (WebElement e : Country_option) {

			String val = e.getText();
			get_List.add(val);

		}
		return get_List;
	}

	public void selectDropDownOptions(By locator, String optionvalue) {

		Select select = new Select(getElement(locator));

		List<WebElement> Country_option = select.getOptions();

		System.out.println(Country_option.size());

		for (WebElement e : Country_option) {

			String val = e.getText();

			System.out.println(val);

			if (val.contains(optionvalue)) {

				e.click();
				break;

			}
		}
	}

	public boolean isDropDowntMultiple(By locator) {
		// WebElement webEle = getElement(locator);

		// Select select = new Select(getElement(locator));
		return createSelect(locator).isMultiple() ? true : false;

	}

	/**
	 * This method is used to select the values from the drop down. It can select;
	 * 1. single selection 2. Multiple selection 3. All Selection: please pass "all"
	 * as a value to select all the values
	 * 
	 * @param locator
	 * @param values
	 */
	public void selectMultiValues(By locator, By optionLocator, String... values) {
		Select select = new Select(getElement(locator));

		if (isDropDowntMultiple(locator)) {

			if (values[0].equalsIgnoreCase("All")) {

				List<WebElement> options = getElements(optionLocator);
				for (WebElement val : options) {
					val.click();
				}
			} else {

				for (String e : values) {

					createSelect(locator).selectByVisibleText(e);
				}
			}

		}

	}

	////// ***************ACTION CLASSS UTLS ********************/////

	public void doActionsSendKeys(By locator, String value) {

		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}

	public void doActionsSendKeys(By locator) {

		Actions act = new Actions(driver);
		act.click(getElement(locator)).build().perform();
	}

	public void teoLevelMenuHandle(By parentMenulocator, By childMenuLocator) throws InterruptedException {

		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenulocator)).build().perform();

		Thread.sleep(1000);
		driver.findElement(childMenuLocator).click();
		doClick(childMenuLocator);
	}

	public void fourLevelMenuHandle(By ParentMenu, By firstChildMenuLocator, By secondMenuChildLocator,
			By thirdMenuLocator) throws InterruptedException {
		Actions act = new Actions(driver);

		doClick(ParentMenu);
		Thread.sleep(1000);
		act.moveToElement(getElement(firstChildMenuLocator)).build().perform();
		Thread.sleep(1000);
		act.moveToElement(getElement(secondMenuChildLocator)).build().perform();
		Thread.sleep(1000);
		doClick(firstChildMenuLocator);

	}

	public void doActionsSendkeysWithPause(By locator, String value) {

		Actions act = new Actions(driver);
		WebElement email = getElement(locator);

		String value1 = value;

		char[] ch = value1.toCharArray();

		for (char e : ch) {

			act.sendKeys(email, String.valueOf(e)).pause(500).build().perform();
		}

	}

	
	
	
	// **************************Wait Utils*******************//
	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForPresenceOfElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		WebElement element=  wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		isHighlight(element);
		return element;
		
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible. Visibility means that the element is not only displayed but also
	 * has a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForvisibilityOfElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		isHighlight(element);
		return element;
	}
	

	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 * 
	 * @param locator
	 * @param timeOut
	 * @param intervalTime
	 * @return
	 */
	public WebElement waitForPresenceOfElement(By locator, int timeOut, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
		
		WebElement element =  wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		isHighlight(element);
		return element;
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible. Visibility means that the element is not only displayed but also
	 * has a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @param intervalTime
	 * @return
	 */
	public WebElement waitForvisibilityOfElement(By locator, int timeOut, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
		WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	
		isHighlight(element);
		return element;
	}

	public List<WebElement> waitForvisibilityOfElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public List<WebElement> waitForPresenceOfElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public void doClickWithWait(By locator, int timeOut) {

		waitForvisibilityOfElement(locator, timeOut).click();

	}

	public void doSendKeysWithWait(By locator, String value, int timeOut) {

		waitForvisibilityOfElement(locator, timeOut).sendKeys(value);
	}
	
	
	// ********** Get Title and URL  With WAIT ************//

	
	
	public String waitForTitleContains(String TitleFraction, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if (wait.until(ExpectedConditions.titleContains(TitleFraction))) {

				return driver.getTitle();
			}
		} catch (TimeoutException e) {
			System.out.println(TitleFraction + "Title value is not Present");
			e.printStackTrace();
		}
		return null;
	}

	public String waitForTitleIs(String Title, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if (wait.until(ExpectedConditions.titleIs(Title))) {

				return driver.getTitle();
			}
		} catch (TimeoutException e) {
			System.out.println(Title + "Title value is not Present");
			e.printStackTrace();
		}
		return null;
	}

	public String waitForUrlContains(String urlFraction, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if (wait.until(ExpectedConditions.urlContains(urlFraction))) {

				return driver.getCurrentUrl();
			}
		} catch (TimeoutException e) {
			System.out.println(urlFraction + "URL value is not Present");
			e.printStackTrace();
		}
		return null;
	}

	public String waitForUrlIs(String url, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if (wait.until(ExpectedConditions.urlToBe(url))) {

				return driver.getCurrentUrl();
			}
		} catch (TimeoutException e) {
			System.out.println(url + "Url value is not Present");
			e.printStackTrace();
		}
		return null;
	}

	public Alert waitForJSAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());

	}

	public void acceptJSAlert(int timeOut) {

		waitForJSAlert(timeOut).accept();
	}

	public void dissmisJSAlert(int timeOut) {

		waitForJSAlert(timeOut).dismiss();

	}

	public void getTexttJSAlert(int timeOut) {

		waitForJSAlert(timeOut).getClass();

	}

	public void enterValueOnJSAlert(String value, int timeOut) {

		waitForJSAlert(timeOut).sendKeys(value);

	}
}
