package xbox.basepages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import util.FunctionUtil;
import util.Page;
import util.SystemUtil;
import util.TestCaseBase;
import util.Waiting;

public class xboxGamertagPage extends Page {

	Properties PROPERTIES_RESOURCES = SystemUtil.loadPropertiesResources("/testdata_xboxleaderboard.properties");
	String firstPlaceGT = PROPERTIES_RESOURCES.getProperty("firstPlaceGT");
	
//	@FindBy(xpath = "/html/body/div[1]/div[1]/div/div/div[2]/div/div[2]/div/div[1]/text()")
	@FindBy(linkText = "firstPlaceGT")
	public WebElement gamerscore; 
	//	public WebElement gamerscore = TestCaseBase.threadDriver.findElements(By.xpath(''));
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/div/div/div[2]/div/div[1]/div/h1/a")
	public WebElement gamertag;
	
	public String getGamerscore() {
		System.out.println("Getting Gamerscore...");
		return gamerscore.getText();
	}
	
	public String getGamertag() {
		System.out.println("Getting Gamertag...");
		return gamertag.getText();
	}
	
}
