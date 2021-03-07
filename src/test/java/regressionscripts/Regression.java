package regressionscripts;


import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.excel1;
import generic.generic_test;
import pom.Enter_Time_Track_Page;
import pom.Login_Page;
import pom.ReportBugPage;

public class Regression extends generic_test {
		@Test
		public void validLoginLogout()
		{
			String username = excel1.readData("regression",1,0);
			String password = excel1.readData("regression", 1, 1);
			String hp_title = excel1.readData("regression", 1, 2);
			Login_Page lp = new Login_Page(driver);
			lp.setUsername(username);
			lp.setPassword(password);
			lp.clickLogin();
			Enter_Time_Track_Page ep = new Enter_Time_Track_Page(driver);
			ep.verifyTitle(hp_title, 5);
			ep.clickLogout();
		}
		@Test
		public void InvalidLogin()
		{
			String username = excel1.readData("regression",2,0);
			String password = excel1.readData("regression", 2, 1);
			String lp_title = excel1.readData("regression", 2, 2);
			Login_Page lp = new Login_Page(driver);
			lp.setUsername(username);
			lp.setPassword(password);
			lp.clickLogin();
			lp.verifyErrorMessage();
			lp.verifyTitle(lp_title, 5);
		}
		@Test
		public void VerifyActitimeVersion()
		{
			String username = excel1.readData("regression",3,0);
			String password = excel1.readData("regression", 3, 1);
			String eVersion = excel1.readData("regression", 3, 4);
			Login_Page lp = new Login_Page(driver);
			lp.setUsername(username);
			lp.setPassword(password);
			lp.clickLogin();
			Enter_Time_Track_Page ep = new Enter_Time_Track_Page(driver);
			ep.clickHelp();
			ep.clickAboutActitime();
			String aVersion = ep.getActitimeVersion();
			Assert.assertEquals(aVersion, eVersion);
			ep.clickClose();
			ep.clickLogout();
		}
		@Test
		public void SendBugReport()
		{
			String username = excel1.readData("regression",4,0);
			String password = excel1.readData("regression", 4, 1);
			String bugSummary = excel1.readData("regression", 4, 5);
			String fn=excel1.readData("regression", 4, 6);
			String ln=excel1.readData("regression", 4, 7);
			String email=excel1.readData("regression", 4, 8);
			String company=excel1.readData("regression", 4, 9);
			Login_Page lp = new Login_Page(driver);
			lp.setUsername(username);
			lp.setPassword(password);
			lp.clickLogin();
			Enter_Time_Track_Page ep = new Enter_Time_Track_Page(driver);
			ep.clickHelp();
			ep.clickReportBug();
			ep.verifyTab(2,5);
			Set<String> all_window = driver.getWindowHandles();
			for(String win:all_window)
			{
				driver.switchTo().window(win);
			}
			ReportBugPage rbp = new ReportBugPage(driver);
			rbp.enterBugDescription(bugSummary);
			rbp.enterFirstName(fn);
			rbp.enterLastName(ln);
			rbp.enterCompany(company);
			rbp.enterEmail(email);
			rbp.clickSend();
		}
		
}
