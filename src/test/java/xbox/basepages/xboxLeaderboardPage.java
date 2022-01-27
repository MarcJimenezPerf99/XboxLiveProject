package xbox.basepages;

import java.util.List;
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

public class xboxLeaderboardPage extends Page {
  
	public static String TITLE="Xbox Leaderboards - Xbox Gamertag";
	
//
	@FindBy(xpath = "//div[@class='row']/div[1]/div/a")
	public WebElement FirstPlace;

	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[3]/a")
	public WebElement SecondPlace;
	
	public xboxLeaderboardPage open() throws Exception {
		
		Properties PROPERTIES_RESOURCES = SystemUtil.loadPropertiesResources("/testdata_xboxleaderboard.properties");
		String URL = PROPERTIES_RESOURCES.getProperty("xboxleaderboard.url");
		TestCaseBase.threadDriver.get().navigate().to(URL);
		return this;
	}
	
	public xboxLeaderboardPage waitPageLoad() {
		
		if (FunctionUtil.isExist(FirstPlace)) {
			Waiting.until(FirstPlace, 5000);
		}
		return this;
	}
	

	
	public xboxGamertagPage goToFirstPlace() throws InterruptedException {
//		Waiting.until(FirstPlace, 5000);
		System.out.println("Going to firstplace...");
		Waiting.until(FirstPlace);
//		Actions actions = new Actions(TestCaseBase.threadDriver);
		FirstPlace.click();
//		Thread.sleep(10000);
		return new xboxGamertagPage();
	}
}
