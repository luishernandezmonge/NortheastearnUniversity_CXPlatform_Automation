package northeasternunversity.cxplatform.employeeportaltestcases.userprofile;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import static org.testng.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import northeasternuniversity.cxplatform.pages.general.*;
import northeasternuniversity.cxplatform.webdriver.*;
import northeasternuniversity.cxplatform.constants.*;
import northeasternuniversity.cxplatform.pages.staffemployeeportal.*;

public class AppsAndLinksTestCases {

	LoginPage loginPage;
	HomePage homePage;
	AppsAndLinksPage appsAndLinksPage;

	WebDriverManager driverManager;
	UIElementsPropertiesManager UIElementsPropertiesManager;
	ConstantsPropertiesManager constantsPropertiesManager;

	DataSourceManager dataSourceManager;

	String userName;
	String password;
	String expectedURLPage;

	@Test(priority = 1)
	public void NUCP119() {

		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-119:" + "\n"
				+ "Summary: Verify that the application displays correct page when a tab navigation option clicked on the Dashboard Page");

		loginPage.setCredentials(userName, password);
		loginPage.loginClick();
		homePage.goToHomePage();

		// Verifying if we are positioned on the site dashboard page
		AssertJUnit.assertTrue(homePage.getDriver().getCurrentUrl().equals(
				constantsPropertiesManager.getSharedExecutionConstants().getProperty("northeastern.edu_homepageurl")));

		// Waiting for the web browser, it should loads all the elements on the
		// DOM
		homePage.getDriverManager().driverShortWait();

		// Verifying if the Element to be clicked is present on the DOM
		Assert.assertTrue(homePage.isAppsAndLinksLinkElementPresent());
		homePage.appsAndLinksTabClick();

		// Waiting for the web browser, it should loads all the new elements on
		// the DOM
		homePage.getDriverManager().driverLongWait();
		// Verifying if the redirected URL (current) is the expected by user
		AssertJUnit.assertEquals(expectedURLPage, driverManager.getDriver().getCurrentUrl());

	}

	@Test(priority = 2)
	public void NUCP26() {
		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-26:" + "\n"
				+ "Summary: Verify that the application allows to pin a Link/Service as Fav/Quick Link on the “Recent Links” section");

		// Verifying if the Element to be clicked is present on the DOM
		Assert.assertTrue(homePage.isAppsAndLinksLinkElementPresent());
		homePage.appsAndLinksTabClick();

		// Waiting for the web browser, it should loads all the new elements on
		// the DOM
		homePage.getDriverManager().driverLongWait();
		// Verifying if the redirected URL (current) is the expected by user
		AssertJUnit.assertEquals(expectedURLPage, driverManager.getDriver().getCurrentUrl());

		appsAndLinksPage.getDriverManager().driverLongWait();
		
		// Verifying if the recent link list is present on the DOM
		Assert.assertTrue(appsAndLinksPage.isRecentLinksListDivElementPresent());
		
		// Verifying if the quick link list is present on the DOM
		Assert.assertTrue(appsAndLinksPage.isQuickLinksListDivElementPresent());
		
		if (appsAndLinksPage.hasRecentLinks()) {
			List<WebElement> recentLinks = appsAndLinksPage.getAllElementsOnRecentLinksList();
			appsAndLinksPage.pinARecentLinkToQuickLinks();
			appsAndLinksPage.getDriverManager().driverShortWait();
			
			assertTrue(appsAndLinksPage.hasQuickLinks());
			for (WebElement element : recentLinks) {
				Assert.assertTrue(appsAndLinksPage.isElementOnQuickLinks(element.getText()));
			}

		}else System.out.println("No recent links on Recent Links Portlet");

	}

	@BeforeTest
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new UIElementsPropertiesManager(FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);

		this.dataSourceManager = new DataSourceManager(FilesLocations.TESTUSERSDATASOURCEFILEPATH,
				constantsPropertiesManager.getSharedExecutionConstants().getProperty("dataSheetNameTestUsers"),
				Integer.parseInt(
						constantsPropertiesManager.getSharedExecutionConstants().getProperty("dataRowIndexTestUser")));

		this.loginPage = new LoginPage(driverManager, UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, UIElementsPropertiesManager, constantsPropertiesManager);
		this.appsAndLinksPage = new AppsAndLinksPage(driverManager, UIElementsPropertiesManager,
				constantsPropertiesManager);

		int userNameIndex = Integer
				.parseInt(constantsPropertiesManager.getSharedExecutionConstants().getProperty("userNameIndex"));
		int passwordIndex = Integer
				.parseInt(constantsPropertiesManager.getSharedExecutionConstants().getProperty("passwordIndex"));

		this.userName = dataSourceManager.getDataValue(userNameIndex);
		this.password = dataSourceManager.getDataValue(passwordIndex);

		this.dataSourceManager = new DataSourceManager(FilesLocations.TESTUSERSDATASOURCEFILEPATH,
				"OptionsAndExpectedURLS", 1);
		this.expectedURLPage = dataSourceManager.getDataValue(1);
		dataSourceManager.closeIO();

	}

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}

}
