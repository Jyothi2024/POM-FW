package com.qa.opencart.pages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constents.AppConstents;
import com.qa.opencart.utils.ElementUtil;

public class ProducInfoPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By productHeader = By.xpath("//div[@id='content']//h1");
	private By productImage = By.xpath("//ul[@class='thumbnails']//img");
	private By producMetaData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
	private By producMetaPrice = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");

	//private Map<String, String> productMap = new HashMap<String, String>();
	private Map<String, String> productMap = new LinkedHashMap<String, String>();
	//private Map<String, String> productMap = new TreeMap<String, String>();

	public ProducInfoPage(WebDriver driver) {

		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);

	}

	public String getProductHeaderName() {

		String ProdeuctHeaderVal = eleUtil.doElementGetText(productHeader);
		System.out.println("ProdeuctHeader : " + ProdeuctHeaderVal);

		return ProdeuctHeaderVal;
	}

	public int getProducImageCount() {
		int imageCount = eleUtil.waitForvisibilityOfElements(productImage, AppConstents.MEDIUM_DEFAULT_WAIT).size();
		System.out.println("product : " + getProductHeaderName() + " imgesCount : " + imageCount);
		return imageCount;
	}

//	Brand: Apple
//	Product Code: Product 18
//	Reward Points: 800
//	Availability: In Stock
	private void getProductMetaData() {

		List<WebElement> metaDataList = eleUtil.waitForvisibilityOfElements(producMetaData,
				AppConstents.MEDIUM_DEFAULT_WAIT);

		for (WebElement e : metaDataList) {

			String metaData = e.getText();

			String metaKey = metaData.split(":")[0].trim();
			String metaValue = metaData.split(":")[1].trim();

			productMap.put(metaKey, metaValue);

		}
	}

	private void getProductMetaPrice() {

		List<WebElement> metaPriceList = eleUtil.waitForvisibilityOfElements(producMetaPrice,
				AppConstents.MEDIUM_DEFAULT_WAIT);

		String productPrice = metaPriceList.get(0).getText();
		String productTax = metaPriceList.get(1).getText().split(":")[1].trim();
		
		productMap.put("Price", productPrice);
		productMap.put("Tax", productTax);

	}

	public Map<String, String> getProductDetails() {

		productMap.put("ProductName", getProductHeaderName());
		
		getProductMetaData();
		getProductMetaPrice();

		System.out.println(productMap);
		return productMap;

	}

}
