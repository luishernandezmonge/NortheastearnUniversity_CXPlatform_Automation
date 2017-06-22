package northeasternunversity.cxplatform.employeeportaltestcases.appsandlinks;

import java.util.List;
import northeasternuniversity.cxplatform.pages.general.*;
import northeasternuniversity.cxplatform.webdriver.*;
import northeasternuniversity.cxplatform.constants.*;
import northeasternuniversity.cxplatform.pages.staffemployeeportal.*;
import northeasternuniversity.cxplatform.utilities.PageChecker;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppsAndLinksTestCases {

	LoginPage loginPage;
	HomePage homePage;
	AppsAndLinksPage appsAndLinksPage;
	PageChecker pageChecker;

	WebDriverManager driverManager;
	UIElementsPropertiesManager UIElementsPropertiesManager;
	ConstantsPropertiesManager constantsPropertiesManager;
	DataSourceManager dataSourceManager;

	int userNameIndex;
	int passwordIndex;
	String userName;
	String password;

	String expectedURLPage;
	String expectedURLForJumpToLibrary;
	String expectedURLForJumpToHumanResources;
	String expectedURLForJumpToAcademicResources;
	String expectedURLForJumpToBenefits;
	String expectedDataForHeroTitle;
	String expectedDataForHeroText;
	String expectedWordForSearchAppsResults;

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
		this.pageChecker = new PageChecker();

		int userNameIndex = Integer
				.parseInt(constantsPropertiesManager.getSharedExecutionConstants().getProperty("userNameIndex"));
		int passwordIndex = Integer
				.parseInt(constantsPropertiesManager.getSharedExecutionConstants().getProperty("passwordIndex"));

		this.userName = dataSourceManager.getDataValue(userNameIndex);
		this.password = dataSourceManager.getDataValue(passwordIndex);

		this.dataSourceManager = new DataSourceManager(FilesLocations.TESTUSERSDATASOURCEFILEPATH,
				"OptionsAndExpectedURLS", 1);
		this.expectedURLPage = dataSourceManager.getDataValue(1);

		this.dataSourceManager.setTestDataRow(2);
		this.expectedURLForJumpToLibrary = dataSourceManager.getDataValue(1);
		this.dataSourceManager.setTestDataRow(3);
		this.expectedURLForJumpToHumanResources = dataSourceManager.getDataValue(1);
		this.dataSourceManager.setTestDataRow(4);
		this.expectedURLForJumpToAcademicResources = dataSourceManager.getDataValue(1);
		this.dataSourceManager.setTestDataRow(5);
		this.expectedURLForJumpToBenefits = dataSourceManager.getDataValue(1);
		this.dataSourceManager.setTestDataRow(12);
		this.expectedDataForHeroTitle = dataSourceManager.getDataValue(1);
		this.dataSourceManager.setTestDataRow(13);
		this.expectedDataForHeroText = dataSourceManager.getDataValue(1);
		this.dataSourceManager.setTestDataRow(15);
		this.expectedWordForSearchAppsResults = dataSourceManager.getDataValue(1);
		dataSourceManager.closeIO();
	}

	@Test(priority = 1)
	public void NUCP49() {

		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-49:" + "\n"
				+ "Summary: Verify that the application redirects to the proper page when a link is clicked on the Apps section of Apps&Links page");

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

		// Verifying if the Element to be clicked is present on the DOM
		Assert.assertTrue(appsAndLinksPage.isAppsPortletDivElementPresent());
		Assert.assertTrue(appsAndLinksPage.hasAppsElements());

		if (appsAndLinksPage.hasAppsElements()) {
			appsAndLinksPage.getDriverManager().driverLongWait();
			List<WebElement> AppsList = this.appsAndLinksPage.getAllElementsOnAppsPortletList();
			for (WebElement divParentElement : AppsList) {

				WebElement AppNameLinkElement = divParentElement
						.findElement(By.xpath("a[contains(@class,'app-name')]"));
				WebElement AppImageLinkElement = divParentElement.findElement(By.xpath("a[@class='anchor-image']"));

				Assert.assertTrue(appsAndLinksPage.compareHREFAttributeOfAppClickableDivElements(AppNameLinkElement,
						AppImageLinkElement));
				Assert.assertTrue(appsAndLinksPage.hyperLinkHasTargetBlankAttribute(AppNameLinkElement));
				Assert.assertTrue(appsAndLinksPage.hyperLinkHasTargetBlankAttribute(AppImageLinkElement));

				// pageChecker.printHttpResponse(AppNameLinkElement.getAttribute("href"));
				Assert.assertTrue(pageChecker.isSuccessResponse(AppNameLinkElement.getAttribute("href")));
			}
		}

	}

	// @Test(priority = 2, dependsOnMethods = { "NUCP49" })
	@Test(priority = 2)
	public void NUCP53() {
		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-53:" + "\n"
				+ "Summary: Verify that the application displays more Human Resources properly when “See All Others +” link is clicked");

		// Waiting for the web browser, it should loads all the new elements on
		// the DOM
		homePage.getDriverManager().driverLongWait();
		// Verifying if the Element to be clicked is present on the DOM
		Assert.assertTrue(appsAndLinksPage.isMostRelevantHumanResourcesDivElementPresent());
		Assert.assertTrue(appsAndLinksPage.isSeeAllOthersHumanResourcesLinkElementPresent());
		Assert.assertTrue(appsAndLinksPage.hasMostRelevantHumanResourcesLinks());

		if (appsAndLinksPage.hasMostRelevantHumanResourcesLinks()) {
			int mostRelevantHumanResourcesLinksAmountBeforeClick = this.appsAndLinksPage
					.getAllElementsOnMostRelevanHumanResourcesLinks().size();
			appsAndLinksPage.seeAllOthersHumanResourcesLinkClick();
			appsAndLinksPage.getDriverManager().driverShortWait();
			int mostRelevantHumanResourcesLinksAmountAfterClick = this.appsAndLinksPage
					.getAllElementsOnMostRelevanHumanResourcesLinks().size();
			Assert.assertNotEquals(mostRelevantHumanResourcesLinksAmountBeforeClick,
					mostRelevantHumanResourcesLinksAmountAfterClick);
		}

		Assert.assertFalse(appsAndLinksPage.isSeeAllOthersHumanResourcesLinkElementPresent());

	}

	// @Test(priority = 3, dependsOnMethods = { "NUCP53" })
	@Test(priority = 2)
	public void NUCP54() {
		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-54:" + "\n"
				+ "Summary: Verify that the application redirects to the proper page when a link is clicked on the Human Resources/Related Categories section of Apps&Links page");

		// Waiting for the web browser, it should loads all the new elements on
		// the DOM
		homePage.getDriverManager().driverLongWait();
		// Verifying if the Element to be clicked is present on the DOM
		Assert.assertTrue(appsAndLinksPage.isRelatedCategoriesHumanResourcesDivElementPresent());
		Assert.assertTrue(appsAndLinksPage.hasRelatedCategoriesHumanResourcesLinks());

		if (appsAndLinksPage.hasRelatedCategoriesHumanResourcesLinks()) {
			List<WebElement> relatedCategoriesList = this.appsAndLinksPage
					.getAllElementsOnRelatedCategoriesHumanResourcesLinks();
			for (WebElement element : relatedCategoriesList) {
				String elementText = element.findElement(By.xpath("a")).getText();
				String elementHREF = element.findElement(By.xpath("a")).getAttribute("href");

				if (elementText.trim().equalsIgnoreCase("Benefits"))
					Assert.assertTrue(elementHREF.equalsIgnoreCase(this.expectedURLForJumpToBenefits));
				else if (elementText.trim().equalsIgnoreCase("Library"))
					Assert.assertTrue(elementHREF.equalsIgnoreCase(this.expectedURLForJumpToLibrary));
				else if (elementText.trim().equalsIgnoreCase("Academic Resources"))
					Assert.assertTrue(elementHREF.equalsIgnoreCase(this.expectedURLForJumpToAcademicResources));
				else
					Assert.assertTrue(false);

			}
		}

	}

	// @Test(priority = 4, dependsOnMethods = { "NUCP54" })
	@Test(priority = 2)
	public void NUCP56() {
		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-56:" + "\n"
				+ "Summary: Verify that the application displays more Benefits properly when “See All Others +” link is clicked");

		// Waiting for the web browser, it should loads all the new elements on
		// the DOM
		homePage.getDriverManager().driverLongWait();
		// Verifying if the Element to be clicked is present on the DOM
		Assert.assertTrue(appsAndLinksPage.isMostRelevantBenefitsDivElementPresent());
		Assert.assertTrue(appsAndLinksPage.isSeeAllOthersBenefitsLinkElementPresent());
		Assert.assertTrue(appsAndLinksPage.hasMostRelevantBenefitsLinks());

		if (appsAndLinksPage.hasMostRelevantBenefitsLinks()) {
			int mostRelevantBenefitsLinksAmountBeforeClick = this.appsAndLinksPage
					.getAllElementsOnMostRelevanBenefitsLinks().size();
			appsAndLinksPage.seeAllOthersBenefitsLinkClick();
			appsAndLinksPage.getDriverManager().driverShortWait();
			int mostRelevantBenefitsLinksAmountAfterClick = this.appsAndLinksPage
					.getAllElementsOnMostRelevanBenefitsLinks().size();
			Assert.assertNotEquals(mostRelevantBenefitsLinksAmountBeforeClick,
					mostRelevantBenefitsLinksAmountAfterClick);
		}

		Assert.assertFalse(appsAndLinksPage.isSeeAllOthersBenefitsLinkElementPresent());

	}

	// @Test(priority = 5, dependsOnMethods = { "NUCP56" })
	@Test(priority = 2)
	public void NUCP57() {
		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-57:" + "\n"
				+ "Summary: Verify that the application redirects to the proper page when a link is clicked on the Benefits/Related Categories section of Apps&Links page");

		// Waiting for the web browser, it should loads all the new elements on
		// the DOM
		homePage.getDriverManager().driverLongWait();
		// Verifying if the Element to be clicked is present on the DOM
		Assert.assertTrue(appsAndLinksPage.isRelatedCategoriesBenefitsDivElementPresent());
		Assert.assertTrue(appsAndLinksPage.hasRelatedCategoriesBenefitsLinks());

		if (appsAndLinksPage.hasRelatedCategoriesBenefitsLinks()) {
			List<WebElement> relatedCategoriesList = this.appsAndLinksPage
					.getAllElementsOnRelatedCategoriesBenefitsLinks();
			for (WebElement element : relatedCategoriesList) {
				String elementText = element.findElement(By.xpath("a")).getText();
				String elementHREF = element.findElement(By.xpath("a")).getAttribute("href");

				if (elementText.trim().equalsIgnoreCase("Human Resources"))
					Assert.assertTrue(elementHREF.equalsIgnoreCase(this.expectedURLForJumpToHumanResources));
				else if (elementText.trim().equalsIgnoreCase("Library"))
					Assert.assertTrue(elementHREF.equalsIgnoreCase(this.expectedURLForJumpToLibrary));
				else if (elementText.trim().equalsIgnoreCase("Academic Resources"))
					Assert.assertTrue(elementHREF.equalsIgnoreCase(this.expectedURLForJumpToAcademicResources));
				else
					Assert.assertTrue(false);

			}
		}

	}

	// @Test(priority = 6, dependsOnMethods = { "NUCP57" })
	@Test(priority = 2)
	public void NUCP173() {
		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-173:" + "\n"
				+ "Summary: Verify that the application displays more Library items properly when “See All Others +” link is clicked");

		// Waiting for the web browser, it should loads all the new elements on
		// the DOM
		homePage.getDriverManager().driverLongWait();
		// Verifying if the Element to be clicked is present on the DOM
		Assert.assertTrue(appsAndLinksPage.isMostRelevantLibraryDivElementPresent());
		Assert.assertTrue(appsAndLinksPage.isSeeAllOthersLibraryLinkElementPresent());
		Assert.assertTrue(appsAndLinksPage.hasMostRelevantLibraryLinks());

		if (appsAndLinksPage.hasMostRelevantLibraryLinks()) {
			int mostRelevantLibraryLinksAmountBeforeClick = this.appsAndLinksPage
					.getAllElementsOnMostRelevanLibraryLinks().size();
			appsAndLinksPage.seeAllOthersLibraryLinkClick();
			appsAndLinksPage.getDriverManager().driverShortWait();
			int mostRelevantLibraryLinksAmountAfterClick = this.appsAndLinksPage
					.getAllElementsOnMostRelevanLibraryLinks().size();
			Assert.assertNotEquals(mostRelevantLibraryLinksAmountBeforeClick, mostRelevantLibraryLinksAmountAfterClick);
		}

		Assert.assertFalse(appsAndLinksPage.isSeeAllOthersLibraryLinkElementPresent());

	}

	// @Test(priority = 7, dependsOnMethods = { "NUCP173" })
	@Test(priority = 2)
	public void NUCP174() {
		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-174:" + "\n"
				+ "Summary: Verify that the application redirects to the proper page when a link is clicked on the Library/Related Categories section of Apps&Links page");

		// Waiting for the web browser, it should loads all the new elements on
		// the DOM
		homePage.getDriverManager().driverLongWait();
		// Verifying if the Element to be clicked is present on the DOM
		Assert.assertTrue(appsAndLinksPage.isRelatedCategoriesLibraryDivElementPresent());
		Assert.assertTrue(appsAndLinksPage.hasRelatedCategoriesLibraryLinks());

		if (appsAndLinksPage.hasRelatedCategoriesLibraryLinks()) {
			List<WebElement> relatedCategoriesList = this.appsAndLinksPage
					.getAllElementsOnRelatedCategoriesLibraryLinks();
			for (WebElement element : relatedCategoriesList) {
				String elementText = element.findElement(By.xpath("a")).getText();
				String elementHREF = element.findElement(By.xpath("a")).getAttribute("href");

				if (elementText.trim().equalsIgnoreCase("Human Resources"))
					Assert.assertTrue(elementHREF.equalsIgnoreCase(this.expectedURLForJumpToHumanResources));
				else if (elementText.trim().equalsIgnoreCase("Benefits"))
					Assert.assertTrue(elementHREF.equalsIgnoreCase(this.expectedURLForJumpToBenefits));
				else if (elementText.trim().equalsIgnoreCase("Academic Resources"))
					Assert.assertTrue(elementHREF.equalsIgnoreCase(this.expectedURLForJumpToAcademicResources));
				else
					Assert.assertTrue(false);

			}
		}

	}

	// @Test(priority = 6, dependsOnMethods = { "NUCP174" })
	@Test(priority = 2)
	public void NUCP178() {
		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-178:" + "\n"
				+ "Summary: Verify that the application displays more Academic Resources properly when “See All Others +” link is clicked");

		// Waiting for the web browser, it should loads all the new elements on
		// the DOM
		homePage.getDriverManager().driverLongWait();
		// Verifying if the Element to be clicked is present on the DOM
		Assert.assertTrue(appsAndLinksPage.isMostRelevantAcademicResourcesDivElementPresent());
		Assert.assertTrue(appsAndLinksPage.isSeeAllOthersAcademicResourcesLinkElementPresent());
		Assert.assertTrue(appsAndLinksPage.hasMostRelevantAcademicResourcesLinks());

		if (appsAndLinksPage.hasMostRelevantAcademicResourcesLinks()) {
			int mostRelevantAcademicResourcesLinksAmountBeforeClick = this.appsAndLinksPage
					.getAllElementsOnMostRelevanAcademicResourcesLinks().size();
			appsAndLinksPage.seeAllOthersAcademicResourcesLinkClick();
			appsAndLinksPage.getDriverManager().driverShortWait();
			int mostRelevantAcademicResourcesLinksAmountAfterClick = this.appsAndLinksPage
					.getAllElementsOnMostRelevanAcademicResourcesLinks().size();
			Assert.assertNotEquals(mostRelevantAcademicResourcesLinksAmountBeforeClick,
					mostRelevantAcademicResourcesLinksAmountAfterClick);
		}

		Assert.assertFalse(appsAndLinksPage.isSeeAllOthersAcademicResourcesLinkElementPresent());

	}

	// @Test(priority = 7, dependsOnMethods = { "NUCP178" })
	@Test(priority = 2)
	public void NUCP179() {
		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-179:" + "\n"
				+ "Summary: Verify that the application redirects to the proper page when a link is clicked on the Academic Resources/Related Categories section of Apps&Links page");

		// Waiting for the web browser, it should loads all the new elements on
		// the DOM
		homePage.getDriverManager().driverLongWait();
		// Verifying if the Element to be clicked is present on the DOM
		Assert.assertTrue(appsAndLinksPage.isRelatedCategoriesAcademicResourcesDivElementPresent());
		Assert.assertTrue(appsAndLinksPage.hasRelatedCategoriesAcademicResourcesLinks());

		if (appsAndLinksPage.hasRelatedCategoriesAcademicResourcesLinks()) {
			List<WebElement> relatedCategoriesList = this.appsAndLinksPage
					.getAllElementsOnRelatedCategoriesAcademicResourcesLinks();
			for (WebElement element : relatedCategoriesList) {
				String elementText = element.findElement(By.xpath("a")).getText();
				String elementHREF = element.findElement(By.xpath("a")).getAttribute("href");

				if (elementText.trim().equalsIgnoreCase("Human Resources"))
					Assert.assertTrue(elementHREF.equalsIgnoreCase(this.expectedURLForJumpToHumanResources));
				else if (elementText.trim().equalsIgnoreCase("Library"))
					Assert.assertTrue(elementHREF.equalsIgnoreCase(this.expectedURLForJumpToLibrary));
				else if (elementText.trim().equalsIgnoreCase("Benefits"))
					Assert.assertTrue(elementHREF.equalsIgnoreCase(this.expectedURLForJumpToBenefits));
				else
					Assert.assertTrue(false);

			}
		}

	}

	// @Test(priority = 8, dependsOnMethods = { "NUCP179" })
	@Test(priority = 2)
	public void NUCP59() {
		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-59:" + "\n"
				+ "Summary: Verify that the application displays the proper hero page data according with configured for Apps&Links page");

		// Waiting for the web browser, it should loads all the new elements on
		// the DOM
		homePage.getDriverManager().driverLongWait();
		// Verifying if the Element to be clicked is present on the DOM
		Assert.assertTrue(appsAndLinksPage.isHeroTitleElementPresent());
		Assert.assertTrue(appsAndLinksPage.isHeroTextElementPresent());

		Assert.assertTrue(appsAndLinksPage.isTheCorrectDataForHeroTitle(expectedDataForHeroTitle));
		Assert.assertTrue(appsAndLinksPage.isTheCorrectDataForHeroText(expectedDataForHeroText));
	}

	@Test(priority = 2)
	public void NUCP156() {
		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-156:" + "\n"
				+ "Summary: Verify that the application displays properly the info on the tooltip cloud when the user position the pointer over a link info icon");

		// Waiting for the web browser, it should loads all the new elements on
		// the DOM
		homePage.getDriverManager().driverLongWait();

		Assert.assertTrue(appsAndLinksPage.isMostRelevantAcademicResourcesDivElementPresent());

		if (appsAndLinksPage.hasMostRelevantAcademicResourcesLinks()) {
			List<WebElement> listOfMostRelevantAcademicResourcesList = this.appsAndLinksPage
					.getAllElementsOnMostRelevanAcademicResourcesLinks();

			for (WebElement parentDivElement : listOfMostRelevantAcademicResourcesList) {
				appsAndLinksPage.getDriverManager().driverShortWait();

				// move over the element
				Actions actions = new Actions(this.appsAndLinksPage.getDriverManager().getDriver());
				actions.moveToElement(parentDivElement).build().perform();

				WebElement infoIconElement = parentDivElement.findElement(By.xpath("i"));
				WebElement toolTipCloudElement = parentDivElement
						.findElement(By.xpath("i/div[contains(@class,'tooltip')]"));

				actions.moveToElement(infoIconElement).build().perform();
				Assert.assertTrue(infoIconElement.isDisplayed());

				infoIconElement.click();
				driverManager.driverShortWait();

				Assert.assertTrue(toolTipCloudElement.isDisplayed());
			}

		}

	}

	@Test(priority = 2)
	public void NUCP60() {
		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-60:" + "\n"
				+ "Summary: Verify that the application allows to filter and search Apps when valid keywords are provided on the search box");

		// Waiting for the web browser, it should loads all the new elements on
		// the DOM
		homePage.getDriverManager().driverLongWait();

		Assert.assertTrue(appsAndLinksPage.isSearchAppsPortletPresent());
		Assert.assertTrue(appsAndLinksPage.isSearchAppsBoxPresent());

		appsAndLinksPage.setAppsSearchCriteria(expectedWordForSearchAppsResults);
		appsAndLinksPage.getDriverManager().driverShortWait();

		Assert.assertTrue(appsAndLinksPage.isSearchAppsResultsListPresentAndDisplayed());
		if (appsAndLinksPage.hasAppsSearchResultItems()) {
			List<WebElement> appsSearchResults = appsAndLinksPage.getAllAppsSearchResultItems();

			for (WebElement parentDivElement : appsSearchResults) {
				WebElement appTextElement = parentDivElement
						.findElement(By.xpath("div/div[contains(@class,'text-field')]/p"));
				WebElement appDescriptionElement = parentDivElement
						.findElement(By.xpath("div/div[contains(@class,'card-col-gutters')]/p"));

				Assert.assertTrue(appTextElement.getText().contains(expectedWordForSearchAppsResults));
				Assert.assertTrue(appDescriptionElement.getText().contains(expectedWordForSearchAppsResults));
			}
		}

	}
	
	@Test(priority = 3, dependsOnMethods = { "NUCP60" })
	public void NUCP61() {
		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-61:" + "\n"
				+ "Summary: Verify that the application allows to clear the search box and the results when the “x” icon is clicked");

		// Waiting for the web browser, it should loads all the new elements on
		// the DOM
		appsAndLinksPage.getDriverManager().driverLongWait();

		Assert.assertTrue(appsAndLinksPage.isSearchAppsResultsListPresentAndDisplayed());
	
		Assert.assertTrue(appsAndLinksPage.isSearchAppsCloseResultsButtonPresentAndDisplayed());
		
		appsAndLinksPage.searchAppsCloseResultsButtonClick();
		appsAndLinksPage.getDriverManager().driverShortWait();
		
		Assert.assertFalse(appsAndLinksPage.isSearchAppsResultsListPresentAndDisplayed());

	}

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}
}
