package northeasternunversity.cxplatform.employeeportaltestcases.dashboard;

import northeasternuniversity.cxplatform.pages.general.*;
import northeasternuniversity.cxplatform.webdriver.*;
import northeasternuniversity.cxplatform.constants.*;
import northeasternuniversity.cxplatform.pages.staffemployeeportal.*;
import northeasternuniversity.cxplatform.utilities.DateChecker;
import northeasternuniversity.cxplatform.utilities.PageChecker;
import org.testng.annotations.Test;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class GmailPortletTestCases {

	LoginPage loginPage;
	HomePage homePage;

	WebDriverManager driverManager;
	UIElementsPropertiesManager UIElementsPropertiesManager;
	ConstantsPropertiesManager constantsPropertiesManager;
	DataSourceManager dataSourceManager;
	PageChecker pageChecker;
	DateChecker dateChecker;

	int userNameIndex;
	int passwordIndex;
	String userName;
	String password;
	String expectedURLForAuthorizationPageToContinueToTitleDescription;
	String expectedTitleForAuthorizationPageToContinueTo;
	String expectedBaseUrlAuthorizationPage;

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
		this.pageChecker = new PageChecker();
		this.dateChecker = new DateChecker();

		int userNameIndex = Integer
				.parseInt(constantsPropertiesManager.getSharedExecutionConstants().getProperty("userNameIndex"));
		int passwordIndex = Integer
				.parseInt(constantsPropertiesManager.getSharedExecutionConstants().getProperty("passwordIndex"));

		this.userName = dataSourceManager.getDataValue(userNameIndex);
		this.password = dataSourceManager.getDataValue(passwordIndex);

		this.dataSourceManager = new DataSourceManager(FilesLocations.TESTUSERSDATASOURCEFILEPATH,
				"OptionsAndExpectedURLS", 1);
		this.dataSourceManager.setTestDataRow(17);
		this.expectedURLForAuthorizationPageToContinueToTitleDescription = dataSourceManager.getDataValue(1);
		this.dataSourceManager.setTestDataRow(18);
		this.expectedBaseUrlAuthorizationPage = dataSourceManager.getDataValue(1);
		this.dataSourceManager.setTestDataRow(19);
		this.expectedTitleForAuthorizationPageToContinueTo = dataSourceManager.getDataValue(1);
		dataSourceManager.closeIO();
	}

	@Test(priority = 1)
	public void NUCP193() {

		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-193:" + "\n"
				+ "Summary: Verify that the application redirects to the proper Auth page with the proper elements pending to authorize when the user click on the authorization links for apps and portlets");

		loginPage.setCredentials(userName, password);
		loginPage.loginClick();
		homePage.goToHomePage();

		loginPage.getDriverManager().driverLongWait();

		// Verifying if we are positioned on the landing page
		Assert.assertTrue(homePage.getDriver().getCurrentUrl().equals(
				constantsPropertiesManager.getSharedExecutionConstants().getProperty("northeastern.edu_homepageurl")));
		// Waiting for the web browser, it should loads all the elements on the
		// DOM
		homePage.getDriverManager().driverShortWait();
		
		String parentHandle = homePage.getDriverManager().getDriver().getWindowHandle(); // get the current window handle
		
		// Verifying if the Element to be clicked is present on the DOM
		Assert.assertTrue(homePage.isGmailPortletPresent());
		Assert.assertTrue(homePage.isAuthorizeButtonPresent());

		homePage.authorizeButtonClick();
		
		Set<String> handles = homePage.getDriverManager().getDriver().getWindowHandles();
		handles.remove(parentHandle);

		String winHandle = handles.iterator().next();
		homePage.getDriverManager().getDriver().switchTo().window(winHandle);
		
		homePage.getDriverManager().driverShortWait();
		
		Assert.assertTrue(homePage.getDriverManager().getDriver().getCurrentUrl()
				.contains(expectedBaseUrlAuthorizationPage));
		Assert.assertTrue(homePage.isNorteasternLinkPresent());
		Assert.assertTrue(homePage.getNorteasternLinkElement().getText().equalsIgnoreCase(expectedTitleForAuthorizationPageToContinueTo));

		homePage.norteasternLinkClick();

		Alert alert = homePage.getDriverManager().getDriver().switchTo().alert();
		Assert.assertTrue(alert.getText().contains(expectedURLForAuthorizationPageToContinueToTitleDescription));
		alert.accept();
		
		homePage.getDriverManager().getDriver().switchTo().window(winHandle).close();
		homePage.getDriverManager().getDriver().switchTo().window(parentHandle);

	}

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}
}
