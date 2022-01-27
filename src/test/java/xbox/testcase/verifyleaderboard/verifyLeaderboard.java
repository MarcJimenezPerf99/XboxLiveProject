package xbox.testcase.verifyleaderboard;

import org.testng.annotations.Test;

import java.util.Properties;

import org.testng.Assert;

import util.FunctionUtil;
import util.SystemUtil;
import util.TestCaseBase;
import xbox.basepages.xboxLeaderboardPage;
import xbox.basepages.xboxGamertagPage;

public class verifyLeaderboard extends TestCaseBase {
  
	@Test(groups = { "firefox", "ChromeWin32", "IEWin32"})
	public void verifyLeaderboardTest() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Marc.Jimenez\\Downloads\\chromedriver_win32\\chromedriver.exe");		
		xboxLeaderboardPage leaderboardPage = new xboxLeaderboardPage();
		leaderboardPage.open();
//		leaderboardPage.waitPageLoad();
		Assert.assertTrue(leaderboardPage.titleIs(xboxLeaderboardPage.TITLE));
		
		xboxGamertagPage firstPlaceGamer = leaderboardPage.goToFirstPlace();
//		Properties PROPERTIES_RESOURCES = SystemUtil.loadPropertiesResources("/testdata_xboxleaderboard.properties");
//		String expectedGamerscore = PROPERTIES_RESOURCES.getProperty("firstPlaceGS");
//		Assert.assertEquals(firstPlaceGamer.getGamerscore(), expectedGamerscore);	
	}
}
