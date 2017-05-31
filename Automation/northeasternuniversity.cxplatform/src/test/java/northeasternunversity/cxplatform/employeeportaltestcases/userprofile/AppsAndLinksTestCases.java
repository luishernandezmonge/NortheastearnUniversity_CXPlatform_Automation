package northeasternunversity.cxplatform.employeeportaltestcases.userprofile;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import northeasternuniversity.cxplatform.pages.general.*;
import northeasternuniversity.cxplatform.webdriver.*;
import northeasternuniversity.cxplatform.constants.*;
import northeasternuniversity.cxplatform.pages.staffemployeeportal.*;
import northeasternuniversity.cxplatform.utilities.HTTPResponsesChecker;

public class AppsAndLinksTestCases {

	LoginPage loginPage;
	WebDriverManager driverManager;
	UIElementsPropertiesManager UIElementsPropertiesManager;
	ConstantsPropertiesManager constantsPropertiesManager;
	HomePage homePage;
	DataSourceManager dataSourceManager;
	HTTPResponsesChecker httpResponsesChecker;

	String userName;
	String password;
	String expectedURLPage;

	@Test
	public void test() {
		System.out.println(
				"Testing #TESTCASE_ID: Summary: Verify the application redirects to the Apps&Links Page Properly when Apps&Links tab is clicked");

		loginPage.setCredentials(userName, password);

		loginPage.loginClick();
		homePage.getDriverManager().maximizeWindow();
		homePage.getDriverManager().driverWait();
		homePage.goToHomePage();

		// Verifying if we are positioned on the site dashboard page
		AssertJUnit.assertTrue(homePage.getDriver().getCurrentUrl().equals(
				constantsPropertiesManager.getSharedExecutionConstants().getProperty("northeastern.edu_homepageurl")));

		// Waiting for the web browser, it should loads all the elements on the
		// DOM
		homePage.getDriverManager().driverWait();

		Assert.assertTrue(homePage.isAppsAndLinksLinkElementPresent());
		homePage.appsAndLinksLocatorClick();

		// Waiting for the web browser, it should loads all the new elements on
		// the DOM
		homePage.getDriverManager().driverWait();
		AssertJUnit.assertEquals(driverManager.getDriver().getCurrentUrl(), expectedURLPage);

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

		httpResponsesChecker = new HTTPResponsesChecker();

	}

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}

}
