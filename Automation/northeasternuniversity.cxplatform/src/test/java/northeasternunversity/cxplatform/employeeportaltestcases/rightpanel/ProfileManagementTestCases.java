package northeasternunversity.cxplatform.employeeportaltestcases.rightpanel;


import northeasternuniversity.cxplatform.pages.general.*;
import northeasternuniversity.cxplatform.webdriver.*;
import northeasternuniversity.cxplatform.constants.*;
import northeasternuniversity.cxplatform.pages.staffemployeeportal.*;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ProfileManagementTestCases {

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
	public void NUCP142() {

		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-142:" + "\n"
				+ "Summary: Verify that the application displays properly the Profile Management popup when the “Profile” link is clicked");

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
		
		Assert.assertTrue(appsAndLinksPage.isProfileManagementPortletPresent());
		Assert.assertTrue(appsAndLinksPage.isProfileManagementLinkPresent());
		
		appsAndLinksPage.profileManagementLinkClick();
		
		Assert.assertTrue(appsAndLinksPage.isProfileManagementPopupPresentAndDisplayed());
		Assert.assertTrue(appsAndLinksPage.isProfileManagementPopupTitle());
		Assert.assertTrue(appsAndLinksPage.isProfileManagementPopupCloseButton());
		
		appsAndLinksPage.profileManagementPopupCloseClick();
		
		Assert.assertFalse(appsAndLinksPage.isProfileManagementPopupPresentAndDisplayed());		
	}

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}
}
