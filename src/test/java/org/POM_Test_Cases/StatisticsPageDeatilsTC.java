package org.POM_Test_Cases;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.POM_Pages.StatsPage;
import org.ScreenShots.GetScreenShot;
import org.Utilities.GenericMethods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StatisticsPageDeatilsTC {

	GenericMethods gm = new GenericMethods();
	WebDriver driver;
	Properties prop = gm.getProp();

	@BeforeMethod
	public void initializeBrowser() {
		driver = gm.startUP(prop.getProperty("Browsername"), prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 1)
	public void verifyThatStatisticsPageIsDisplay() {

		Assert.assertEquals(driver.getTitle(), "Players Stats and Records | IPLT20", "Title is not verifed");
		Reporter.log("Stats Page Title Verified Successfully = " + driver.getTitle());

		Assert.assertEquals(driver.getCurrentUrl(), "https://www.iplt20.com/stats/2023", "URL is Not Verified");
		Reporter.log("Stats Page URL Verified Successfully = " + driver.getCurrentUrl());

		Reporter.log("Stats Page is Displayed successfully");

	}

	@Test(priority = 2)
	public void verifyThatSearchFunctionalityOfStatsPage() {

		StatsPage obj = new StatsPage(driver);

		obj.ClickOnAcceptCoockieButton();
		Reporter.log("Cookie accepted successfully");

		Assert.assertEquals(obj.searchFunctionalityIsDisplay(), true);
		Reporter.log("Search Functionality is Displayed Successfully");
		Assert.assertEquals(obj.searchFunctionalityIsEnabled(), true);
		Reporter.log("Search Functionality is Enabled Successfully");

	}

	@Test(priority = 3)
	public void verifyThatShubhmanGillsDetailsOnStatsPage() {

		StatsPage obj1 = new StatsPage(driver);

		Assert.assertEquals(obj1.getTextOfPlayerName(), "Shubman Gill");
		Reporter.log("player name as Shubman Gill is verified Successfully");

		Assert.assertEquals(obj1.getTextOfTeamName(), "GT");
		Reporter.log("team name as GT is verified Successfully");
	} 
	
	@Test (priority = 4)
	public void verifyThatShubhmanGillsStatisticsDetailsOnStatsPage() {

		StatsPage obj2 = new StatsPage(driver);

		Assert.assertEquals(obj2.getTotalRunsOfGill(), "890");
		Reporter.log("Total runs of Shubman Gill is verified Successfully");

		Assert.assertEquals(obj2.getHighestScoreOfGill(), "129");
		Reporter.log("Highest Score of Shubman Gill is verified Successfully");
		
		Assert.assertEquals(obj2.getAverageScoreOfGill(), "59.33");
		Reporter.log("Average Score of Shubman Gill is verified Successfully");
		
		Assert.assertEquals(obj2.getStrikeRateOfGill(), "157.80");
		Reporter.log("Strike Rate of Shubman Gill is verified Successfully");
		
		Assert.assertEquals(obj2.getSixesCountOfGill(), "33");
		Reporter.log("Sixes Count of Shubman Gill is verified Successfully");
	}

	@AfterMethod
	public void CloseBrowser(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			GetScreenShot.takesScreenShot(driver, result.getName());
		}
		driver.quit();

	}
}
