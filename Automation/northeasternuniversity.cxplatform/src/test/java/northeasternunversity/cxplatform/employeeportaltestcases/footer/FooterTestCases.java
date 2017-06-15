package northeasternunversity.cxplatform.employeeportaltestcases.footer;

import northeasternuniversity.cxplatform.pages.general.*;
import northeasternuniversity.cxplatform.webdriver.*;
import northeasternuniversity.cxplatform.constants.*;
import northeasternuniversity.cxplatform.pages.staffemployeeportal.*;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class FooterTestCases {

	LoginPage loginPage;
	HomePage homePage;

	WebDriverManager driverManager;
	UIElementsPropertiesManager UIElementsPropertiesManager;
	ConstantsPropertiesManager constantsPropertiesManager;
	DataSourceManager dataSourceManager;

	int userNameIndex;
	int passwordIndex;
	String userName;
	String password;

	String expectedURLForHomeLink;
	String expectedURLForHumanResourcesLink;
	String expectedURLForAppsAndLinksLink;
	String expectedURLForDirectoryLink;
	String expectedURLForCommunityLink;
	String expectedDataForCopyRight;

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

		this.dataSourceManager.setTestDataRow(6);
		this.expectedURLForHomeLink = dataSourceManager.getDataValue(1);
		this.dataSourceManager.setTestDataRow(7);
		this.expectedURLForHumanResourcesLink = dataSourceManager.getDataValue(1);
		this.dataSourceManager.setTestDataRow(8);
		this.expectedURLForAppsAndLinksLink = dataSourceManager.getDataValue(1);
		this.dataSourceManager.setTestDataRow(9);
		this.expectedURLForDirectoryLink = dataSourceManager.getDataValue(1);
		this.dataSourceManager.setTestDataRow(10);
		this.expectedURLForCommunityLink = dataSourceManager.getDataValue(1);
		this.dataSourceManager.setTestDataRow(11);
        this.expectedDataForCopyRight= dataSourceManager.getDataValue(1);
        
		dataSourceManager.closeIO();
	}

	@Test(priority = 1)
	public void NUCP62() {

		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-62:" + "\n"
				+ "Summary: Verify that the application displays the proper Footer options according with configured on web content article");

		loginPage.setCredentials(userName, password);
		loginPage.loginClick();
		homePage.goToHomePage();

		// Verifying if we are positioned on the site dashboard page
		Assert.assertTrue(homePage.getDriver().getCurrentUrl().equals(
				constantsPropertiesManager.getSharedExecutionConstants().getProperty("northeastern.edu_homepageurl")));

		// Waiting for the web browser, it should loads all the elements on the
		// DOM
		homePage.getDriverManager().driverLongWait();

		// Verifying if the Element to be clicked is present on the DOM
		Assert.assertTrue(homePage.isHomeFooterLinkElementPresent());
		Assert.assertTrue(homePage.isTheCorrectURLForFooterHomeLink(expectedURLForHomeLink));
		
		Assert.assertTrue(homePage.isHumanResourcesFooterLinkElementPresent());
		Assert.assertTrue(homePage.isTheCorrectURLForFooterHumanResourcesLink(expectedURLForHumanResourcesLink));
		
		Assert.assertTrue(homePage.isAppsAndLinksFooterLinkElementPresent());
		Assert.assertTrue(homePage.isTheCorrectURLForFooterAppsAndLinksLink(expectedURLForAppsAndLinksLink));
		
		Assert.assertTrue(homePage.isDirectoryFooterLinkElementPresent());
		Assert.assertTrue(homePage.isTheCorrectURLForFooterDirectoryLink(expectedURLForDirectoryLink));
		
		Assert.assertTrue(homePage.isComunityFooterLinkElementPresent());
		Assert.assertTrue(homePage.isTheCorrectURLForFooterCommunityLink(expectedURLForCommunityLink));

	}

	@Test(priority = 2)
	public void NUCP63() {
		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-63:" + "\n"
				+ "Summary: Verify that the application displays properly the “Copyright” data when any page is loaded");

		// Waiting for the web browser, it should loads all the elements on the
		// DOM
		homePage.getDriverManager().driverLongWait();
		
		Assert.assertTrue(homePage.isCopyrightFooterElementPresent());
		Assert.assertTrue(homePage.isTheCorrectCopyright(expectedDataForCopyRight));
	}

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}
}
