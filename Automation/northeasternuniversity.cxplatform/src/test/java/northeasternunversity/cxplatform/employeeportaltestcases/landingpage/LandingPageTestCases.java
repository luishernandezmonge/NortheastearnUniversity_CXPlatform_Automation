package northeasternunversity.cxplatform.employeeportaltestcases.landingpage;

import northeasternuniversity.cxplatform.pages.general.*;
import northeasternuniversity.cxplatform.webdriver.*;
import northeasternuniversity.cxplatform.constants.*;
import northeasternuniversity.cxplatform.pages.staffemployeeportal.*;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class LandingPageTestCases {

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
		dataSourceManager.closeIO();
	}

	@Test(priority = 1)
	public void NUCP64() {

		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-64:" + "\n"
				+ "Summary: Verify that the application redirects to the proper landing page when user logs in");

		loginPage.setCredentials(userName, password);
		loginPage.loginClick();
		
		loginPage.getDriverManager().driverLongWait();
		
		// Verifying if we are positioned on the landing page
		Assert.assertTrue(loginPage.getDriver().getCurrentUrl().equals(
				constantsPropertiesManager.getSharedExecutionConstants().getProperty("northeastern.edu_homepageurl")));
		
	}

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}
}
