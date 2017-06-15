package northeasternunversity.cxplatform.employeeportaltestcases.rightpanel;

import java.util.LinkedList;
import northeasternuniversity.cxplatform.pages.general.*;
import northeasternuniversity.cxplatform.webdriver.*;
import northeasternuniversity.cxplatform.constants.*;
import northeasternuniversity.cxplatform.pages.staffemployeeportal.*;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class QuickLinkAndRecentLinkTestCases {

	LoginPage loginPage;
	HomePage homePage;
	AppsAndLinksPage appsAndLinksPage;

	WebDriverManager driverManager;
	UIElementsPropertiesManager UIElementsPropertiesManager;
	ConstantsPropertiesManager constantsPropertiesManager;
	DataSourceManager dataSourceManager;

	int userNameIndex;
	int passwordIndex;
	String userName;
	String password;

	String expectedURLPage;
	LinkedList<String> recentlinksTexts;

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

	@Test(priority = 1)
	public void NUCP119() {

		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-119:" + "\n"
				+ "Summary: Verify that the application displays correct page when a tab navigation option clicked on the Dashboard Page");

		loginPage.setCredentials(userName, password);
		loginPage.loginClick();
		homePage.goToHomePage();

		// Verifying if we are positioned on the site dashboard page
		Assert.assertTrue(homePage.getDriver().getCurrentUrl().equals(
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
		homePage.getDriverManager().driverShortWait();
		// Verifying if the redirected URL (current) is the expected by user
		Assert.assertEquals(expectedURLPage, driverManager.getDriver().getCurrentUrl());

	}

	@Test(priority = 2, dependsOnMethods = { "NUCP119" })
	public void NUCP26() {
		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-26:" + "\n"
				+ "Summary: Verify that the application allows to pin a Link/Service as Fav/Quick Link on the “Recent Links” section");

		// Waiting for the web browser, it should loads all the new elements on
		// the DOM
		homePage.getDriverManager().driverLongWait();
		// Verifying if the recent link list is present on the DOM
		Assert.assertTrue(appsAndLinksPage.isRecentLinksListULElementPresent());

		// Verifying if the quick link list is present on the DOM
		Assert.assertTrue(appsAndLinksPage.isQuickLinksListULElementPresent());

		if (appsAndLinksPage.hasRecentLinks()) {
			recentlinksTexts = appsAndLinksPage.getAllElementTextsOnRecentLinksList();

			appsAndLinksPage.pinARecentLinkToQuickLinks();
			appsAndLinksPage.getDriverManager().getDriver().navigate().refresh();
			appsAndLinksPage.getDriverManager().driverShortWait();

			Assert.assertTrue(appsAndLinksPage.hasQuickLinks());

			for (String elementText : recentlinksTexts) {
				Assert.assertTrue(appsAndLinksPage.isElementOnQuickLinks(elementText));
			}

		}

	}

	@Test(priority = 3, dependsOnMethods = { "NUCP26" })
	public void NUCP27() {
		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-27:" + "\n"
				+ "Summary: Verify that the application removes a Link/Service from the “Recent Links” section when it is pinned as Fav Link");

		// Waiting for the web browser, it should loads all the new elements on
		// the DOM
		homePage.getDriverManager().driverLongWait();
		// Verifying if the recent link list is present on the DOM
		Assert.assertFalse(appsAndLinksPage.isRecentLinksListULElementPresent());
	}

	@Test(priority = 4, dependsOnMethods = { "NUCP27" })
	public void NUCP22() {
		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-22:" + "\n"
				+ "Summary: Verify that the application allows to open in a new tab a Fav Link on the “My Quick Links” section");

		// Waiting for the web browser, it should loads all the new elements on
		// the DOM
		homePage.getDriverManager().driverLongWait();
		// Verifying if the recent link list is present on the DOM
		Assert.assertTrue(appsAndLinksPage.hasQuickLinks());

		if (appsAndLinksPage.hasQuickLinks()) {
			LinkedList<WebElement> quickLinksHyperlinks = appsAndLinksPage.getAllQuickLinksHyperlinks();

			for (WebElement element : quickLinksHyperlinks)
				// Verifying if each hyperlink on the QuickLinks list can be
				// opened on a new webbrowser tab
				Assert.assertTrue(appsAndLinksPage.hyperLinkHasTargetBlankAttribute(element));
		}

	}

	@Test(priority = 5, dependsOnMethods = { "NUCP22" })
	public void NUCP20() {
		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-20:" + "\n"
				+ "Summary: Verify that the application displays the previously saved Fav links on the “My Quick Links” section (links saved/stored on the data base)");

		// Waiting for the web browser, it should loads all the new elements on
		// the DOM
		homePage.getDriverManager().driverLongWait();
		// Verifying if the recent link list is present on the DOM
		Assert.assertTrue(appsAndLinksPage.hasQuickLinks());

		if (appsAndLinksPage.hasQuickLinks()) {
			for (String elementText : recentlinksTexts) {
				Assert.assertTrue(appsAndLinksPage.isElementOnQuickLinks(elementText));

			}
		}
	}

	@Test(priority = 6, dependsOnMethods = { "NUCP20" })
	public void NUCP21() {
		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-21:" + "\n"
				+ "Summary: Verify that the application allows to delete the previously saved Fav Links on the “My Quick Links” section");

		// Waiting for the web browser, it should loads all the new elements on
		// the DOM
		homePage.getDriverManager().driverLongWait();
		// Verifying if the recent link list is present on the DOM
		Assert.assertTrue(appsAndLinksPage.hasQuickLinks());

		if (appsAndLinksPage.hasQuickLinks()) {
			for (String elementText : recentlinksTexts) {
				appsAndLinksPage.unpinFromQuickLinks(appsAndLinksPage.getElementFromQuickLinks(elementText));
				appsAndLinksPage.getDriverManager().getDriver().navigate().refresh();
				appsAndLinksPage.getDriverManager().driverShortWait();
			}
		}
		// Verifying if the recent link list is present on the DOM
		Assert.assertTrue(appsAndLinksPage.isRecentLinksListULElementPresent());
		if (appsAndLinksPage.hasRecentLinks()) {
			for (String elementText : recentlinksTexts) {
				Assert.assertTrue(appsAndLinksPage.isElementOnRecentLinks(elementText));
			}
		}

		if (appsAndLinksPage.hasRecentLinks()) {
			LinkedList<WebElement> recentLinksHyperlinks = appsAndLinksPage.getAllQuickLinksHyperlinks();

			for (WebElement element : recentLinksHyperlinks)
				// Verifying if each hyperlink on the RecentLinks list can be
				// opened on a new webbrowser tab
				Assert.assertTrue(appsAndLinksPage.hyperLinkHasTargetBlankAttribute(element));
		}

	}

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}
}
