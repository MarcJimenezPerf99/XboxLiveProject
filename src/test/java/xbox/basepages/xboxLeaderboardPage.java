package xbox.basepages;

import java.util.Properties;

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
	
	@FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div[3]/a")
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
		Waiting.until(FirstPlace);
		System.out.println("Going to firstplace...");
		Thread.sleep(2000);
		FirstPlace.click();
		return new xboxGamertagPage();
	}
}
