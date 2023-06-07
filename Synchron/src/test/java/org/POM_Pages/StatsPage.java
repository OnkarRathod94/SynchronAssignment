package org.POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StatsPage {

	@FindBy(xpath = "//input[@placeholder='Search By Player Name']")
	private WebElement searchFieldText;

	@FindBy(css = ".cookie__accept.cookie__accept_btn")
	private WebElement acceptCoockie;

	@FindBy(xpath = "//div[text()='Shubman Gill']")
	private WebElement playerName;

	@FindBy(xpath = "//div[text()='GT']")
	private WebElement teamName;
	
	@FindBy(xpath = "//td[text()='890']")
	private WebElement totalRuns;
	
	@FindBy(xpath = "//td[text()='129']")
	private WebElement highestScore;
	
	@FindBy(xpath = "//td[text()='59.33']")
	private WebElement average;
	
	@FindBy(xpath = "//td[text()='157.80']")
	private WebElement strikeRate;
	
	@FindBy(xpath = "//td[text()='33']")
	private WebElement sixesCount;
	

	// constructor

	public StatsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// page action methods.

	public boolean searchFunctionalityIsDisplay() {
		return searchFieldText.isDisplayed();
	}
	
	public boolean searchFunctionalityIsEnabled() {
		return searchFieldText.isEnabled();
	}

	public void ClickOnAcceptCoockieButton() {
		acceptCoockie.click();
	}

	public String getTextOfPlayerName() {
		return playerName.getText();
	}

	public String getTextOfTeamName() {
		return teamName.getText();
	}
	
	public String getTotalRunsOfGill() {
		return totalRuns.getText();
	}
	
	public String getHighestScoreOfGill() {
		return highestScore.getText();
	}
	
	public String getAverageScoreOfGill() {
		return average.getText();
	}
	public String getStrikeRateOfGill() {
		return strikeRate.getText();
	}
	
	public String getSixesCountOfGill() {
		return sixesCount.getText();
	}
}
