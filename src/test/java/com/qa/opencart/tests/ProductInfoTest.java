package com.qa.opencart.tests;

import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constents.AppConstents;
import com.qa.opencart.utils.ExceiUtil;

public class ProductInfoTest extends BaseTest {

	@BeforeClass
	public void productInfoSetUp() {

		acctpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@DataProvider
	public Object[][] getSearchData() {
		return new Object[][] { 
			{ "MacBook", "MacBook Pro", 4 }, 
			{ "MacBook", "MacBook Air", 4 },
			{ "iMac", "iMac", 3 }, 
			{ "Samsung", "Samsung SyncMaster 941BW", 1 }

		};

	}
	
	@DataProvider
	public Object[][] getUserProductExcelData() throws InvalidFormatException  {
	
		
		
			Object regData[][] = ExceiUtil.getTestData(AppConstents.PRODUCT_DATA_SHEET_NAME);
	
	return regData;
	}

	@Test(dataProvider = "getUserProductExcelData")
	public void productImageCountTest(String searchkey, String productName, String imageCount) {

		searchResultPage = acctpage.doSearch(searchkey);
		productInfoPage = searchResultPage.selectProduct(productName);

		Assert.assertEquals(String.valueOf(productInfoPage.getProducImageCount()), imageCount);

	}
	// Brand: Apple
//	Product Code: Product 18
//	Reward Points: 800
//	Availability: In Stock

	@Test
	public void producMetaDataTest() {

		searchResultPage = acctpage.doSearch("MacBook");
		productInfoPage = searchResultPage.selectProduct("MacBook Pro");

		Map<String, String> productDetailsMap = productInfoPage.getProductDetails();

		softAssert.assertEquals(productDetailsMap.get("Brand"), "Apple");
		softAssert.assertEquals(productDetailsMap.get("Product Code"), "Product 18");
		softAssert.assertEquals(productDetailsMap.get("Reward Points"), "800");
		softAssert.assertEquals(productDetailsMap.get("Availability"), "In Stock");

		softAssert.assertEquals(productDetailsMap.get("Price"), "$2,000.00");
		softAssert.assertEquals(productDetailsMap.get("Tax"), "$2,000.00");

		softAssert.assertAll();

	}

}
